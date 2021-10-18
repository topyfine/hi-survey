package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/18
 */
@Data
public class GetQuestionnaireReleaseOptionVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 选项id
     */
    private Long optionId;
    /**
     * 所属题目id
     */
    private Long questionId;
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
