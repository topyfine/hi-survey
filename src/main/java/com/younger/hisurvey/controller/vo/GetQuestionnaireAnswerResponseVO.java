package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/17
 */
@Data
public class GetQuestionnaireAnswerResponseVO extends BaseResponseVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 问卷作答记录id
     */
    private Long questionnaireAnswerId;
    /**
     * 作答内容
     */
    private GetQuestionnaireAnswerQuestionnaireVO answer;
}
