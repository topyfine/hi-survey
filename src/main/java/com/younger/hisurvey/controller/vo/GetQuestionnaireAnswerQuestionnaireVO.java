package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author topyfine
 * @since 2021/10/18
 */
@Data
public class GetQuestionnaireAnswerQuestionnaireVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 问卷id
     */
    private Long questionBankId;
    /**
     * 问卷名称
     */
    private String name;
    /**
     * 描述
     */
    private String remark;
    /**
     * 问卷题目
     */
    private List<GetQuestionnaireAnswerQuestionVO> questionVOList;
}
