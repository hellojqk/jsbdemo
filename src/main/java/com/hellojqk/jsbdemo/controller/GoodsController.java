package com.hellojqk.jsbdemo.controller;

import java.util.List;

import javax.annotation.Resource;

import com.hellojqk.jsbdemo.service.GoodsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GoodsController {

  // private Logger logger= LogManager.getLogger(this.getClass());
  private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

  @Resource
  private GoodsService goodsService;

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;

  @GetMapping("/list")
  public List<String> List()
  {
    int count=redisTemplate.opsForValue().increment("jsbdemo:list").intValue();
    logger.info("hello world:{}",count);
    return goodsService.List();
  }
}