package com.hellojqk.jsbdemo.dto.base;

import com.hellojqk.jsbdemo.constant.ErrorEnum;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author wangyang
 * @date 2020/10/18 2:09 下午
 */
@Slf4j
public class BaseErrorResult extends BaseResult {

    public BaseErrorResult(ErrorEnum errorEnum, HttpServletResponse response) {
        this.errorCode = errorEnum.getErrorCode();
        this.errorMessage = errorEnum.getErrorMessage();
        response.setStatus(errorEnum.getHttpStatus().value());
    }

    public BaseErrorResult(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private String errorCode;
    private String errorMessage;
    private String stack;
    private String requestId;

    public BaseErrorResult(Exception ex, HttpServletResponse response) {
        this.errorCode = ErrorEnum.INTERNAL_SERVER_ERROR.getErrorCode();
        response.setStatus(ErrorEnum.INTERNAL_SERVER_ERROR.getHttpStatus().value());

        this.errorMessage = ex.getMessage();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        this.stack = sw.toString();
        log.error(ex.getMessage(), ex);
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
