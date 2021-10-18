package com.younger.hisurvey.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/15
 */
@Data
public class OptionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 选项id
     */
    private Long optionId;
    /**
     * 所属题目
     */
    private Long questionId;
    /**
     * 选项内容
     */
    private String content;
    /**
     * 是否为正确选项：0-否，1-是
     */
    private Integer isRightAnswer;
    /**
     * 排序
     */
    private Integer sort;
}
