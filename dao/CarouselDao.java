package com.lemon.meet.dao;

import com.lemon.database.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import com.lemon.meet.entity.bo.CarouselBO;

/**
 * @describe (Carousel)轮播图数据库访问层
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-23 09:57:19
 * @version 1.0.0
 * @updateTime 2024-06-23 09:57:19
 */

@Mapper
public interface CarouselDao extends BaseDao<CarouselBO> {

}

