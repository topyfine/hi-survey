package com.younger.hisurvey.controller.base;

import lombok.Getter;

/**
 * @author topyfine
 */
public enum ResultCodeEnum {
    SUCCESS(0, "ok"),
    ERROR(-1, "error")
    ;

    @Getter
    private int code;
    @Getter
    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
