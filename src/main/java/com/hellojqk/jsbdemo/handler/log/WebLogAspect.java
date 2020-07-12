package com.hellojqk.jsbdemo.handler.log;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class WebLogAspect {

  private Logger logger = LogManager.getLogger(this.getClass());

  @Pointcut("execution(* com.hellojqk.jsbdemo.controller.*.*(..))")
  public void webLog() {
  }

  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    System.out.println("before : " + LocalTime.now());
    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    String reqID = request.getParameter("reqID");
    logger.info("reqID:" + reqID);
    ThreadContext.put("request_id", reqID);
    ThreadContext.put("X-Request-Id", request.getHeader("X-Request-Id"));
    ThreadContext.put("TraceID", request.getHeader("X-B3-Traceid"));
    String uid = UUID.randomUUID().toString();
    // 记录请求内容
    logger.info("URL : " + request.getRequestURL().toString());
    logger.info("HTTP_METHOD : " + request.getMethod());
    logger.info("IP : " + request.getRemoteAddr());
    logger.info(
        "CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

  }

  @AfterReturning(returning = "ret", pointcut = "webLog()")
  public void doAfterReturning(Object ret) throws Throwable {
    System.out.println("after : " + LocalTime.now());
    // 处理完请求，返回内容
    logger.info("RESPONCE : " + ret);
  }

}