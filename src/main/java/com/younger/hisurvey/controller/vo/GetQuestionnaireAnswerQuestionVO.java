package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author topyfine
 * @since 2021/10/18
 */
@Data
public class GetQuestionnaireAnswerQuestionVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 题目id
     */
    private Long questionId;
    /**
     * 所属问卷
     */
    private Long questionBankId;
    /**
     * 题目类型
     */
    private Integer type;
    /**
     * 题目内容
     */
    private String content;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 题目选项
     */
    private List<GetQuestionnaireAnswerOptionVO> optionVOList;
}
