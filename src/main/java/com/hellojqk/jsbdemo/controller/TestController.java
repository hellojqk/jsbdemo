package com.hellojqk.jsbdemo.controller;

import com.hellojqk.jsbdemo.dto.base.BaseResult;
import com.hellojqk.jsbdemo.exception.UnauthorizedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangyang
 * @date 2020/10/18 2:29 下午
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("UnauthorizedException")
    public BaseResult unauthorizedException() {
        throw new UnauthorizedException();
    }

    @GetMapping("parse")
    public BaseResult parse() {
        String a = "fadfadf";
        Integer.parseInt(a);
        return null;
    }
}
