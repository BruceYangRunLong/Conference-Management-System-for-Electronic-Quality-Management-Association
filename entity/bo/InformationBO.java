package com.lemon.meet.entity.bo;



import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @describe (Information)资讯BO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 17:39:15
 * @version 1.0.0
 * @updateTime 2024-06-22 17:39:15
 */

@Table(name = "information")
@Data
public class InformationBO implements Serializable {

    private static final long serialVersionUID = 374349367395999030L;

    /**
    * 资讯ID
    */
    @Id
    @OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long informationId;

    /**
    * 标题
    */
    private String title;

    /**
    * 图片
    */
    private String image;

    /**
    * 详情
    */
    private String detail;

    /**
    * 作者
    */
    private String author;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 租户ID
    */
    private Long tenantId;

    /**
    * 简介
    */
    private String profile;


    /**
    * 属性名类
    */
    public static class Properties{

        /**
        * 资讯ID
        */
        public static String informationId = "informationId";


        /**
        * 标题
        */
        public static String title = "title";


        /**
        * 图片
        */
        public static String image = "image";


        /**
        * 详情
        */
        public static String detail = "detail";


        /**
        * 作者
        */
        public static String author = "author";


        /**
        * 创建时间
        */
        public static String createTime = "createTime";


        /**
        * 租户ID
        */
        public static String tenantId = "tenantId";


        /**
        * 简介
        */
        public static String profile = "profile";

    }


    /**
    * 列名类
    */
    public static class Columns{

        /**
        * 资讯ID
        */
        public static String informationId = "information_id";


        /**
        * 标题
        */
        public static String title = "title";


        /**
        * 图片
        */
        public static String image = "image";


        /**
        * 详情
        */
        public static String detail = "detail";


        /**
        * 作者
        */
        public static String author = "author";


        /**
        * 创建时间
        */
        public static String createTime = "create_time";


        /**
        * 租户ID
        */
        public static String tenantId = "tenant_id";


        /**
        * 简介
        */
        public static String profile = "profile";

    }

}
