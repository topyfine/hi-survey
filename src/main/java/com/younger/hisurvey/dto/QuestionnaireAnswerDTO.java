package com.younger.hisurvey.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/17
 */
@Data
public class QuestionnaireAnswerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 问卷作答记录id
     */
    private Long questionnaireAnswerId;
    /**
     * 所属发布问卷id
     */
    private Long questionnaireReleaseId;
    /**
     * 作答内容
     */
    private QuestionnaireAnswerQuestionnaireDTO answer;
}
