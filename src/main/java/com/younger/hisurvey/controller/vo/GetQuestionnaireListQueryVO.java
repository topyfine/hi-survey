package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/17
 */
@Data
public class GetQuestionnaireListQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 问卷名称
     */
    private String name;
}
