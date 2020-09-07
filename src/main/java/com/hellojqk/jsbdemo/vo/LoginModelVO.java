package com.hellojqk.jsbdemo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author wangyang
 * @date 2020/9/6 3:22 下午
 */
public class LoginModelVO {
    private String loginName;
    private String password;

    public String getLoginName() {
        return loginName;
    }

    @JsonProperty("loginName")
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }
}
