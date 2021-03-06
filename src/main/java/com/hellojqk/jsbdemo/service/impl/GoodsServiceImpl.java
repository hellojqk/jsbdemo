package com.hellojqk.jsbdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hellojqk.jsbdemo.service.GoodsService;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

  // private Logger logger= LogManager.getLogger(this.getClass());
  private static final Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);
  @Override
  public java.util.List<String> List() {
    List<String> list=new ArrayList<String>();
    list.add("商品1");
    list.add("商品2");
    logger.info("list");
    return list;
  }

}