package com.lsh.ecommence.exception;

import com.lsh.ecommence.result.R;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author lishaohui
 * @Date 2023/5/25 13:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    /**
     *
     * @param message 错误信息
     */
    public BusinessException(String message){
        this.message = message;
    }

    /**
     *
     * @param message 错误信息
     * @param code 错误码
     */
    public BusinessException(String message, Integer code){
        this.message = message;
        this.code = code;
    }

    /**
     *
     * @param message 错误信息
     * @param code 错误码
     * @param cause 原始异常对象
     */
    public BusinessException(String message, Integer code, Throwable cause){
        super(cause);
        this.message = message;
        this.code = code;
    }

    /**
     *
     * @param resultCodeEnum 接收枚举类型
     */
    public BusinessException(R.RE resultCodeEnum){
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }

    /**
     *
     * @param resultCodeEnum 接收枚举类型
     * @param cause 原始异常对象
     */
    public BusinessException(R.RE resultCodeEnum, Throwable cause){
        super(cause);
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }


}
