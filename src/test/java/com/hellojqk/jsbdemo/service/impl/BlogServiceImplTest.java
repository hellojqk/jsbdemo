package com.hellojqk.jsbdemo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hellojqk.jsbdemo.entity.AccountDO;
import com.hellojqk.jsbdemo.entity.BlogDO;
import com.hellojqk.jsbdemo.service.AccountService;
import com.hellojqk.jsbdemo.service.BlogService;
import com.hellojqk.jsbdemo.vo.BlogVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wangyang
 * @date 2020/9/7 12:40 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class BlogServiceImplTest {

    @Autowired
    private BlogService blogService;

    @Test
    void add() {
        for (int i = 0; i < 100; i++) {
            AccountDO accountDO = new AccountDO();
            accountDO.setId(1);
            BlogVO blogVO = new BlogVO();
            blogVO.setTitle("hahaha");
            blogVO.setContent("aaaaaaa");
            int blogID = blogService.add(accountDO, blogVO);
            assertNotEquals(0, blogID);
        }
    }

    @Test
    void list() {
        IPage<BlogDO> blogDOIPage = blogService.list(2, 10);
        System.out.printf("total:{}", blogDOIPage);
        for (BlogDO blog :
                blogDOIPage.getRecords()) {
            System.out.println(blog.getId());
        }
    }
}