package com.lsh.ecommence.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author lishaohui
 * @Date 2023/5/25 13:15
 * @Decription <div>
 * <h1>忽略统一响应注解</h1>
 * </div>
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {

}
