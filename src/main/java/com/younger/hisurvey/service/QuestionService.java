package com.younger.hisurvey.service;


import com.younger.hisurvey.dto.QuestionDTO;

/**
 * 题目服务接口
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
public interface QuestionService {
    /**
     * 添加题目
     *
     * @param questionDTO
     */
    void saveQuestion(QuestionDTO questionDTO);

    /**
     * 编辑题目
     *
     * @param questionDTO
     */
    void updateQuestion(QuestionDTO questionDTO);

    /**
     * 删除题目
     *
     * @param questionId
     */
    void removeQuestion(Long questionId);

    /**
     * 查询问题详情
     *
     * @param questionId
     */
    QuestionDTO getQuestion(Long questionId);
}
