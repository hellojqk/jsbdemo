package com.hellojqk.jsbdemo;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@NacosPropertySource(dataId = "com.hellojqk.jsbdemo.properties", autoRefreshed = true) // https://help.aliyun.com/document_detail/94592.html
public class DemoApplication {

	public static void main(String[] args) { SpringApplication.run(DemoApplication.class, args);
	}

}
