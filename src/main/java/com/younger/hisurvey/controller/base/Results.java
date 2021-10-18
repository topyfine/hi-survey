package com.younger.hisurvey.controller.base;

/**
 * @author topyfine
 * @since 2021/10/17
 */
public class Results {
    /**
     * 响应成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 响应失败
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(T data) {
        return new Result<T>(ResultCodeEnum.ERROR.getCode(), ResultCodeEnum.ERROR.getMsg(), data);
    }
}
