package com.younger.hisurvey.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * @author topyfine
 * @since 2021/10/16
 */
@Data
public class GetOptionResponseVO extends BaseResponseVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 选项id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long optionId;
    /**
     * 所属题目id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long questionId;
    /**
     * 选项内容
     */
    private String content;
    /**
     * 是否为正确选项
     */
    private Integer isRightAnswer;
    /**
     * 排序
     */
    private Integer sort;
}
