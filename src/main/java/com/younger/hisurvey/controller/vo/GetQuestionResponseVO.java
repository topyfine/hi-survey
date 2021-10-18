package com.younger.hisurvey.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author topyfine
 * @since 2021/10/16
 */
@Data
public class GetQuestionResponseVO extends BaseResponseVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 题目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long questionId;
    /**
     * 所属问卷
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
     * 题目选项
     */
    private List<GetQuestionOptionVO> optionList;
}
