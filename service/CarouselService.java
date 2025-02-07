package com.lemon.meet.service;

import java.util.List;
import com.lemon.database.service.BaseService;
import com.lemon.database.pagehelper.PageList;
import com.lemon.meet.entity.bo.CarouselBO;
import com.lemon.meet.entity.vo.CarouselVO;
import com.lemon.meet.entity.dto.CarouselDTO;

/**
 * @describe (Carousel)轮播图Service层接口
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-23 09:57:20
 * @version 1.0.0
 * @updateTime 2024-06-23 09:57:20
 */
public interface CarouselService extends BaseService<CarouselBO>{


   /**
   *@describe ID查询
   *@param id
   *@return CarouselVO
   */
   CarouselVO findById(Long id);


   /**
   *@param pageNum 第几页
   *@Param pageSize 每页显示条数
   *@Param count 是否查询总条数
   *@return PagerList<CarouselVO>
   *@describe 分页查询
   */
   PageList<CarouselVO> pageList(CarouselDTO carouselDTO,Integer pageNum,Integer pageSize,Boolean count);


   /**
   *@describe 查询全部
   *@param
   *@return List<CarouselVO>
   */
   List<CarouselVO> list();


   /**
   *@describe 增加
   *@param carouselDTO
   *@return Boolean
   */
   Boolean add(CarouselDTO carouselDTO);


   /**
   *@describe 删除
   *@param id
   *@return Boolean
   */
   Boolean remove(Long id);


   /**
   *@describe 修改
   *@param carouselDTO
   *@return Boolean
   */
   Boolean modify(CarouselDTO carouselDTO);


   /**
    * excel导出
    */
   void exportExcel();


}
