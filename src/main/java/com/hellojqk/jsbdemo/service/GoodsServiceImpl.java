package com.hellojqk.jsbdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

  @Override
  public java.util.List<String> List() {
    List<String> list=new ArrayList<String>();
    list.add("商品1");
    list.add("商品2");
    return list;
  }

}