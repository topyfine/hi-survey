package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author topyfine
 * @since 2021/10/17
 */
@Data
public class AddQuestionnaireAnswerQuestionVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 题目id
     */
    private Long questionId;
    /**
     * 所属问卷
     */
    private Long questionnaireId;
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
    /**
     * 选项
     */
    private List<AddQuestionnaireAnswerOptionVO> optionList;
}
