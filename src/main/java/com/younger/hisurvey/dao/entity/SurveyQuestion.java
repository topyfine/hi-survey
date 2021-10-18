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
 * 题目(survey_question)实体类
 *
 * @author topyfine
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("survey_question")
public class SurveyQuestion implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
	private Long id;
    /**
     * 所属题库
     */
    private Long questionBankId;
    /**
     * 题目类型：1-单选题、2-多选题、3-主观题
     */
    private Integer type;
    /**
     * 试题内容
     */
    private String content;
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