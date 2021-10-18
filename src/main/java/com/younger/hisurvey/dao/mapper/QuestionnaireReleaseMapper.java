package com.younger.hisurvey.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.younger.hisurvey.dao.entity.QuestionnaireRelease;
import org.apache.ibatis.annotations.Mapper;

/**
 * 问卷发布记录(survey_questionnaire_release)数据Mapper
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Mapper
public interface QuestionnaireReleaseMapper extends BaseMapper<QuestionnaireRelease> {

}
