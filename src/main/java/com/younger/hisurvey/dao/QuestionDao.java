package com.younger.hisurvey.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.younger.hisurvey.dao.entity.Question;
import com.younger.hisurvey.dao.mapper.QuestionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * 题目(survey_question)数据DAO
 *
 * @author topyfine
 * @since 2021-10-18
 * @description 
 */
@Slf4j
@Repository
public class QuestionDao extends ServiceImpl<QuestionMapper, Question> {

}