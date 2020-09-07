package com.hellojqk.jsbdemo.vo;

/**
 * @author wangyang
 * @date 2020/9/7 12:34 上午
 */
public class BlogVO {
    private String title;
    private String content;

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

    @Override
    public String toString() {
        return "BlogVO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
