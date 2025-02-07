package com.lemon.meet.service;

import java.util.List;
import java.util.Map;

import com.lemon.database.service.BaseService;
import com.lemon.database.pagehelper.PageList;
import com.lemon.meet.entity.bo.UserBO;
import com.lemon.meet.entity.vo.UserVO;
import com.lemon.meet.entity.dto.UserDTO;

/**
 * @describe (User)用户Service层接口
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 13:59:38
 * @version 1.0.0
 * @updateTime 2024-06-22 13:59:38
 */
public interface UserService extends BaseService<UserBO>{


   /**
   *@describe ID查询
   *@param id
   *@return UserVO
   */
   UserVO findById(Long id);


   /**
   *@param pageNum 第几页
   *@Param pageSize 每页显示条数
   *@Param count 是否查询总条数
   *@return PagerList<UserVO>
   *@describe 分页查询
   */
   PageList<UserVO> pageList(UserDTO userDTO,Integer pageNum,Integer pageSize,Boolean count);


   /**
   *@describe 查询全部
   *@param
   *@return List<UserVO>
   */
   List<UserVO> list();


   /**
   *@describe 增加
   *@param userDTO
   *@return Boolean
   */
   Boolean add(UserDTO userDTO);


   /**
   *@describe 删除
   *@param id
   *@return Boolean
   */
   Boolean remove(Long id);


   /**
   *@describe 修改
   *@param userDTO
   *@return Boolean
   */
   Boolean modify(UserDTO userDTO);


   /**
    * 登录
    * @param userDTO
    * @return
    */
   Map<String,Object> login(UserDTO userDTO);


   /**
    * 导出
    */
   void excelExport();


}
