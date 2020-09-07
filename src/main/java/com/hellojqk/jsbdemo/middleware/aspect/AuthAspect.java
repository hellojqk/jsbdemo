package com.hellojqk.jsbdemo.middleware.aspect;

import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author wangyang
 */
@Aspect
@Component
@Order(1)
public class AuthAspect {

  private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

  @Pointcut("execution(* com.hellojqk.*.controller.*.*(..))")
  public void auth() {

  }

  @Before("auth()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    logger.info("auth");
    MDC.put("userId", "9527");
  }
}