package com.lemon.meet.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.lemon.meet.entity.excel.CourseExcel;
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
import com.lemon.meet.entity.bo.CourseBO;
import com.lemon.meet.entity.dto.CourseDTO;
import com.lemon.meet.entity.vo.CourseVO;
import com.lemon.meet.dao.CourseDao;
import com.lemon.meet.service.CourseService;

/**
 * @author
 * @version 1.0.0
 * @describe (Course)课程Service层实现
 * @company lemon
 * @address 
 * @updateTime 2024-06-22 18:14:31
 * @since 2024-06-22 18:14:31
 */
@Service("courseService")
public class CourseServiceImpl extends BaseServiceImpl<CourseBO> implements CourseService {

    @Resource
    private CourseDao courseDao;

    /**
     * @param id
     * @return CourseVO
     * @describe ID查询
     */
    @Override
    public CourseVO findById(Long id) {
        return LemonBeanUtil.cloneBeanProperties(courseDao.selectByPrimaryKey(id), CourseVO.class);
    }


    /**
     * @param pageNum 第几页
     * @return PagerList<CourseVO>
     * @describe 分页查询
     * @Param pageSize 每页显示条数
     * @Param count 是否查询总条数
     */
    @Override
    public PageList<CourseVO> pageList(CourseDTO courseDTO, Integer pageNum, Integer pageSize, Boolean count) {
        PageUtil.startPage(pageNum, pageSize, count);
        Example example = new Example(CourseBO.class);
        Example.Criteria criteria = example.createCriteria();
        if (ObjectUtil.isNotEmpty(courseDTO.getCourseId())) {
            criteria.andEqualTo(CourseBO.Properties.courseId, courseDTO.getCourseId());
        }
        if (StrUtil.isNotBlank(courseDTO.getProfele())) {
            criteria.andLike(CourseBO.Properties.profele, "%" + courseDTO.getProfele() + "%");
        }
        if (ObjectUtil.isNotEmpty(courseDTO.getSort())) {
            criteria.andEqualTo(CourseBO.Properties.sort, courseDTO.getSort());
        }
        if (StrUtil.isNotBlank(courseDTO.getAuthor())) {
            criteria.andLike(CourseBO.Properties.author, "%" + courseDTO.getAuthor() + "%");
        }
        if (ObjectUtil.isNotEmpty(courseDTO.getTenantId())) {
            criteria.andEqualTo(CourseBO.Properties.tenantId, courseDTO.getTenantId());
        }
        if (StrUtil.isNotBlank(courseDTO.getTitle())) {
            criteria.andLike(CourseBO.Properties.title, "%" + courseDTO.getTitle() + "%");
        }
        return PageUtil.castToPageList(courseDao.selectByExample(example)).toClass(CourseVO.class);
    }


    /**
     * @param
     * @return List<CourseVO>
     * @describe 查询全部
     */
    @Override
    public List<CourseVO> list() {
        return LemonBeanUtil.listCloneProperties(courseDao.selectAll(), CourseVO.class);
    }


    /**
     * @param courseDTO
     * @return Boolean
     * @describe 增加
     */
    @Override
    public Boolean add(CourseDTO courseDTO) {
        CourseBO courseBO = LemonBeanUtil.cloneBeanProperties(courseDTO, CourseBO.class);
        courseBO.setCourseId(LemonSnowFlakeUtil.nextId());
        return courseDao.insert(courseBO) > 0;
    }


    /**
     * @param id
     * @return Boolean
     * @describe 删除
     */
    @Override
    public Boolean remove(Long id) {
        return courseDao.deleteByPrimaryKey(id) > 0;
    }


    /**
     * @param courseDTO
     * @return Boolean
     * @describe 修改
     */
    @Override
    public Boolean modify(CourseDTO courseDTO) {
        CourseBO courseBO = LemonBeanUtil.cloneBeanProperties(courseDTO, CourseBO.class);
        return courseDao.updateByPrimaryKeySelective(courseBO) > 0;
    }

    /**
     * excel导出
     */
    @Override
    public void exportExcel() {
        List<CourseBO> courseBOS = courseDao.selectAll();
        List<CourseExcel> courseExcels = LemonBeanUtil.listCloneProperties(courseBOS, CourseExcel.class);
        LemonExcelUtil.writeExcel("课程导出","课程",CourseExcel.class,courseExcels);
    }

}
