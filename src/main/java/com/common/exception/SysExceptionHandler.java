package com.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Bandit
 * @createTime 2022/6/8 19:03
 */
@ControllerAdvice
@Slf4j
public class SysExceptionHandler {

    @ExceptionHandler(CannotGetJdbcConnectionException.class)
    public String OracleExceptionHandler(CannotGetJdbcConnectionException e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute("msg", "数据库连接有问题...");
        return "exception";
    }

    @ExceptionHandler(Exception.class)
    public String ExceptionHandler(Exception e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute("msg", "未知错误...");
        return "exception";
    }

}
