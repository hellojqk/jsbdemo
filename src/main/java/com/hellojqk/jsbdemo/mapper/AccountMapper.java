package com.hellojqk.jsbdemo.mapper;

// import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hellojqk.jsbdemo.entity.AccountDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangyang
 * @date 2020/9/6 3:33 下午
 */
@Mapper
//@DS("blog")
public interface AccountMapper extends BaseMapper<AccountDO> {
}
