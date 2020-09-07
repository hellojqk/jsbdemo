package com.hellojqk.jsbdemo.service.impl;

import com.hellojqk.jsbdemo.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wangyang
 * @date 2020/9/6 3:50 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    void register() {
    }
}