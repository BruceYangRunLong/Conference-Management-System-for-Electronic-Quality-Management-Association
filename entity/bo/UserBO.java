package com.lemon.meet.entity.bo;



import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @describe (User)用户BO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 13:59:39
 * @version 1.0.0
 * @updateTime 2024-06-22 13:59:39
 */

@Table(name = "user")
@Data
public class UserBO implements Serializable {

    private static final long serialVersionUID = -87726620701426779L;

    /**
    * 用户ID
    */
    @Id
    @OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
    * 用户名
    */
    private String userName;

    /**
    * 部门ID
    */
    private Long employeeId;

    /**
    * 用户名称
    */
    private String name;

    /**
    * 密码
    */
    private String password;

    /**
    * 性别
    */
    private Integer sex;

    /**
    * 状态
    */
    private Integer status;

    /**
    * 岗位
    */
    private String station;

    /**
    * 角色
    */
    private String role;

    /**
    * 备注
    */
    private String note;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 手机号码
    */
    private String mobile;

    /**
    * 邮箱
    */
    private String mail;

    /**
     * 租户ID
     */
    private Long tenantId;


    /**
    * 属性名类
    */
    public static class Properties{

        /**
        * 用户ID
        */
        public static String userId = "userId";


        /**
        * 用户名
        */
        public static String userName = "userName";


        /**
        * 部门ID
        */
        public static String employeeId = "employeeId";


        /**
        * 用户名称
        */
        public static String name = "name";


        /**
        * 密码
        */
        public static String password = "password";


        /**
        * 性别
        */
        public static String sex = "sex";


        /**
        * 状态
        */
        public static String status = "status";


        /**
        * 岗位
        */
        public static String station = "station";


        /**
        * 角色
        */
        public static String role = "role";


        /**
        * 备注
        */
        public static String note = "note";


        /**
        * 创建时间
        */
        public static String createTime = "createTime";


        /**
        * 手机号码
        */
        public static String mobile = "mobile";


        /**
        * 邮箱
        */
        public static String mail = "mail";

        /**
         * 租户ID
         */
        public static String tenantId = "tenantId";

    }


    /**
    * 列名类
    */
    public static class Columns{

        /**
        * 用户ID
        */
        public static String userId = "user_id";


        /**
        * 用户名
        */
        public static String userName = "user_name";


        /**
        * 部门ID
        */
        public static String employeeId = "employee_id";


        /**
        * 用户名称
        */
        public static String name = "name";


        /**
        * 密码
        */
        public static String password = "password";


        /**
        * 性别
        */
        public static String sex = "sex";


        /**
        * 状态
        */
        public static String status = "status";


        /**
        * 岗位
        */
        public static String station = "station";


        /**
        * 角色
        */
        public static String role = "role";


        /**
        * 备注
        */
        public static String note = "note";


        /**
        * 创建时间
        */
        public static String createTime = "create_time";


        /**
        * 手机号码
        */
        public static String mobile = "mobile";


        /**
        * 邮箱
        */
        public static String mail = "mail";


        /**
         * 租户ID
         */
        public static String tenantId = "tenant_id";

    }

}
