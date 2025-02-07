package com.lemon.meet.entity.excel;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * @describe (Meet)会议BO
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 18:41:25
 * @version 1.0.0
 * @updateTime 2024-06-22 18:41:25
 */

@Data
public class MeetExcel implements Serializable {

    private static final long serialVersionUID = 257898539100472867L;

    /**
    * 会议ID
    */
    @ExcelProperty({"会议ID"})
    private Long meetId;

    /**
    * 会议标题
    */
    @ExcelProperty({"会议标题"})
    private String title;

    /**
     * 类型
     */
    @ExcelProperty({"类型"})
    private String type;

    /**
    * 会议封面
    */
    @ExcelProperty({"会议封面"})
    private String image;

    /**
    * 会议内容
    */
    @ExcelProperty({"会议内容"})
    private String detail;

    /**
    * 创建人
    */
    @ExcelProperty({"creator"})
    private String creator;

    /**
    * 开始时间
    */
    @ExcelProperty({"开始时间"})
    private Date startTime;

    /**
    * 结束时间
    */
    @ExcelProperty({"结束时间"})
    private Date endTime;

    /**
    * 出行方式
    */
    @ExcelProperty({"出行方式"})
    private String travelModel;

    /**
    * 创建时间
    */
    @ExcelProperty({"创建时间"})
    private Date createTime;

    /**
    * 租户ID
    */
    @ExcelProperty({"租户ID"})
    private Long tenantId;


    /**
    * 属性名类
    */
    public static class Properties{

        /**
        * 会议ID
        */
        public static String meetId = "meetId";


        /**
        * 会议标题
        */
        public static String title = "title";


        /**
         *  类型
         * */
        public static String type = "type";


        /**
        * 会议封面
        */
        public static String image = "image";


        /**
        * 会议内容
        */
        public static String detail = "detail";


        /**
        * 创建人
        */
        public static String creator = "creator";


        /**
        * 开始时间
        */
        public static String startTime = "startTime";


        /**
        * 结束时间
        */
        public static String endTime = "endTime";


        /**
        * 出行方式
        */
        public static String travelModel = "travelModel";


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
        * 会议ID
        */
        public static String meetId = "meet_id";


        /**
        * 会议标题
        */
        public static String title = "title";


        /**
         * 类型
         * */
        public static String type = "type";


        /**
        * 会议封面
        */
        public static String image = "image";


        /**
        * 会议内容
        */
        public static String detail = "detail";


        /**
        * 创建人
        */
        public static String creator = "creator";


        /**
        * 开始时间
        */
        public static String startTime = "start_time";


        /**
        * 结束时间
        */
        public static String endTime = "end_time";


        /**
        * 出行方式
        */
        public static String travelModel = "travel_model";


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
