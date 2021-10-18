package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/17
 */
@Data
public class GetQuestionnaireAnswerRequestVO extends BaseRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 问卷回答id
     */
    private Long questionnaireAnswerId;
}
