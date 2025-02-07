package com.lemon.meet.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.lemon.meet.entity.excel.InformationExcel;
import com.lemon.util.bean.LemonBeanUtil;
import com.lemon.database.pagehelper.PageUtil;
import com.lemon.util.excel.LemonExcelUtil;
import com.lemon.util.mark.LemonSnowFlakeUtil;
import org.springframework.stereotype.Service;
import com.lemon.database.pagehelper.PageList;
import tk.mybatis.mapper.entity.Example;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.lemon.database.service.impl.BaseServiceImpl;
import com.lemon.meet.entity.bo.InformationBO;
import com.lemon.meet.entity.dto.InformationDTO;
import com.lemon.meet.entity.vo.InformationVO;
import com.lemon.meet.dao.InformationDao;
import com.lemon.meet.service.InformationService;

/**
 * @author
 * @version 1.0.0
 * @describe (Information)资讯Service层实现
 * @company lemon
 * @address 
 * @updateTime 2024-06-22 17:39:14
 * @since 2024-06-22 17:39:14
 */
@Service("informationService")
public class InformationServiceImpl extends BaseServiceImpl<InformationBO> implements InformationService {

    @Resource
    private InformationDao informationDao;

    /**
     * @param id
     * @return InformationVO
     * @describe ID查询
     */
    @Override
    public InformationVO findById(Long id) {
        return LemonBeanUtil.cloneBeanProperties(informationDao.selectByPrimaryKey(id), InformationVO.class);
    }


    /**
     * @param pageNum 第几页
     * @return PagerList<InformationVO>
     * @describe 分页查询
     * @Param pageSize 每页显示条数
     * @Param count 是否查询总条数
     */
    @Override
    public PageList<InformationVO> pageList(InformationDTO informationDTO, Integer pageNum, Integer pageSize, Boolean count) {
        PageUtil.startPage(pageNum, pageSize, count);
        Example example = new Example(InformationBO.class);
        Example.Criteria criteria = example.createCriteria();
        if (ObjectUtil.isNotEmpty(informationDTO.getInformationId())) {
            criteria.andEqualTo(InformationBO.Properties.informationId, informationDTO.getInformationId());
        }
        if (StrUtil.isNotBlank(informationDTO.getTitle())) {
            criteria.andLike(InformationBO.Properties.title, "%" + informationDTO.getTitle() + "%");
        }
        if (StrUtil.isNotBlank(informationDTO.getAuthor())) {
            criteria.andLike(InformationBO.Properties.author, "%" + informationDTO.getAuthor() + "%");
        }
        if (ObjectUtil.isNotEmpty(informationDTO.getTenantId())) {
            criteria.andEqualTo(InformationBO.Properties.tenantId, informationDTO.getTenantId());
        }
        if(StrUtil.isNotBlank(informationDTO.getProfile())){
            criteria.andLike(InformationBO.Columns.profile,informationDTO.getProfile());
        }
        return PageUtil.castToPageList(informationDao.selectByExample(example)).toClass(InformationVO.class);
    }


    /**
     * @param
     * @return List<InformationVO>
     * @describe 查询全部
     */
    @Override
    public List<InformationVO> list() {
        return LemonBeanUtil.listCloneProperties(informationDao.selectAll(), InformationVO.class);
    }


    /**
     * @param informationDTO
     * @return Boolean
     * @describe 增加
     */
    @Override
    public Boolean add(InformationDTO informationDTO) {
        InformationBO informationBO = LemonBeanUtil.cloneBeanProperties(informationDTO, InformationBO.class);
        informationBO.setInformationId(LemonSnowFlakeUtil.nextId());
        return informationDao.insert(informationBO) > 0;
    }


    /**
     * @param id
     * @return Boolean
     * @describe 删除
     */
    @Override
    public Boolean remove(Long id) {
        return informationDao.deleteByPrimaryKey(id) > 0;
    }


    /**
     * @param informationDTO
     * @return Boolean
     * @describe 修改
     */
    @Override
    public Boolean modify(InformationDTO informationDTO) {
        InformationBO informationBO = LemonBeanUtil.cloneBeanProperties(informationDTO, InformationBO.class);
        return informationDao.updateByPrimaryKeySelective(informationBO) > 0;
    }


    /**
     * excel导出
     */
    @Override
    public void excelExport() {
        List<InformationBO> informationBOS = informationDao.selectAll();
        List<InformationExcel> informationExcels = LemonBeanUtil.listCloneProperties(informationBOS, InformationExcel.class);
        LemonExcelUtil.writeExcel("资讯导出","资讯",InformationExcel.class,informationExcels);
    }

}
