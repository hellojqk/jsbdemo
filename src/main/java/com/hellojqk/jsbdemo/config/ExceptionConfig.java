package com.hellojqk.jsbdemo.config;

import com.hellojqk.jsbdemo.constant.ErrorEnum;
import com.hellojqk.jsbdemo.dto.base.BaseErrorResult;
import com.hellojqk.jsbdemo.dto.base.BaseResult;
import com.hellojqk.jsbdemo.exception.InsufficientPermissionsException;
import com.hellojqk.jsbdemo.exception.ProcessingFailedException;
import com.hellojqk.jsbdemo.exception.UnauthorizedException;
import com.hellojqk.jsbdemo.exception.ValidationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wangyang
 * @date 2020/10/18 2:25 下午
 */
@ControllerAdvice
public class ExceptionConfig {

    @ResponseBody
    @ExceptionHandler(value = InsufficientPermissionsException.class)
    public BaseResult handler(InsufficientPermissionsException ex, HttpServletResponse response) {
        return new BaseErrorResult(ErrorEnum.INSUFFICIENT_PERMISSIONS, response);
    }

    @ResponseBody
    @ExceptionHandler(value = ProcessingFailedException.class)
    public BaseResult handler(ProcessingFailedException ex, HttpServletResponse response) {
        return new BaseErrorResult(ErrorEnum.PROCESSING_FAILED, response);
    }

    @ResponseBody
    @ExceptionHandler(value = UnauthorizedException.class)
    public BaseResult handler(UnauthorizedException ex, HttpServletResponse response) {
        return new BaseErrorResult(ErrorEnum.UNAUTHORIZED, response);
    }

    @ResponseBody
    @ExceptionHandler(value = ValidationFailedException.class)
    public BaseResult handler(ValidationFailedException ex, HttpServletResponse response) {
        return new BaseErrorResult(ErrorEnum.VALIDATION_FAILED, response);
    }

    @ResponseBody
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResult handler(NoHandlerFoundException ex) {
        return new BaseErrorResult("NOT_FOUND", "未找到");
    }


    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public BaseResult handler(RuntimeException ex, HttpServletResponse response) {
        return new BaseErrorResult(ex, response);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResult handler(Exception ex, HttpServletResponse response) {
        return new BaseErrorResult(ex, response);
    }
}
