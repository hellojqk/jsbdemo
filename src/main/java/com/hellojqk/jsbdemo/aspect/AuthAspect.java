package com.hellojqk.jsbdemo.aspect;

import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AuthAspect {

  private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

  @Pointcut("execution(* com.hellojqk.jsbdemo.controller.*.*(..))")
  public void auth() {

  }

  @Before("auth()")
  public void doBefore(JoinPoint joinPoint) throws Throwable {
    ThreadContext.put("userID","哈哈哈哈");
    logger.info("auth");
  }
}