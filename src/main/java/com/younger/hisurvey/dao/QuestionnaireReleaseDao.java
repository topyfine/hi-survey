package com.younger.hisurvey.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.younger.hisurvey.dao.entity.QuestionnaireRelease;
import com.younger.hisurvey.dao.mapper.QuestionnaireReleaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * 问卷发布记录(survey_questionnaire_release)数据DAO
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Slf4j
@Repository
public class QuestionnaireReleaseDao extends ServiceImpl<QuestionnaireReleaseMapper, QuestionnaireRelease> {

}