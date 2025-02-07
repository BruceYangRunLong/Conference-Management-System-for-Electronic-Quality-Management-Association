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
 * @describe (Tenant)租户VO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 15:20:44
 * @version 1.0.0
 * @updateTime 2024-06-22 15:20:44
 */

@Data
@ApiModel(value = "租户VO")
public class TenantVO implements Serializable {

    private static final long serialVersionUID = -51214377250453531L;


    /**
    * 租户ID
    */
    @JsonSerialize(using = LongCastToStringSerializer.class)
    @ApiModelProperty(value = "租户ID",name = "tenantId",dataType = "Long")
    private Long tenantId;

    /**
    * 租户名称
    */
    @ApiModelProperty(value = "租户名称",name = "name",dataType = "String")
    private String name;

    /**
    * 图标
    */
    @ApiModelProperty(value = "图标",name = "image",dataType = "String")
    private String image;

    /**
    * 联系人
    */
    @ApiModelProperty(value = "联系人",name = "head",dataType = "String")
    private String head;

    /**
    * 电话
    */
    @ApiModelProperty(value = "电话",name = "mobile",dataType = "String")
    private String mobile;

    /**
    * 管理员
    */
    @ApiModelProperty(value = "管理员",name = "admin",dataType = "String")
    private String admin;

    /**
    * 详情
    */
    @ApiModelProperty(value = "详情",name = "detail",dataType = "String")
    private String detail;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间",name = "createTime",dataType = "LocalDateTime")
    private Date createTime;

}
