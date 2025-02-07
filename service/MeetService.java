package com.lemon.meet.service;

import java.util.List;
import com.lemon.database.service.BaseService;
import com.lemon.database.pagehelper.PageList;
import com.lemon.meet.entity.bo.MeetBO;
import com.lemon.meet.entity.vo.MeetVO;
import com.lemon.meet.entity.dto.MeetDTO;

/**
 * @describe (Meet)会议Service层接口
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 18:41:25
 * @version 1.0.0
 * @updateTime 2024-06-22 18:41:25
 */
public interface MeetService extends BaseService<MeetBO>{


   /**
   *@describe ID查询
   *@param id
   *@return MeetVO
   */
   MeetVO findById(Long id);


   /**
   *@param pageNum 第几页
   *@Param pageSize 每页显示条数
   *@Param count 是否查询总条数
   *@return PagerList<MeetVO>
   *@describe 分页查询
   */
   PageList<MeetVO> pageList(MeetDTO meetDTO,Integer pageNum,Integer pageSize,Boolean count);


   /**
   *@describe 查询全部
   *@param
   *@return List<MeetVO>
   */
   List<MeetVO> list();


   /**
   *@describe 增加
   *@param meetDTO
   *@return Boolean
   */
   Boolean add(MeetDTO meetDTO);


   /**
   *@describe 删除
   *@param id
   *@return Boolean
   */
   Boolean remove(Long id);


   /**
   *@describe 修改
   *@param meetDTO
   *@return Boolean
   */
   Boolean modify(MeetDTO meetDTO);


   /**
    * * 导出
    */
   void excelExport();


}
