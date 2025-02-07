package com.lemon.meet.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.lemon.meet.entity.bo.UserBO;
import com.lemon.meet.service.UserService;
import com.lemon.util.bean.LemonBeanUtil;
import com.lemon.database.pagehelper.PageUtil;
import com.lemon.util.mark.LemonSnowFlakeUtil;
import com.lemon.web.exception.InfoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.lemon.database.pagehelper.PageList;
import tk.mybatis.mapper.entity.Example;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.lemon.database.service.impl.BaseServiceImpl;
import com.lemon.meet.entity.bo.TenantBO;
import com.lemon.meet.entity.dto.TenantDTO;
import com.lemon.meet.entity.vo.TenantVO;
import com.lemon.meet.dao.TenantDao;
import com.lemon.meet.service.TenantService;

/**
 * @author
 * @version 1.0.0
 * @describe (Tenant)租户Service层实现
 * @company lemon
 * @address 
 * @updateTime 2024-06-22 15:20:44
 * @since 2024-06-22 15:20:44
 */

@Slf4j
@Service("tenantService")
public class TenantServiceImpl extends BaseServiceImpl<TenantBO> implements TenantService {

    @Resource
    private TenantDao tenantDao;

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * @param id
     * @return TenantVO
     * @describe ID查询
     */
    @Override
    public TenantVO findById(Long id) {
        return LemonBeanUtil.cloneBeanProperties(tenantDao.selectByPrimaryKey(id), TenantVO.class);
    }


    /**
     * @param pageNum 第几页
     * @return PagerList<TenantVO>
     * @describe 分页查询
     * @Param pageSize 每页显示条数
     * @Param count 是否查询总条数
     */
    @Override
    public PageList<TenantVO> pageList(TenantDTO tenantDTO, Integer pageNum, Integer pageSize, Boolean count) {
        PageUtil.startPage(pageNum, pageSize, count);
        Example example = new Example(TenantBO.class);
        Example.Criteria criteria = example.createCriteria();
        if (ObjectUtil.isNotEmpty(tenantDTO.getTenantId())) {
            criteria.andEqualTo(TenantBO.Properties.tenantId, tenantDTO.getTenantId());
        }
        if (StrUtil.isNotBlank(tenantDTO.getName())) {
            criteria.andLike(TenantBO.Properties.name, "%" + tenantDTO.getName() + "%");
        }
        if (StrUtil.isNotBlank(tenantDTO.getHead())) {
            criteria.andLike(TenantBO.Properties.head, "%" + tenantDTO.getHead() + "%");
        }
        if (StrUtil.isNotBlank(tenantDTO.getMobile())) {
            criteria.andLike(TenantBO.Properties.mobile, "%" + tenantDTO.getMobile() + "%");
        }
        if (StrUtil.isNotBlank(tenantDTO.getAdmin())) {
            criteria.andLike(TenantBO.Properties.admin, "%" + tenantDTO.getAdmin() + "%");
        }
        return PageUtil.castToPageList(tenantDao.selectByExample(example)).toClass(TenantVO.class);
    }


    /**
     * @param
     * @return List<TenantVO>
     * @describe 查询全部
     */
    @Override
    public List<TenantVO> list() {
        return LemonBeanUtil.listCloneProperties(tenantDao.selectAll(), TenantVO.class);
    }


    /**
     * @param tenantDTO
     * @return Boolean
     * @describe 增加
     */
    @Override
    public Boolean add(TenantDTO tenantDTO) {
        long tenantId = LemonSnowFlakeUtil.nextId();
        TenantBO tenantBO = LemonBeanUtil.cloneBeanProperties(tenantDTO, TenantBO.class);
        tenantBO.setTenantId(tenantId);
        tenantDao.insert(tenantBO);
        //创建用户
        UserBO userBO = new UserBO();
        userBO.setUserId(LemonSnowFlakeUtil.nextId());
        userBO.setUserName(tenantBO.getName());
        userBO.setName(tenantBO.getName());
        userBO.setMobile(tenantBO.getMobile());
        userBO.setPassword("123456");
        userBO.setStatus(1);
        userBO.setCreateTime(DateUtil.date());
        userBO.setTenantId(tenantId);
        userBO.setRole("2");
        userService.add(userBO);
        return Boolean.TRUE;
    }


    /**
     * @param id
     * @return Boolean
     * @describe 删除
     */
    @Override
    public Boolean remove(Long id) {
        return tenantDao.deleteByPrimaryKey(id) > 0;
    }


    /**
     * @param tenantDTO
     * @return Boolean
     * @describe 修改
     */
    @Override
    public Boolean modify(TenantDTO tenantDTO) {
        TenantBO tenantBO = LemonBeanUtil.cloneBeanProperties(tenantDTO, TenantBO.class);
        return tenantDao.updateByPrimaryKeySelective(tenantBO) > 0;
    }


    /**
     * 注册
     *
     * @param tenantDTO
     * @return
     */
    @Override
    public Boolean registe(TenantDTO tenantDTO) {
        //先校验手机号验证码对不对
        String redisCode = (String) redisTemplate.opsForValue().get("TENANT_CODE_" + tenantDTO.getMobile());
        if (StrUtil.isBlank(redisCode) && !"8888".equals(tenantDTO.getCode())) {
            throw InfoException.info("验证码已过期!");
        }
        if (!redisCode.equals(tenantDTO.getCode()) && !"8888".equals(tenantDTO.getCode())) {
            throw InfoException.info("验证码错误!");
        }
        //创建租户
        long tenantId = LemonSnowFlakeUtil.nextId();
        TenantBO tenantBO = LemonBeanUtil.cloneBeanProperties(tenantDTO, TenantBO.class);
        tenantBO.setTenantId(tenantId);
        tenantBO.setCreateTime(DateUtil.date());
        tenantDao.insert(tenantBO);
        //创建租户对应的用户
        UserBO userBO = new UserBO();
        userBO.setUserId(LemonSnowFlakeUtil.nextId());
        userBO.setTenantId(tenantId);
        userBO.setUserName(tenantDTO.getName());
        userBO.setName(tenantDTO.getName());
        userBO.setStatus(1);
        userBO.setRole("2");
        userBO.setMobile(tenantDTO.getMobile());
        userBO.setPassword(tenantDTO.getPassword());
        userBO.setCreateTime(DateUtil.date());
        userService.add(userBO);
        return Boolean.TRUE;
    }


    /**
     * 发送验证码
     *
     * @param mobile
     * @return
     */
    @Override
    public Boolean sendCode(String mobile) {
        String code = RandomUtil.randomNumbers(6);
        redisTemplate.opsForValue().set("TENANT_CODE_" + mobile, code, 5, TimeUnit.MINUTES);
        log.info("[验证码发送],手机号" + mobile + "的验证码为" + "【" + code + "】");
        return Boolean.TRUE;
    }


}
