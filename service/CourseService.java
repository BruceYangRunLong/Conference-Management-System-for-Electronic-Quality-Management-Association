package com.lemon.meet.service;

import java.util.List;
import com.lemon.database.service.BaseService;
import com.lemon.database.pagehelper.PageList;
import com.lemon.meet.entity.bo.CourseBO;
import com.lemon.meet.entity.vo.CourseVO;
import com.lemon.meet.entity.dto.CourseDTO;

/**
 * @describe (Course)课程Service层接口
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 18:14:31
 * @version 1.0.0
 * @updateTime 2024-06-22 18:14:31
 */
public interface CourseService extends BaseService<CourseBO>{


   /**
   *@describe ID查询
   *@param id
   *@return CourseVO
   */
   CourseVO findById(Long id);


   /**
   *@param pageNum 第几页
   *@Param pageSize 每页显示条数
   *@Param count 是否查询总条数
   *@return PagerList<CourseVO>
   *@describe 分页查询
   */
   PageList<CourseVO> pageList(CourseDTO courseDTO,Integer pageNum,Integer pageSize,Boolean count);


   /**
   *@describe 查询全部
   *@param
   *@return List<CourseVO>
   */
   List<CourseVO> list();


   /**
   *@describe 增加
   *@param courseDTO
   *@return Boolean
   */
   Boolean add(CourseDTO courseDTO);


   /**
   *@describe 删除
   *@param id
   *@return Boolean
   */
   Boolean remove(Long id);


   /**
   *@describe 修改
   *@param courseDTO
   *@return Boolean
   */
   Boolean modify(CourseDTO courseDTO);


   /**
    * * excel导出
    */
   void exportExcel();


}
