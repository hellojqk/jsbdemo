package com.hellojqk.jsbdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author wangyang
 * @date 2020/9/6 3:16 下午
 */
@TableName("blog")
public class BlogDO {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Integer createAccountId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCreateAccountId() {
        return createAccountId;
    }

    public void setCreateAccountId(Integer createAccountId) {
        this.createAccountId = createAccountId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BlogDO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createAccountId=" + createAccountId +
                ", createTime=" + createTime +
                '}';
    }
}
