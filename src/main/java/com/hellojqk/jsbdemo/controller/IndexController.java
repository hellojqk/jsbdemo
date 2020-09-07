package com.hellojqk.jsbdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.MDC;

/**
 * @author wangyang
 */
@RestController
public class IndexController {

  @GetMapping("/")
  public String index() {
    MDC.put("what","哈哈哈");
    return "hellojqk";
  }
}