package com.hellojqk.jsbdemo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import com.hellojqk.jsbdemo.constant.Constant;
import com.hellojqk.jsbdemo.entity.AccountDO;
import com.hellojqk.jsbdemo.service.AccountService;
import com.hellojqk.jsbdemo.service.GoodsService;
import com.hellojqk.jsbdemo.vo.LoginModelVO;
import com.hellojqk.jsbdemo.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wangyang
 * @date 2020/9/6 3:07 下午
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/login")
    public Result Login(@RequestBody LoginModelVO loginModelVO) {
        Result result = new Result();
        if (loginModelVO == null) {
            return result;
        }
        AccountDO accountDO = accountService.login(loginModelVO);
        if (accountDO == null) {
            result.setMessage("用户名或密码不正确");
            return result;
        }

        JWTCreator.Builder jwtBuilder = JWT.create();
        jwtBuilder.withIssuedAt(new Date());
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 1);
        jwtBuilder.withExpiresAt(c.getTime());
        jwtBuilder.withIssuer("hellojqk");
        jwtBuilder.withSubject("jsbauth");
        jwtBuilder.withAudience("jsbdemo");
        jwtBuilder.withClaim("name", accountDO.getName());
        jwtBuilder.withClaim("id", accountDO.getId());
        String jwtStr = jwtBuilder.sign(Algorithm.HMAC256(Constant.JWTSignSecret));
        result.setData(jwtStr);
        result.setSuccess(true);
        return result;
    }
}
