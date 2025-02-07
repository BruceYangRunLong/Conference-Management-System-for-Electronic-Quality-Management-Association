package com.lemon.meet.dao;

import com.lemon.database.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import com.lemon.meet.entity.bo.InformationBO;

/**
 * @describe (Information)资讯数据库访问层
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 17:39:12
 * @version 1.0.0
 * @updateTime 2024-06-22 17:39:12
 */

@Mapper
public interface InformationDao extends BaseDao<InformationBO> {

}

