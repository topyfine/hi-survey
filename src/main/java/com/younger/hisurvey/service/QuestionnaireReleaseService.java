package com.younger.hisurvey.service;


/**
 * 问卷发布记录服务接口
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
public interface QuestionnaireReleaseService {
    /**
     * 添加问卷发布记录
     *
     * @param questionnaireId
     */
    void saveQuestionnaireRelease(Long questionnaireId);
}
