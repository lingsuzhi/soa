package com.lszpro.soa.gateway;
import com.alibaba.fastjson.JSON;
import com.lszpro.soa.common.BodyStatus;
import com.lszpro.soa.common.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token拦截器
 *
 * User: liuguiyao<435720953@qq.com>
 * Date: 2017-05-25
 * Time: 11:34
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws            Exception {

//        String version = request.getHeader("Version");
//        response.setContentType("application/json;charset=UTF-8");
//        if( "1".equals(version)){
//
//        }else{
//            BodyStatus bodyStatus = Utils.bodyStatus("9999","Version错误");
//            response.setStatus(200);
//            response.getWriter().write(JSON.toJSONString(bodyStatus));
//            response.getWriter().flush();
//            response.getWriter().close();
//            log.warn("URI:{}, IP:{}, {}", request.getRequestURI(), request.getRemoteAddr(), bodyStatus);
//            return false;
//        }
            log.warn("URI:{}", request.getRequestURI());
        return true;
    }
}