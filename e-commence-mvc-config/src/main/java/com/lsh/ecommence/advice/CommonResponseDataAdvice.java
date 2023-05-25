package com.lsh.ecommence.advice;

import com.lsh.ecommence.annotation.IgnoreResponseAdvice;
import com.lsh.ecommence.result.R;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @Author lishaohui
 * @Date 2023/5/25 13:19
 * @Decription <div>
 * <h1>实现统一响应</h1>
 * </div>
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {


    /**
     * <h2>判断是否需要对响应进行处理</h2>
     *
     * @param methodParameter 方法参数
     * @param converterType   类型
     * @return Boolean
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        Method method = methodParameter.getMethod();
        Class<?> clazz = methodParameter.getDeclaringClass();
        if (method == null) {
            return false;
        }
        if (clazz.isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return !method.isAnnotationPresent(IgnoreResponseAdvice.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        R<Object> response = R.setResult(R.RE.COMMON);
        if (null == body) {
            return response;
        } else if (body instanceof R r) {
            response = r;
        } else {
            response.setData(body);
        }
        return response;
    }
}
