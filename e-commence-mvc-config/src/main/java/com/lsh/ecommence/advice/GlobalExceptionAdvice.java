package com.lsh.ecommence.advice;

import com.lsh.ecommence.exception.BusinessException;
import com.lsh.ecommence.result.R;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @Author lishaohui
 * @Date 2023/5/25 13:33
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    /**
     * <p>
     * 统一异常处理
     * </p>
     *
     * @param e 异常
     * @return .
     */
    @ExceptionHandler(value = Exception.class)
    public R<Object> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return R.error();
    }

    /**
     * <p>
     * 自定义异常
     * </p>
     *
     * @param e 异常
     * @return .
     */
    @ExceptionHandler(value = BusinessException.class)
    public R<Object> handleException(BusinessException e) {
        log.error(e.getMessage(), e);
        // @formatter:off
        return R
                .error()
                .message(e.getMessage())
                .code(e.getCode());
        // @formatter:on
    }

    /**
     * <p>
     * controller上层异常 批量异常处理
     * </p>
     *
     * @param e e
     * @return .
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpRequestMethodNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotAcceptableException.class,
            AsyncRequestTimeoutException.class,
            MissingServletRequestPartException.class,
            ConversionNotSupportedException.class,
            ServletRequestBindingException.class
    })
    public R<Object> handleServletException(Exception e) {
        log.info(e.getMessage(), e);
        // @formatter:off
        return R
                .error()
                .message(R.RE.SERVLET_ERROR.getMessage())
                .code(R.RE.SERVLET_ERROR.getCode());
        // @formatter:on
    }

}
