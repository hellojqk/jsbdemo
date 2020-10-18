package com.hellojqk.jsbdemo.exception;

/**
 * @author wangyang
 * @date 2020/10/18 2:21 下午
 */
public class ProcessingFailedException extends RuntimeException {
    public ProcessingFailedException() {
        super();
    }

    public ProcessingFailedException(String message) {
        super(message);
    }
}
