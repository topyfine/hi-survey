package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/15
 */
@Data
public class AddQuestionOptionVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 选项内容
     */
    private String content;
    /**
     * 是否为正确选项
     */
    private Integer isRightAnswer;
    /**
     * 排序
     */
    private Integer sort;
}
