package com.hellojqk.jsbdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hellojqk.jsbdemo.entity.AccountDO;
import com.hellojqk.jsbdemo.entity.BlogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangyang
 * @date 2020/9/7 12:36 上午
 */
@Mapper
public interface BlogMapper extends BaseMapper<BlogDO> {
}
