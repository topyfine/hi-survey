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
 * 题目选项(survey_option)实体类
 *
 * @author topyfine
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("survey_option")
public class SurveyOption implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
	private Long id;
    /**
     * 所属题目
     */
    private Long questionId;
    /**
     * 选项内容
     */
    private String content;
    /**
     * 是否为正确选项：0-否，1-是
     */
    private Integer isRightAnswer;
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