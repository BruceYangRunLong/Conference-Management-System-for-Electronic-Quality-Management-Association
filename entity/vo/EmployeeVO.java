package com.lemon.meet.entity.vo;



import lombok.Data;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.lemon.web.serializer.LongCastToStringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * @describe (Employee)部门VO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 11:04:48
 * @version 1.0.0
 * @updateTime 2024-06-22 11:04:48
 */

@Data
@ApiModel(value = "部门VO")
public class EmployeeVO implements Serializable {

    private static final long serialVersionUID = 133776739960930201L;


    /**
    * 部门ID
    */
    @JsonSerialize(using = LongCastToStringSerializer.class)
    @ApiModelProperty(value = "部门ID",name = "employeeId",dataType = "Long")
    private Long employeeId;

    /**
    * 父级ID
    */
    @JsonSerialize(using = LongCastToStringSerializer.class)
    @ApiModelProperty(value = "父级ID",name = "parentId",dataType = "Long")
    private Long parentId;

    /**
    * 部门名称
    */
    @ApiModelProperty(value = "部门名称",name = "name",dataType = "String")
    private String name;

    /**
    * 负责人
    */
    @ApiModelProperty(value = "负责人",name = "head",dataType = "String")
    private String head;

    /**
    * 联系方式
    */
    @ApiModelProperty(value = "联系方式",name = "mobile",dataType = "String")
    private String mobile;

    /**
    * 邮箱
    */
    @ApiModelProperty(value = "邮箱",name = "mail",dataType = "String")
    private String mail;

    /**
    * 状态
    */
    @ApiModelProperty(value = "状态",name = "status",dataType = "Integer")
    private Integer status;

    /**
    * 排序
    */
    @JsonSerialize(using = LongCastToStringSerializer.class)
    @ApiModelProperty(value = "排序",name = "sort",dataType = "Long")
    private Long sort;


    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",name = "createTime",dataType = "Date")
    private Date createTime;

}
