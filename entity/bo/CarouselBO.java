package com.lemon.meet.entity.bo;



import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @describe (Carousel)轮播图BO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-23 09:57:20
 * @version 1.0.0
 * @updateTime 2024-06-23 09:57:20
 */

@Table(name = "carousel")
@Data
public class CarouselBO implements Serializable {

    private static final long serialVersionUID = -34853513612858051L;

    /**
    * 轮播图ID
    */
    @Id
    @OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carouselId;

    /**
    * 标题
    */
    private String title;

    /**
    * 图片
    */
    private String image;

    /**
    * 排序
    */
    private Integer sort;

    /**
    * 创建时间
    */
    private Date createTime;


    /**
    * 属性名类
    */
    public static class Properties{

        /**
        * 轮播图ID
        */
        public static String carouselId = "carouselId";


        /**
        * 标题
        */
        public static String title = "title";


        /**
        * 图片
        */
        public static String image = "image";


        /**
        * 排序
        */
        public static String sort = "sort";


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
        * 轮播图ID
        */
        public static String carouselId = "carousel_id";


        /**
        * 标题
        */
        public static String title = "title";


        /**
        * 图片
        */
        public static String image = "image";


        /**
        * 排序
        */
        public static String sort = "sort";


        /**
        * 创建时间
        */
        public static String createTime = "create_time";

    }

}
