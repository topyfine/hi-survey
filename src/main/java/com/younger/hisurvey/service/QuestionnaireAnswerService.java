package com.younger.hisurvey.service;


import com.younger.hisurvey.dto.QuestionnaireAnswerDTO;

/**
 * 问卷作答记录服务接口
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
public interface QuestionnaireAnswerService {
    /**
     * 添加问卷作答记录
     *
     * @param questionnaireAnswerDTO
     */
    void saveQuestionnaireAnswer(QuestionnaireAnswerDTO questionnaireAnswerDTO);
}
