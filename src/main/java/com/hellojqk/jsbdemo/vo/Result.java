package com.hellojqk.jsbdemo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangyang
 * @date 2020/9/6 5:40 下午
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 描述
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 结果对象
     */
    private T data;
}

