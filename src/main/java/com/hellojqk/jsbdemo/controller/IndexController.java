package com.hellojqk.jsbdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.MDC;

/**
 * @author wangyang
 */
@RestController
public class IndexController {

  private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

  @GetMapping("/")
  public String index() {
    MDC.put("what","哈哈哈");
    logger.info("哈哈哈哈");
    return "hellojqk";
  }
  @GetMapping("/error")
  public String error() {
    String aaa="张三";
//    Integer.parseInt(aaa);
    return "hellojqk";
  }
}