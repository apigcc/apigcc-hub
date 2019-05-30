package com.apigcc.hub.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Rest请求异常处理器
 *
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity exceptionAdvice(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(Response.fail(e.getMessage()));
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionAdvice(Exception e){
        log.error("Exception",e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Response.fail(e.getMessage()));
    }

}
