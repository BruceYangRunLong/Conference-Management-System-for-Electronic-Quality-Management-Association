package com.lemon.meet.entity.bo;



import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * @describe (Tenant)租户BO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 15:20:44
 * @version 1.0.0
 * @updateTime 2024-06-22 15:20:44
 */

@Table(name = "tenant")
@Data
public class TenantBO implements Serializable {

    private static final long serialVersionUID = 352659440690592542L;

    /**
     * 租户ID
     */
    @Id
    @OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenantId;

    /**
     * 租户名称
     */
    private String name;

    /**
     * 图标
     */
    private String image;

    /**
     * 联系人
     */
    private String head;

    /**
     * 电话
     */
    private String mobile;

    /**
     * 管理员
     */
    private String admin;

    /**
     * 详情
     */
    private String detail;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 属性名类
     */
    public static class Properties{

        /**
         * 租户ID
         */
        public static String tenantId = "tenantId";


        /**
         * 租户名称
         */
        public static String name = "name";


        /**
         * 图标
         */
        public static String image = "image";


        /**
         * 联系人
         */
        public static String head = "head";


        /**
         * 电话
         */
        public static String mobile = "mobile";


        /**
         * 管理员
         */
        public static String admin = "admin";


        /**
         * 详情
         */
        public static String detail = "detail";


        /**
         * 创建时间
         */
        public static String createTime = "createTime";

    }


    /**
     * 列名类
     */
    public static class Columns{

        /**
         * 租户ID
         */
        public static String tenantId = "tenant_id";


        /**
         * 租户名称
         */
        public static String name = "name";


        /**
         * 图标
         */
        public static String image = "image";


        /**
         * 联系人
         */
        public static String head = "head";


        /**
         * 电话
         */
        public static String mobile = "mobile";


        /**
         * 管理员
         */
        public static String admin = "admin";


        /**
         * 详情
         */
        public static String detail = "detail";


        /**
         * 创建时间
         */
        public static String createTime = "create_time";

    }

}