package com.xiong.config.annotation;

import java.lang.annotation.*;

/**
 * @Author xiong
 * @Description 标记打印web请求
 * @Date 17:31 2019/5/20
 * @Param
 * @return
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebLog {

    String description() default "";
}
