package com.hellojqk.jsbdemo.service;

import com.hellojqk.jsbdemo.entity.AccountDO;
import com.hellojqk.jsbdemo.vo.LoginModelVO;

/**
 * @author wangyang
 * @date 2020/9/6 3:07 下午
 */
public interface AccountService {

    AccountDO register(String name,String password);

    AccountDO login(String name,String password);

    AccountDO login(LoginModelVO loginModelVO);
}
