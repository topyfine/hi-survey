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
 * 题目(survey_question)实体类
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("survey_question")
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
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