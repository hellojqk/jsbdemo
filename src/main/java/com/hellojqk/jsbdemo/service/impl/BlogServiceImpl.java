package com.hellojqk.jsbdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hellojqk.jsbdemo.entity.AccountDO;
import com.hellojqk.jsbdemo.entity.BlogDO;
import com.hellojqk.jsbdemo.mapper.AccountMapper;
import com.hellojqk.jsbdemo.mapper.BlogMapper;
import com.hellojqk.jsbdemo.service.BlogService;
import com.hellojqk.jsbdemo.vo.BlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wangyang
 * @date 2020/9/7 12:35 上午
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int add(AccountDO accountDO, BlogVO blog) {

        BlogDO blogDO = new BlogDO();
        blogDO.setTitle(blog.getTitle());
        blogDO.setContent(blog.getContent());
        blogDO.setCreateAccountId(accountDO.getId());
        blogDO.setCreateTime(new Date());
        return blogMapper.insert(blogDO);
    }

    @Override
    public  IPage<BlogDO> list(int current, int size) {
        Page<BlogDO> page = new Page<>(current, size);
        QueryWrapper<BlogDO> blogDOQueryWrapper = new QueryWrapper<>();
        IPage<BlogDO> blogDOPage = blogMapper.selectPage(page, blogDOQueryWrapper);
        int count = blogMapper.selectCount(blogDOQueryWrapper);
        blogDOPage.setTotal(count);
        return blogDOPage;
    }
}
