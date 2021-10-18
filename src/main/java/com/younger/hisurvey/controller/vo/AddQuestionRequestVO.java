package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author topyfine
 * @since 2021/10/15
 */
@Data
public class AddQuestionRequestVO extends BaseRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 所属问卷
     */
    private Long questionnaireId;
    /**
     * 题目类型
     */
    private Integer type;
    /**
     * 题目内容
     */
    private String content;
    /**
     * 分值
     */
    private Integer score;
    /**
     * 排序
     */
    private Integer sort;

    /**
     * 题目选项列表
     */
    private List<AddQuestionOptionVO> optionList;
}
