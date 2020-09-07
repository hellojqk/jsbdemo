package com.hellojqk.jsbdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author wangyang
 * @date 2020/9/6 3:14 下午
 */
@TableName("account")
public class AccountDO {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;

    public AccountDO(){
    }
    public AccountDO(String name, String password) {
        this.setName(name);
        this.setPassword(password);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
