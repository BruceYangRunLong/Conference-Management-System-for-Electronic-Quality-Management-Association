package com.lemon.meet.dao;

import com.lemon.database.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import com.lemon.meet.entity.bo.MeetBO;

/**
 * @describe (Meet)会议数据库访问层
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 18:41:25
 * @version 1.0.0
 * @updateTime 2024-06-22 18:41:25
 */

@Mapper
public interface MeetDao extends BaseDao<MeetBO> {

}

