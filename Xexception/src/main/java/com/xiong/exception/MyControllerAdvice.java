package com.xiong.exception;

import com.xiong.core.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName MyControllerAdvice
 * @Description controller全局异常捕获
 * @Author xiong
 * @Date 2019/5/16 16:24
 * @Version 1.0
 **/
@ControllerAdvice
@Slf4j
public class MyControllerAdvice {

    /**
     * @Author xiong
     * @Description //全局异常捕获处理
     * @Date 9:07 2019/5/17
     * @Param [e]
     * @return com.xiong.core.model.Result
     **/
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e){
        log.error(e.getMessage(),e);
        return new Result.Builder().error(e).build();
    }

    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public Result myExceptionHandler(MyException e){
        log.error(e.getMessage(),e);
        return new Result.Builder().error(e).build();
    }



}
