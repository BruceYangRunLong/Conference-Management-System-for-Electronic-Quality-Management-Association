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
 * @describe (Meet)会议VO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 18:41:25
 * @version 1.0.0
 * @updateTime 2024-06-22 18:41:25
 */

@Data
@ApiModel(value = "会议VO")
public class MeetVO implements Serializable {

    private static final long serialVersionUID = 365075386457414525L;


    /**
    * 会议ID
    */
    @JsonSerialize(using = LongCastToStringSerializer.class)
    @ApiModelProperty(value = "会议ID",name = "meetId",dataType = "Long")
    private Long meetId;

    /**
    * 会议标题
    */
    @ApiModelProperty(value = "会议标题",name = "title",dataType = "String")
    private String title;


    /**
     * 类型
     * */
    @ApiModelProperty(value = "类型",name = "type",dataType = "String")
    private String type;

    /**
    * 会议封面
    */
    @ApiModelProperty(value = "会议封面",name = "image",dataType = "String")
    private String image;

    /**
    * 会议内容
    */
    @ApiModelProperty(value = "会议内容",name = "detail",dataType = "String")
    private String detail;

    /**
    * 创建人
    */
    @ApiModelProperty(value = "创建人",name = "creator",dataType = "String")
    private String creator;

    /**
    * 开始时间
    */
    @ApiModelProperty(value = "开始时间",name = "startTime",dataType = "LocalDateTime")
    private Date startTime;

    /**
    * 结束时间
    */
    @ApiModelProperty(value = "结束时间",name = "endTime",dataType = "LocalDateTime")
    private Date endTime;

    /**
    * 出行方式
    */
    @ApiModelProperty(value = "出行方式",name = "travelModel",dataType = "String")
    private String travelModel;

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

}
