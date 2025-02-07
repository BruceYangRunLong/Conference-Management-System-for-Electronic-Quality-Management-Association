package com.lemon.meet.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.lemon.meet.entity.bo.EmployeeBO;
import com.lemon.meet.entity.excel.UserExcel;
import com.lemon.meet.service.EmployeeService;
import com.lemon.util.bean.LemonBeanUtil;
import com.lemon.database.pagehelper.PageUtil;
import com.lemon.util.excel.LemonExcelUtil;
import com.lemon.util.jwt.JwtUtil;
import com.lemon.util.mark.LemonSnowFlakeUtil;
import com.lemon.web.exception.InfoException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.lemon.database.pagehelper.PageList;
import tk.mybatis.mapper.entity.Example;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.lemon.database.service.impl.BaseServiceImpl;
import com.lemon.meet.entity.bo.UserBO;
import com.lemon.meet.entity.dto.UserDTO;
import com.lemon.meet.entity.vo.UserVO;
import com.lemon.meet.dao.UserDao;
import com.lemon.meet.service.UserService;

/**
 * @author
 * @version 1.0.0
 * @describe (User)用户Service层实现
 * @company lemon
 * @address 
 * @updateTime 2024-06-22 13:59:38
 * @since 2024-06-22 13:59:38
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserBO> implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private EmployeeService employeeService;

    /**
     * @param id
     * @return UserVO
     * @describe ID查询
     */
    @Override
    public UserVO findById(Long id) {
        return LemonBeanUtil.cloneBeanProperties(userDao.selectByPrimaryKey(id), UserVO.class);
    }


    /**
     * @param pageNum 第几页
     * @return PagerList<UserVO>
     * @describe 分页查询
     * @Param pageSize 每页显示条数
     * @Param count 是否查询总条数
     */
    @Override
    public PageList<UserVO> pageList(UserDTO userDTO, Integer pageNum, Integer pageSize, Boolean count) {
        PageUtil.startPage(pageNum, pageSize, count);
        Example example = new Example(UserBO.class);
        Example.Criteria criteria = example.createCriteria();
        if (ObjectUtil.isNotEmpty(userDTO.getUserId())) {
            criteria.andEqualTo(UserBO.Properties.userId, userDTO.getUserId());
        }
        if (StrUtil.isNotBlank(userDTO.getUserName())) {
            criteria.andLike(UserBO.Properties.userName, "%" + userDTO.getUserName() + "%");
        }
        if (ObjectUtil.isNotEmpty(userDTO.getEmployeeId())) {
            criteria.andEqualTo(UserBO.Properties.employeeId, userDTO.getEmployeeId());
        }
        if (StrUtil.isNotBlank(userDTO.getName())) {
            criteria.andLike(UserBO.Properties.name, "%" + userDTO.getName() + "%");
        }
        if (StrUtil.isNotBlank(userDTO.getPassword())) {
            criteria.andLike(UserBO.Properties.password, "%" + userDTO.getPassword() + "%");
        }
        if (ObjectUtil.isNotEmpty(userDTO.getSex())) {
            criteria.andEqualTo(UserBO.Properties.sex, userDTO.getSex());
        }
        if (ObjectUtil.isNotEmpty(userDTO.getStatus())) {
            criteria.andEqualTo(UserBO.Properties.status, userDTO.getStatus());
        }
        if (StrUtil.isNotBlank(userDTO.getStation())) {
            criteria.andLike(UserBO.Properties.station, "%" + userDTO.getStation() + "%");
        }
        if (StrUtil.isNotBlank(userDTO.getRole())) {
            criteria.andLike(UserBO.Properties.role, "%" + userDTO.getRole() + "%");
        }
        if (StrUtil.isNotBlank(userDTO.getNote())) {
            criteria.andLike(UserBO.Properties.note, "%" + userDTO.getNote() + "%");
        }
        if (StrUtil.isNotBlank(userDTO.getMobile())) {
            criteria.andLike(UserBO.Properties.mobile, "%" + userDTO.getMobile() + "%");
        }
        if (StrUtil.isNotBlank(userDTO.getMail())) {
            criteria.andLike(UserBO.Properties.mail, "%" + userDTO.getMail() + "%");
        }
        //获取相关的数据
        List<UserBO> userBOS = userDao.selectByExample(example);
        List<UserVO> userVOS = BeanUtil.copyToList(userBOS, UserVO.class);
        //获取部门ID集合
        List<Long> departmentIds = CollUtil.getFieldValues(userBOS, UserBO.Properties.employeeId, Long.class);
        if(CollUtil.isNotEmpty(departmentIds)){
            //获取部门ID
            List<EmployeeBO> employees = employeeService.findByPrimaryKeys(departmentIds);
            userVOS.forEach(u -> {
                employees.forEach(e -> {
                    if(e.getEmployeeId().equals(u.getEmployeeId())){
                        u.setDepartmentName(e.getName());

                    }

                });

            });
        }
        return PageUtil.castToPageList(userBOS).castRows(userVOS);
    }


    /**
     * @param
     * @return List<UserVO>
     * @describe 查询全部
     */
    @Override
    public List<UserVO> list() {
        return LemonBeanUtil.listCloneProperties(userDao.selectAll(), UserVO.class);
    }


    /**
     * @param userDTO
     * @return Boolean
     * @describe 增加
     */
    @Override
    public Boolean add(UserDTO userDTO) {
        //判断当前用户名是否已存在
        UserBO userBOQuery = new UserBO();
        userBOQuery.setUserName(userDTO.getUserName());
        UserBO user = userDao.selectOne(userBOQuery);
        if(ObjectUtil.isNotEmpty(user)){
            throw InfoException.info("用户名已存在!");
        }
        UserBO userBO = LemonBeanUtil.cloneBeanProperties(userDTO, UserBO.class);
        userBO.setUserId(LemonSnowFlakeUtil.nextId());
        return userDao.insert(userBO) > 0;
    }


    /**
     * @param id
     * @return Boolean
     * @describe 删除
     */
    @Override
    public Boolean remove(Long id) {
        return userDao.deleteByPrimaryKey(id) > 0;
    }


    /**
     * @param userDTO
     * @return Boolean
     * @describe 修改
     */
    @Override
    public Boolean modify(UserDTO userDTO) {
        UserBO userBO = LemonBeanUtil.cloneBeanProperties(userDTO, UserBO.class);
        return userDao.updateByPrimaryKeySelective(userBO) > 0;
    }


    /**
     * 登录
     *
     * @param userDTO
     * @return
     */
    @Override
    public Map<String, Object> login(UserDTO userDTO) {
        //先查询用户存不存在
        UserBO userBO = new UserBO();
        userBO.setUserName(userDTO.getName());
        UserBO user = userDao.selectOne(userBO);
        if (ObjectUtil.isEmpty(user)) {
            throw InfoException.info("用户不存在!");
        }
        if (!userDTO.getPassword().equals(user.getPassword())) {
            throw InfoException.info("账号或密码错误!");
        }
        if("3".equals(user.getRole())){
            throw InfoException.info("普通用户请到客户端登录!");
        }
        //生成token
        String token = JwtUtil.createToken(new HashMap<String, String>() {{
            put("userId", String.valueOf(user.getUserId()));
            put("tenantId", ObjectUtil.isEmpty(user.getTenantId()) ? null : String.valueOf(user.getTenantId()) );
        }});
        //将token缓存一个时
        redisTemplate.opsForValue().set("USER_TOKEN_" + user.getUserId(), token, 1, TimeUnit.HOURS);
        return new HashMap<String, Object>() {{
            put("token", token);
            put("user", user);
        }};
    }


    /**
     * 表格导出
     */
    @Override
    public void excelExport() {
        List<UserBO> userBOS = userDao.selectAll();
        List<UserExcel> userExcels = LemonBeanUtil.listCloneProperties(userBOS, UserExcel.class);
        LemonExcelUtil.writeExcel("用户导出","用户",UserExcel.class,userBOS);
    }

}
