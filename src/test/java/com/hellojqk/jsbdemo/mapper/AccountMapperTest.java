package com.hellojqk.jsbdemo.mapper;

import com.hellojqk.jsbdemo.entity.AccountDO;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wangyang
 * @date 2020/9/6 3:52 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testConnect(){
        byte[] password= DigestUtils.sha1("123123");
       int accountId= accountMapper.insert(new AccountDO("admin3",DigestUtils.sha1Hex("123123")));
       assertNotEquals(0,accountId);
    }
}