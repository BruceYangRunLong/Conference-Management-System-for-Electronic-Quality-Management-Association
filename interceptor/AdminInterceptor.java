package com.lemon.meet.interceptor;

import cn.hutool.core.util.StrUtil;
import com.lemon.util.jwt.JwtUtil;
import com.lemon.web.code.CodeEnum;
import com.lemon.web.exception.InfoException;
import com.lemon.web.request.LemonHttpServletRequestWrapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @version 1.0.0
 * @describe
 * @company lemon
 * @address 
 * @updateTime 2023-12-11 16:35
 * @since 2023-12-11 16:35
 */

@Configuration
public class AdminInterceptor implements WebMvcConfigurer {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (HttpMethod.OPTIONS.name().equals(request.getMethod())){
                    return true;
                }
                //获取token
                String token = request.getHeader("authorization");
                if(StrUtil.isBlank(token)){
                    throw InfoException.info(CodeEnum.UNPASSED_TOKEN);
                }
                String userId = JwtUtil.getClaims(token).get("userId").asString();
                //判断是否过期
                String redisToken = (String)redisTemplate.opsForValue().get("USER_TOKEN_" + userId);
                if(StrUtil.isBlank(redisToken)){
                    throw InfoException.info(CodeEnum.LOGIN_EXPIRED);
                }
                if(!token.equals(redisToken)){
                    throw InfoException.info(CodeEnum.LOGIN_ON_ANOTHER_DEVICE);
                }
                if(request instanceof LemonHttpServletRequestWrapper){
                    LemonHttpServletRequestWrapper requestWrapper = (LemonHttpServletRequestWrapper) request;
                    requestWrapper.addHeader("userId",userId);
                    requestWrapper.addHeader("tenantId",JwtUtil.getClaims(token).get("tenantId").asString().equals("null") ? null : JwtUtil.getClaims(token).get("tenantId").asString());
                }
                //给token重新刷新时间
                redisTemplate.expire("USER_TOKEN_" + userId,1L, TimeUnit.HOURS);
                return Boolean.TRUE;
            }
        }).addPathPatterns("/admin/**").excludePathPatterns("/admin/user/login","/admin/tenant/registe","/admin/carousel/export");
    }
}
