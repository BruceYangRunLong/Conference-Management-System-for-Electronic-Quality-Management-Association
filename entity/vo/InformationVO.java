package com.lemon.meet.entity.vo;



import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.lemon.web.serializer.LongCastToStringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @describe (Information)资讯VO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 17:39:15
 * @version 1.0.0
 * @updateTime 2024-06-22 17:39:15
 */

@Data
@ApiModel(value = "资讯VO")
public class InformationVO implements Serializable {

    private static final long serialVersionUID = -12637413715712700L;


    /**
    * 资讯ID
    */
    @JsonSerialize(using = LongCastToStringSerializer.class)
    @ApiModelProperty(value = "资讯ID",name = "informationId",dataType = "Long")
    private Long informationId;

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
    * 详情
    */
    @ApiModelProperty(value = "详情",name = "detail",dataType = "String")
    private String detail;

    /**
    * 作者
    */
    @ApiModelProperty(value = "作者",name = "author",dataType = "String")
    private String author;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间",name = "createTime",dataType = "LocalDateTime")
    private Date createTime;

    /**
    * 租户ID
    */
    @JsonSerialize(using = LongCastToStringSerializer.class)
    @ApiModelProperty(value = "租户ID",name = "tenantId",dataType = "Long")
    private Long tenantId;

    /**
    * 简介
    */
    @ApiModelProperty(value = "简介",name = "profile",dataType = "String")
    private String profile;

}
