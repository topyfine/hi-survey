package com.younger.hisurvey.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.younger.hisurvey.dao.entity.QuestionnaireAnswer;
import com.younger.hisurvey.dao.mapper.QuestionnaireAnswerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * 问卷作答记录(survey_questionnaire_answer)数据DAO
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Slf4j
@Repository
public class QuestionnaireAnswerDao extends ServiceImpl<QuestionnaireAnswerMapper, QuestionnaireAnswer> {

}