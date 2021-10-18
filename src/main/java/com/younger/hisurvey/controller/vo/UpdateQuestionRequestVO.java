package com.younger.hisurvey.controller.vo;

import lombok.Data;

/**
 * @author topyfine
 * @since 2021/10/16
 */
@Data
public class UpdateQuestionRequestVO extends BaseRequestVO {
    private static final long serialVersionUID = 1L;
    /**
     * 题目id
     */
    private Long questionId;
    /**
     * 题目类型
     */
    private Integer type;
    /**
     * 题目内容
     */
    private String content;
    /**
     * 分值
     */
    private Integer score;
    /**
     * 排序
     */
    private Integer sort;
}
