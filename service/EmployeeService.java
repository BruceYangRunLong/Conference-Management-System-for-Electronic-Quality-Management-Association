package com.lemon.meet.service;

import java.util.List;

import cn.hutool.core.lang.tree.Tree;
import com.lemon.database.service.BaseService;
import com.lemon.database.pagehelper.PageList;
import com.lemon.meet.entity.bo.EmployeeBO;
import com.lemon.meet.entity.vo.EmployeeVO;
import com.lemon.meet.entity.dto.EmployeeDTO;

/**
 * @describe (Employee)部门Service层接口
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 11:04:48
 * @version 1.0.0
 * @updateTime 2024-06-22 11:04:48
 */
public interface EmployeeService extends BaseService<EmployeeBO>{


   /**
   *@describe ID查询
   *@param id
   *@return EmployeeVO
   */
   EmployeeVO findById(Long id);


   /**
   *@param pageNum 第几页
   *@Param pageSize 每页显示条数
   *@Param count 是否查询总条数
   *@return PagerList<EmployeeVO>
   *@describe 分页查询
   */
   PageList<EmployeeVO> pageList(EmployeeDTO employeeDTO,Integer pageNum,Integer pageSize,Boolean count);


   /**
   *@describe 查询全部
   *@param
   *@return List<EmployeeVO>
   */
   List<EmployeeVO> list();


   /**
   *@describe 增加
   *@param employeeDTO
   *@return Boolean
   */
   Boolean add(EmployeeDTO employeeDTO);


   /**
   *@describe 删除
   *@param id
   *@return Boolean
   */
   Boolean remove(Long id);


   /**
   *@describe 修改
   *@param employeeDTO
   *@return Boolean
   */
   Boolean modify(EmployeeDTO employeeDTO);


   /**
    * 部门树状结构
    * @return
    */
   List<Tree<Long>> tree();


}
