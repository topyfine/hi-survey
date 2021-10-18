package com.younger.hisurvey.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.younger.hisurvey.dao.entity.QuestionnaireAnswer;
import org.apache.ibatis.annotations.Mapper;

/**
 * 问卷作答记录(survey_questionnaire_answer)数据Mapper
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Mapper
public interface QuestionnaireAnswerMapper extends BaseMapper<QuestionnaireAnswer> {

}
