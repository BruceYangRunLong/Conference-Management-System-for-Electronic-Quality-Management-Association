package com.lemon.meet.entity.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @describe (Employee)部门DTO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 11:04:48
 * @version 1.0.0
 * @updateTime 2024-06-22 11:04:48
 */

@Data
@ApiModel(value = "部门DTO")
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = -47185229175813791L;


    /**
    * 部门ID
    */
    @JsonProperty("id")
    @ApiModelProperty(value = "部门ID",name = "employeeId",dataType = "Long")
    private Long employeeId;

    /**
    * 父级ID
    */
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
    @ApiModelProperty(value = "排序",name = "sort",dataType = "Long")
    private Integer sort;

}
