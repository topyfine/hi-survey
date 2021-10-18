package com.younger.hisurvey.controller.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/17
 */
@Data
@AllArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误码描述
     */
    private String msg;
    /**
     * 响应结果
     */
    private T data;
}
