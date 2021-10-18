package com.younger.hisurvey.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 问卷作答记录(survey_questionnaire_answer)实体类
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("survey_questionnaire_answer")
public class QuestionnaireAnswer implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 所属已发布问卷id
     */
    private Long questionnaireReleaseId;
    /**
     * 作答内容，json字符串
     */
    private String content;
    /**
     * 分值
     */
    private Integer score;
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