package com.qacboy.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/8/23 下午9:52
 *
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger log=LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.qacboy.girl.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("前置通知：记录日志");

        //uel
        log.info("url:{}",request.getRequestURI());
        //请求方法
        log.info("method:{}",request.getMethod());
        //ip
        log.info("ip:{}",request.getRemoteAddr());
        //类方法
        log.info("class_method:{}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        log.info("args:{}",joinPoint.getArgs());
    }

    @AfterReturning(returning = "object" ,pointcut = "log()")
    public void doAfterReturn(Object object){
        log.info("返回数据后通知：记录日志");
        log.info("response:{}",object.toString());
    }


}
