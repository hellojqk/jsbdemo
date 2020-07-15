package com.hellojqk.jsbdemo.controller;

import javax.annotation.Resource;

import com.hellojqk.jsbdemo.domain.AccountCart;
import com.hellojqk.jsbdemo.service.GoodsService;

import com.hellojqk.jsbdemo.service.AccountCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GoodsController {

  // private Logger logger= LogManager.getLogger(this.getClass());
  private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

  @Resource
  private GoodsService goodsService;

  @Resource
  private AccountCartService accountCartService;

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;

  @GetMapping("/list")
  public Page<AccountCart> List()
  {
    int count=redisTemplate.opsForValue().increment("jsbdemo:list").intValue();
    logger.info("hello world:{}",count);
//    return goodsService.List();
    int cartCount=accountCartService.count();
    logger.info("hello world2:{}",cartCount);
    return accountCartService.findByPageAndParams(1,10);
  }
}