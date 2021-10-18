package com.younger.hisurvey.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.younger.hisurvey.dao.entity.Questionnaire;
import com.younger.hisurvey.dao.mapper.QuestionnaireMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * 问卷(survey_questionnaire)数据DAO
 *
 * @author topyfine
 * @since 2021-10-18
 * @description 
 */
@Slf4j
@Repository
public class QuestionnaireDao extends ServiceImpl<QuestionnaireMapper, Questionnaire> {

}