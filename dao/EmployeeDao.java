package com.lemon.meet.dao;

import com.lemon.database.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import com.lemon.meet.entity.bo.EmployeeBO;

/**
 * @describe (Employee)部门数据库访问层
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 11:04:48
 * @version 1.0.0
 * @updateTime 2024-06-22 11:04:48
 */

@Mapper
public interface EmployeeDao extends BaseDao<EmployeeBO> {

}

