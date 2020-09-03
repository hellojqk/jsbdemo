package com.hellojqk.jsbdemo.middleware.aspect;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order(2)
public class WebLogAspect {

  // private Logger logger = LogManager.getLogger(this.getClass());
  private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

  @Pointcut("execution(* com.hellojqk.jsbdemo.controller.*.*(..))")
  public void webLog() {
  }

  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    System.out.println("before : " + LocalTime.now());
    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    ThreadContext.put("X-Request-Id", request.getHeader("X-Request-Id"));
    ThreadContext.put("TraceID", request.getHeader("X-B3-Traceid"));
    String uid = UUID.randomUUID().toString();
    ThreadContext.put("requestID", uid);

    // 记录请求内容
    logger.info("URL : {},HTTP_METHOD :{},IP : {}", request.getRequestURL().toString(), request.getMethod(),
        request.getRemoteAddr());
    logger.info(
        "CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    logger.error("ARGS : " + Arrays.toString(joinPoint.getArgs()));

  }

  @AfterReturning(returning = "ret", pointcut = "webLog()")
  public void doAfterReturning(Object ret) throws Throwable {
    // 处理完请求，返回内容
    logger.info("Response:" + ret);
  }

}