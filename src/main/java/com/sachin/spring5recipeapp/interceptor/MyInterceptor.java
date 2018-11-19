package com.sachin.spring5recipeapp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class MyInterceptor implements HandlerInterceptor {


    static Logger logger = Logger.getLogger("MyInterceptor");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("preHandleMethod "+ request.getMethod());
        logger.info("preHandle Scheme "+request.getScheme());
        logger.info("Before handling the request");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("After hanlding therequest");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("After rendering the response");
    }
}
