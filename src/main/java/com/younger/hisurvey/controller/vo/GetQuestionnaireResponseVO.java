package com.younger.hisurvey.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author topyfine
 * @since 2021/10/17
 */
@Data
public class GetQuestionnaireResponseVO extends BaseResponseVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 问卷id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
    /**
     * 问卷题目
     */
    private List<GetQuestionnaireQuestionVO> questionList;
}
