package com.hellojqk.jsbdemo;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@NacosPropertySource(dataId = "com.hellojqk.jsbdemo.properties", autoRefreshed = true) // https://help.aliyun.com/document_detail/94592.html
@MapperScan("com.hellojqk.jsbdemo.mapper")
public class DemoApplication {

	public static void main(String[] args) { SpringApplication.run(DemoApplication.class, args);
	}

}
