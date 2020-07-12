package com.hellojqk.jsbdemo.controller;

import java.util.List;

import javax.annotation.Resource;

import com.hellojqk.jsbdemo.service.GoodsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GoodsController {

  private Logger logger= LogManager.getLogger(this.getClass());

  @Resource
  private GoodsService goodsService;

  @GetMapping("/list")
  public List<String> List()
  {
    logger.info("hello world.");
    return goodsService.List();
  }
}