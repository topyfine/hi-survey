package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/17
 */
@Data
public class GetQuestionnaireReleaseResponseVO extends BaseResponseVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 已发布问卷id
     */
    private Long questionnaireReleaseId;
    /**
     * 问卷内容
     */
    private GetQuestionnaireReleaseQuestionnaireVO content;
}
