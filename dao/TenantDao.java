package com.lemon.meet.dao;

import com.lemon.database.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import com.lemon.meet.entity.bo.TenantBO;

/**
 * @describe (Tenant)租户数据库访问层
 * @company lemon
 * @address
 * @author
 * @since 2024-06-22 15:20:44
 * @version 1.0.0
 * @updateTime 2024-06-22 15:20:44
 */

@Mapper
public interface TenantDao extends BaseDao<TenantBO> {

}

