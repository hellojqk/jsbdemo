package com.hellojqk.jsbdemo.controller;

import java.util.List;

import javax.annotation.Resource;

import com.hellojqk.jsbdemo.service.GoodsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

  @Resource
  private GoodsService goodsService;

  @GetMapping("/list")
  public List<String> List(){
    return goodsService.List();
  }
}