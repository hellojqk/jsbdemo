package com.hellojqk.jsbdemo;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@MapperScan("com.hellojqk.jsbdemo.mapper")
//@ServletComponentScan
public class DemoApplication {

	public static void main(String[] args) { SpringApplication.run(DemoApplication.class, args);
	}

}
