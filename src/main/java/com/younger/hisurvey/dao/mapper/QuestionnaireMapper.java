package com.younger.hisurvey.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.younger.hisurvey.dao.entity.Questionnaire;
import org.apache.ibatis.annotations.Mapper;

/**
 * 问卷(survey_questionnaire)数据Mapper
 *
 * @author topyfine
 * @since 2021-10-18
 * @description
 */
@Mapper
public interface QuestionnaireMapper extends BaseMapper<Questionnaire> {

}
