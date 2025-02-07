package com.lemon.meet.service;

import java.util.List;
import com.lemon.database.service.BaseService;
import com.lemon.database.pagehelper.PageList;
import com.lemon.meet.entity.bo.TenantBO;
import com.lemon.meet.entity.vo.TenantVO;
import com.lemon.meet.entity.dto.TenantDTO;

/**
 * @describe (Tenant)租户Service层接口
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 15:20:44
 * @version 1.0.0
 * @updateTime 2024-06-22 15:20:44
 */
public interface TenantService extends BaseService<TenantBO>{


   /**
   *@describe ID查询
   *@param id
   *@return TenantVO
   */
   TenantVO findById(Long id);


   /**
   *@param pageNum 第几页
   *@Param pageSize 每页显示条数
   *@Param count 是否查询总条数
   *@return PagerList<TenantVO>
   *@describe 分页查询
   */
   PageList<TenantVO> pageList(TenantDTO tenantDTO,Integer pageNum,Integer pageSize,Boolean count);


   /**
   *@describe 查询全部
   *@param
   *@return List<TenantVO>
   */
   List<TenantVO> list();


   /**
   *@describe 增加
   *@param tenantDTO
   *@return Boolean
   */
   Boolean add(TenantDTO tenantDTO);


   /**
   *@describe 删除
   *@param id
   *@return Boolean
   */
   Boolean remove(Long id);


   /**
   *@describe 修改
   *@param tenantDTO
   *@return Boolean
   */
   Boolean modify(TenantDTO tenantDTO);


   /**
    * 注册
    * @param tenantDTO
    * @return
    */
   Boolean registe(TenantDTO tenantDTO);


   /**
    * 发送验证码
    * @param mobile
    * @return
    */
   Boolean sendCode(String mobile);


}
