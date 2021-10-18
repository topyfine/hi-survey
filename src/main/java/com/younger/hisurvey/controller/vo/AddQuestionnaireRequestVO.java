package com.younger.hisurvey.controller.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author topyfine
 */
@Data
public class AddQuestionnaireRequestVO extends BaseRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 问卷名称
     */
    @NotBlank(message = "问卷名称不能为空")
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
