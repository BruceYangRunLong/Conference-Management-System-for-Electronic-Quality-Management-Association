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
 * @describe (Course)课程VO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 18:14:32
 * @version 1.0.0
 * @updateTime 2024-06-22 18:14:32
 */

@Data
@ApiModel(value = "课程VO")
public class CourseVO implements Serializable {

    private static final long serialVersionUID = 690639658365921164L;


    /**
    * 课程ID
    */
    @JsonSerialize(using = LongCastToStringSerializer.class)
    @ApiModelProperty(value = "课程ID",name = "courseId",dataType = "Long")
    private Long courseId;

    /**
    * 封面
    */
    @ApiModelProperty(value = "封面",name = "image",dataType = "String")
    private String image;

    /**
    * 课程简介
    */
    @ApiModelProperty(value = "课程简介",name = "profele",dataType = "String")
    private String profele;

    /**
    * 排序字段
    */
    @ApiModelProperty(value = "排序字段",name = "sort",dataType = "Integer")
    private Integer sort;

    /**
    * 课程视频
    */
    @ApiModelProperty(value = "课程视频",name = "file",dataType = "String")
    private String file;

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
    * 课程名称
    */
    @ApiModelProperty(value = "课程名称",name = "title",dataType = "String")
    private String title;

}
