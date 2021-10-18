package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/16
 */
@Data
public class GetQuestionRequestVO extends BaseRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 题目id
     */
    private Long questionId;
}
