package com.younger.hisurvey.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author topyfine
 * @since 2021/10/15
 */
@Data
public class QuestionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 题目id
     */
    private Long questionId;
    /**
     * 所属问卷id
     */
    private Long questionnaireId;
    /**
     * 题目类型：1-单选题、2-多选题、3-主观题
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
    private List<OptionDTO> optionList;
}
