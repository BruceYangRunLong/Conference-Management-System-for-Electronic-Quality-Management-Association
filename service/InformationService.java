package com.lemon.meet.service;

import java.util.List;
import com.lemon.database.service.BaseService;
import com.lemon.database.pagehelper.PageList;
import com.lemon.meet.entity.bo.InformationBO;
import com.lemon.meet.entity.vo.InformationVO;
import com.lemon.meet.entity.dto.InformationDTO;

/**
 * @describe (Information)资讯Service层接口
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 17:39:14
 * @version 1.0.0
 * @updateTime 2024-06-22 17:39:14
 */
public interface InformationService extends BaseService<InformationBO>{


   /**
   *@describe ID查询
   *@param id
   *@return InformationVO
   */
   InformationVO findById(Long id);


   /**
   *@param pageNum 第几页
   *@Param pageSize 每页显示条数
   *@Param count 是否查询总条数
   *@return PagerList<InformationVO>
   *@describe 分页查询
   */
   PageList<InformationVO> pageList(InformationDTO informationDTO,Integer pageNum,Integer pageSize,Boolean count);


   /**
   *@describe 查询全部
   *@param
   *@return List<InformationVO>
   */
   List<InformationVO> list();


   /**
   *@describe 增加
   *@param informationDTO
   *@return Boolean
   */
   Boolean add(InformationDTO informationDTO);


   /**
   *@describe 删除
   *@param id
   *@return Boolean
   */
   Boolean remove(Long id);


   /**
   *@describe 修改
   *@param informationDTO
   *@return Boolean
   */
   Boolean modify(InformationDTO informationDTO);


   /**
    * excel导出
    */
   void excelExport();

}
