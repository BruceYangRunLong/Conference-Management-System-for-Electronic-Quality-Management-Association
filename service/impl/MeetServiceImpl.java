package com.lemon.meet.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.lemon.meet.entity.excel.MeetExcel;
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
import com.lemon.meet.entity.bo.MeetBO;
import com.lemon.meet.entity.dto.MeetDTO;
import com.lemon.meet.entity.vo.MeetVO;
import com.lemon.meet.dao.MeetDao;
import com.lemon.meet.service.MeetService;

/**
 * @author
 * @version 1.0.0
 * @describe (Meet)会议Service层实现
 * @company lemon
 * @address 
 * @updateTime 2024-06-22 18:41:25
 * @since 2024-06-22 18:41:25
 */
@Service("meetService")
public class MeetServiceImpl extends BaseServiceImpl<MeetBO> implements MeetService {

    @Resource
    private MeetDao meetDao;

    /**
     * @param id
     * @return MeetVO
     * @describe ID查询
     */
    @Override
    public MeetVO findById(Long id) {
        return LemonBeanUtil.cloneBeanProperties(meetDao.selectByPrimaryKey(id), MeetVO.class);
    }


    /**
     * @param pageNum 第几页
     * @return PagerList<MeetVO>
     * @describe 分页查询
     * @Param pageSize 每页显示条数
     * @Param count 是否查询总条数
     */
    @Override
    public PageList<MeetVO> pageList(MeetDTO meetDTO, Integer pageNum, Integer pageSize, Boolean count) {
        PageUtil.startPage(pageNum, pageSize, count);
        Example example = new Example(MeetBO.class);
        Example.Criteria criteria = example.createCriteria();
        if (ObjectUtil.isNotEmpty(meetDTO.getMeetId())) {
            criteria.andEqualTo(MeetBO.Properties.meetId, meetDTO.getMeetId());
        }
        if (StrUtil.isNotBlank(meetDTO.getTitle())) {
            criteria.andLike(MeetBO.Properties.title, "%" + meetDTO.getTitle() + "%");
        }
        if (StrUtil.isNotBlank(meetDTO.getCreator())) {
            criteria.andLike(MeetBO.Properties.creator, "%" + meetDTO.getCreator() + "%");
        }
        if (ObjectUtil.isNotEmpty(meetDTO.getStartTime())) {
            criteria.andEqualTo(MeetBO.Properties.startTime, meetDTO.getStartTime());
        }
        if (ObjectUtil.isNotEmpty(meetDTO.getEndTime())) {
            criteria.andEqualTo(MeetBO.Properties.endTime, meetDTO.getEndTime());
        }
        if (StrUtil.isNotBlank(meetDTO.getTravelModel())) {
            criteria.andLike(MeetBO.Properties.travelModel, "%" + meetDTO.getTravelModel() + "%");
        }
        if (ObjectUtil.isNotEmpty(meetDTO.getTenantId())) {
            criteria.andEqualTo(MeetBO.Properties.tenantId, meetDTO.getTenantId());
        }
        return PageUtil.castToPageList(meetDao.selectByExample(example)).toClass(MeetVO.class);
    }


    /**
     * @param
     * @return List<MeetVO>
     * @describe 查询全部
     */
    @Override
    public List<MeetVO> list() {
        return LemonBeanUtil.listCloneProperties(meetDao.selectAll(), MeetVO.class);
    }


    /**
     * @param meetDTO
     * @return Boolean
     * @describe 增加
     */
    @Override
    public Boolean add(MeetDTO meetDTO) {
        MeetBO meetBO = LemonBeanUtil.cloneBeanProperties(meetDTO, MeetBO.class);
        meetBO.setMeetId(LemonSnowFlakeUtil.nextId());
        return meetDao.insert(meetBO) > 0;
    }


    /**
     * @param id
     * @return Boolean
     * @describe 删除
     */
    @Override
    public Boolean remove(Long id) {
        return meetDao.deleteByPrimaryKey(id) > 0;
    }


    /**
     * @param meetDTO
     * @return Boolean
     * @describe 修改
     */
    @Override
    public Boolean modify(MeetDTO meetDTO) {
        MeetBO meetBO = LemonBeanUtil.cloneBeanProperties(meetDTO, MeetBO.class);
        return meetDao.updateByPrimaryKeySelective(meetBO) > 0;
    }


    /**
     * excel导出
     */
    @Override
    public void excelExport() {
        List<MeetBO> meetBOS = meetDao.selectAll();
        List<MeetExcel> meetExcels = LemonBeanUtil.listCloneProperties(meetBOS, MeetExcel.class);
        LemonExcelUtil.writeExcel("会议导出","会议",MeetExcel.class,meetExcels);
    }

}
