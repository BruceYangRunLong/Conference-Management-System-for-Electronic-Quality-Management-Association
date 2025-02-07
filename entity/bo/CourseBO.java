package com.lemon.meet.entity.bo;



import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @describe (Course)课程BO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 18:14:32
 * @version 1.0.0
 * @updateTime 2024-06-22 18:14:32
 */

@Table(name = "course")
@Data
public class CourseBO implements Serializable {

    private static final long serialVersionUID = -19539822263435530L;

    /**
    * 课程ID
    */
    @Id
    @OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    /**
    * 封面
    */
    private String image;

    /**
    * 课程简介
    */
    private String profele;

    /**
    * 排序字段
    */
    private Integer sort;

    /**
    * 课程视频
    */
    private String file;

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
    * 课程名称
    */
    private String title;


    /**
    * 属性名类
    */
    public static class Properties{

        /**
        * 课程ID
        */
        public static String courseId = "courseId";


        /**
        * 封面
        */
        public static String image = "image";


        /**
        * 课程简介
        */
        public static String profele = "profele";


        /**
        * 排序字段
        */
        public static String sort = "sort";


        /**
        * 课程视频
        */
        public static String file = "file";


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
        * 课程名称
        */
        public static String title = "title";

    }


    /**
    * 列名类
    */
    public static class Columns{

        /**
        * 课程ID
        */
        public static String courseId = "course_id";


        /**
        * 封面
        */
        public static String image = "image";


        /**
        * 课程简介
        */
        public static String profele = "profele";


        /**
        * 排序字段
        */
        public static String sort = "sort";


        /**
        * 课程视频
        */
        public static String file = "file";


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
        * 课程名称
        */
        public static String title = "title";

    }

}
