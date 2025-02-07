package com.lemon.meet.entity.bo;



import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * @describe (Employee)部门BO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 11:04:48
 * @version 1.0.0
 * @updateTime 2024-06-22 11:04:48
 */

@Table(name = "employee")
@Data
public class EmployeeBO implements Serializable {

    private static final long serialVersionUID = 721272203547582470L;

    /**
    * 部门ID
    */
    @Id
    @OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    /**
    * 父级ID
    */
    private Long parentId;

    /**
    * 部门名称
    */
    private String name;

    /**
    * 负责人
    */
    private String head;

    /**
    * 联系方式
    */
    private String mobile;

    /**
    * 邮箱
    */
    private String mail;

    /**
    * 状态
    */
    private Integer status;

    /**
    * 排序
    */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createTime;


    /**
     * 租户ID
     */
    private Long tenantId;


    /**
    * 属性名类
    */
    public static class Properties{

        /**
        * 部门ID
        */
        public static String employeeId = "employeeId";


        /**
        * 父级ID
        */
        public static String parentId = "parentId";


        /**
        * 部门名称
        */
        public static String name = "name";


        /**
        * 负责人
        */
        public static String head = "head";


        /**
        * 联系方式
        */
        public static String mobile = "mobile";


        /**
        * 邮箱
        */
        public static String mail = "mail";


        /**
        * 状态
        */
        public static String status = "status";


        /**
        * 排序
        */
        public static String sort = "sort";


        /**
         * 创建时间
         */
        public static String createTime = "createTime";


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
        * 部门ID
        */
        public static String employeeId = "employee_id";


        /**
        * 父级ID
        */
        public static String parentId = "parent_id";


        /**
        * 部门名称
        */
        public static String name = "name";


        /**
        * 负责人
        */
        public static String head = "head";


        /**
        * 联系方式
        */
        public static String mobile = "mobile";


        /**
        * 邮箱
        */
        public static String mail = "mail";


        /**
        * 状态
        */
        public static String status = "status";


        /**
        * 排序
        */
        public static String sort = "sort";

        /**
         * 创建时间
         */
        public static String createTime = "create_time";

        /**
         * 租户ID
         */
        public static String tenantId = "tenant_id";

    }

}
