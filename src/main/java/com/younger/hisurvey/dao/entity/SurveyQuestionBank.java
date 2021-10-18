package com.younger.hisurvey.dao.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 题库(survey_question_bank)实体类
 *
 * @author topyfine
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("survey_question_bank")
public class SurveyQuestionBank implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
	private Long id;
    /**
     * 问卷名称
     */
    private String name;
    /**
     * 描述
     */
    private String remark;
    /**
     * 状态：EBL-启用，DBL-禁用，DEL-已删除
     */
    private String status;
    /**
     * createTime
     */
    private Date createTime;
    /**
     * updateTime
     */
    @TableField(update = "now()")
	private Date updateTime;

}