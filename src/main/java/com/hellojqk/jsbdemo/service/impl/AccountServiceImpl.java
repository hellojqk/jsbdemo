package com.hellojqk.jsbdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hellojqk.jsbdemo.entity.AccountDO;
import com.hellojqk.jsbdemo.mapper.AccountMapper;
import com.hellojqk.jsbdemo.service.AccountService;
import com.hellojqk.jsbdemo.vo.LoginModelVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author wangyang
* @date 2020/9/6 3:34 下午
*/
@Service
public class AccountServiceImpl implements AccountService {

   @Autowired
   private AccountMapper accountMapper;

   @Override
   public AccountDO register(String name, String password) {
       AccountDO accountDO = new AccountDO(name, password);
       int accountId = accountMapper.insert(accountDO);
       if (accountId == 0) {
           return null;
       }
       accountDO.setId(accountId);
       return accountDO;
   }

   @Override
   public AccountDO login(String name, String password) {
       return null;
   }

   @Override
   public AccountDO login(LoginModelVO loginModelVO) {
       QueryWrapper<AccountDO> accountDO = new QueryWrapper<>();
       accountDO.eq("name", loginModelVO.getLoginName());
       AccountDO dbAccountDO = accountMapper.selectOne(accountDO);
       String signPassword = DigestUtils.sha1Hex(loginModelVO.getPassword());
       if (signPassword.equalsIgnoreCase(dbAccountDO.getPassword())) {
           return dbAccountDO;
       }
       return null;
   }
}
