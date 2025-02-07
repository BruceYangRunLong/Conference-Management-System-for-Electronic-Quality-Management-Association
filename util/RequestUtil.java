package com.lemon.meet.util;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * @version 1.0.0
 * @describe
 * @company lemon
 * @address 
 * @updateTime 2024-06-22 15:47
 * @since 2024-06-22 15:47
 */
public class RequestUtil {

    /**
     * 获取用户ID
     * @return
     */
    public static Long userId(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return null;
    }


    /**
     *  获取租户ID
     *  @return
     */
    public static Long tenantId(){
        return null;
    }


}
