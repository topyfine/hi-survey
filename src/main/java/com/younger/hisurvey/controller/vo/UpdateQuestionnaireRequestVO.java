package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 */
@Data
public class UpdateQuestionnaireRequestVO extends BaseRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 问卷id
     */
    private Long questionnaireId;
    /**
     * 问卷名称
     */
    private String name;
    /**
     * 分值
     */
    private Integer score;
    /**
     * 描述
     */
    private String remark;
}
