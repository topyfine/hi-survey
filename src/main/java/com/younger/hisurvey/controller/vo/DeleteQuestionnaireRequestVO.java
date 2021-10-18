package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 */
@Data
public class DeleteQuestionnaireRequestVO extends BaseRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 问卷id
     */
    private Long questionnaireId;
}
