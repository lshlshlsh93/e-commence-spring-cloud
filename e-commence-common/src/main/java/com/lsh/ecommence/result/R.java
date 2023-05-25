package com.lsh.ecommence.result;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author lishaohui
 * @Date 2023/5/25 12:45
 * @Decription <div>
 * <h1> 通用响应对象 </h1>
 * <body>
 * { "code":1, "message":"", "data":{} }
 * </body>
 * </div>
 */
@Data
public class R<T> implements Serializable {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 构造函数私有化
     */
    private R() {

    }

    public R(Integer code, String message, T data) {

    }

    public R(Integer code, RE message, T data) {

    }

    /**
     * @return 返回成功结果
     */
    public static <T> R<T> ok() {
        R<T> r = new R<>();
        r.setCode(RE.SUCCESS.getCode());
        r.setMessage(RE.SUCCESS.getMessage());
        return r;
    }

    /**
     * @return 返回失败结果
     */
    public static <T> R<T> error() {
        R<T> r = new R<>();
        r.setCode(RE.FAIL.getCode());
        r.setMessage(RE.FAIL.getMessage());
        return r;
    }


    /**
     * @param re 枚举
     * @return 设置特定的返回结果
     */
    public static <T> R<T> setResult(RE re) {
        R<T> r = new R<>();
        r.setCode(re.getCode());
        r.setMessage(re.getMessage());
        return r;
    }

    /**
     * 自定义响应消息
     *
     * @param message 响应信息
     * @return 设置特定的响应信息
     */
    public R<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 自定义响应码
     *
     * @param code 响应码
     * @return 设置特定的响应码
     */
    public R<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * @Author lishaohui
     * @Date 2023/5/25 12:53
     */
    @Getter
    @AllArgsConstructor
    @ToString
    public enum RE {

        COMMON(0, ""),

        SUCCESS(200, "请求成功"),
        FAIL(201, "请求失败"),


        //-1xx 服务器错误

        /**
         * sql语法错误
         */
        BAD_SQL_GRAMMAR_ERROR(-101, "sql语法错误"),

        /**
         * servlet请求异常
         */
        SERVLET_ERROR(-102, "servlet请求异常"),


        //-2xx 参数校验
        /**
         * 参数不能为空
         */
        PARAM_NULL_ERROR(-203, "参数不能为空"),

        // 4xx error

        /**
         * 没有访问权限，身份认证失败
         */
        SC_UNAUTHORIZED_ERROR(401, "没有访问权限，身份认证失败"),
        /**
         * 对不起! 您的权限不足
         */
        SC_FORBIDDEN_ERROR(403, "对不起! 您的权限不足"),

        /**
         * 404 请求资源不存在
         */
        _404_ERROR(404, "请求资源不存在"),
        ;

        private final Integer code;

        private final String message;

    }
}
