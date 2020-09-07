package com.hellojqk.jsbdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hellojqk.jsbdemo.entity.AccountDO;
import com.hellojqk.jsbdemo.entity.BlogDO;
import com.hellojqk.jsbdemo.vo.BlogVO;

/**
 * @author wangyang
 * @date 2020/9/7 12:33 上午
 */
public interface BlogService {
    int add(AccountDO accountDO, BlogVO blog);
    IPage<BlogDO> list(int current, int size);
}
