package com.lemon.meet.entity.dto;



import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;


/**
 * @describe (User)用户DTO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 13:59:39
 * @version 1.0.0
 * @updateTime 2024-06-22 13:59:39
 */

@Data
@ApiModel(value = "用户DTO")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -93761023226985985L;


    /**
    * 用户ID
    */
    @ApiModelProperty(value = "用户ID",name = "userId",dataType = "Long")
    private Long userId;

    /**
    * 用户名
    */
    @ApiModelProperty(value = "用户名",name = "userName",dataType = "String")
    private String userName;

    /**
    * 部门ID
    */
    @ApiModelProperty(value = "部门ID",name = "employeeId",dataType = "Long")
    private Long employeeId;

    /**
    * 用户名称
    */
    @ApiModelProperty(value = "用户名称",name = "name",dataType = "String")
    private String name;

    /**
    * 密码
    */
    @ApiModelProperty(value = "密码",name = "password",dataType = "String")
    private String password;

    /**
    * 性别
    */
    @ApiModelProperty(value = "性别",name = "sex",dataType = "Integer")
    private Integer sex;

    /**
    * 状态
    */
    @ApiModelProperty(value = "状态",name = "status",dataType = "Integer")
    private Integer status;

    /**
    * 岗位
    */
    @ApiModelProperty(value = "岗位",name = "station",dataType = "String")
    private String station;

    /**
    * 角色
    */
    @ApiModelProperty(value = "角色",name = "role",dataType = "String")
    private String role;

    /**
    * 备注
    */
    @ApiModelProperty(value = "备注",name = "note",dataType = "String")
    private String note;


    /**
    * 手机号码
    */
    @ApiModelProperty(value = "手机号码",name = "mobile",dataType = "String")
    private String mobile;

    /**
    * 邮箱
    */
    @ApiModelProperty(value = "邮箱",name = "mail",dataType = "String")
    private String mail;

}
