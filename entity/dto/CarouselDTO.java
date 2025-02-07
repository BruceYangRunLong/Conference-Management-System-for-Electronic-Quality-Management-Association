package com.lemon.meet.entity.dto;



import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;


/**
 * @describe (Carousel)轮播图DTO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-23 09:57:20
 * @version 1.0.0
 * @updateTime 2024-06-23 09:57:20
 */

@Data
@ApiModel(value = "轮播图DTO")
public class CarouselDTO implements Serializable {

    private static final long serialVersionUID = -10864079875473346L;


    /**
    * 轮播图ID
    */
    @ApiModelProperty(value = "轮播图ID",name = "carouselId",dataType = "Long")
    private Long carouselId;

    /**
    * 标题
    */
    @ApiModelProperty(value = "标题",name = "title",dataType = "String")
    private String title;

    /**
    * 图片
    */
    @ApiModelProperty(value = "图片",name = "image",dataType = "String")
    private String image;

    /**
    * 排序
    */
    @ApiModelProperty(value = "排序",name = "sort",dataType = "Integer")
    private Integer sort;


}
