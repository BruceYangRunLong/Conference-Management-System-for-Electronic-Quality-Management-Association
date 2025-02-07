package com.lemon.meet.dao;

import com.lemon.database.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import com.lemon.meet.entity.bo.UserBO;

/**
 * @describe (User)用户数据库访问层
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 13:59:36
 * @version 1.0.0
 * @updateTime 2024-06-22 13:59:36
 */

@Mapper
public interface UserDao extends BaseDao<UserBO> {

}

