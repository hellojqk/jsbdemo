package com.hellojqk.jsbdemo.constant;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @author wangyang
 * @date 2020/10/18 2:10 下午
 */
public enum ErrorEnum {

    /**
     * 标准服务异常
     */
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "服务异常", HttpStatus.INTERNAL_SERVER_ERROR),

    /**
     * 请求处理失败笼统表达
     */
    PROCESSING_FAILED("PROCESSING_FAILED", "请求处理失败", HttpStatus.BAD_REQUEST),

    /**
     * 针对参数校验未通过
     */
    VALIDATION_FAILED("VALIDATION_FAILED", "请求参数校验为通过", HttpStatus.BAD_REQUEST),

    /**
     * 针对没有登录或登录过期
     */
    UNAUTHORIZED("UNAUTHORIZED", "未授权", HttpStatus.UNAUTHORIZED),

    /**
     * 针对权限不足
     */
    INSUFFICIENT_PERMISSIONS("INSUFFICIENT_PERMISSIONS", "权限不足", HttpStatus.FORBIDDEN),

    /**
     * 页面不存在
     */
    NOT_FOUND("INSUFFICIENT_PERMISSIONS", "权限不足", HttpStatus.NOT_FOUND);

    private String errorCode;
    private String errorMessage;
    private HttpStatus httpStatus;

    private ErrorEnum(String errorCode, String errorMessage, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
