package com.hellojqk.jsbdemo.controller;

import java.util.List;

import javax.annotation.Resource;

import com.hellojqk.jsbdemo.service.GoodsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class GoodsController {

  private static final Logger LOG = LoggerFactory.getLogger(GoodsController.class);

  @Resource
  private GoodsService goodsService;

  @GetMapping("/list")
  public List<String> List()
  {
    LOG.info("1233fafaofnaifjo12222");
    return goodsService.List();
  }
}