package com.younger.hisurvey.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.younger.hisurvey.dao.entity.Question;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目(survey_question)数据Mapper
 *
 * @author topyfine
 * @since 2021-10-18
 * @description
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}
