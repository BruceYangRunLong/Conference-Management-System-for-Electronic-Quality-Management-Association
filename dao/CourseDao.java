package com.lemon.meet.dao;

import com.lemon.database.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import com.lemon.meet.entity.bo.CourseBO;

/**
 * @describe (Course)课程数据库访问层
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 18:14:29
 * @version 1.0.0
 * @updateTime 2024-06-22 18:14:29
 */

@Mapper
public interface CourseDao extends BaseDao<CourseBO> {

}

