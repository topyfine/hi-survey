package com.younger.hisurvey.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.younger.hisurvey.dao.entity.Questionnaire;
import com.younger.hisurvey.dto.QuestionnaireDTO;

/**
 * 问卷服务接口
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
public interface QuestionnaireService {
    /**
     * 添加问卷
     *
     * @param questionnaireDTO
     */
    void saveQuestionnaire(QuestionnaireDTO questionnaireDTO);

    /**
     * 编辑问卷
     *
     * @param questionnaireDTO
     */
    void updateQuestionnaire(QuestionnaireDTO questionnaireDTO);

    /**
     * 删除问卷
     *
     * @param questionnaireId
     */
    void removeQuestionnaire(Long questionnaireId);

    /**
     * 查询问卷详情
     *
     * @param questionnaireId
     * @return
     */
    QuestionnaireDTO getQuestionnaire(Long questionnaireId);

    /**
     * 查询问卷列表
     *
     * @param queryPage
     * @param questionnaireDTO
     * @return
     */
    IPage<Questionnaire> listQuestionnaires(IPage<Questionnaire> queryPage, QuestionnaireDTO questionnaireDTO);
}
