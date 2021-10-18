package com.younger.hisurvey.service.impl;

import com.alibaba.fastjson.JSON;
import com.younger.hisurvey.constant.Constants;
import com.younger.hisurvey.dao.QuestionnaireAnswerDao;
import com.younger.hisurvey.dao.entity.QuestionnaireAnswer;
import com.younger.hisurvey.dto.QuestionnaireAnswerDTO;
import com.younger.hisurvey.service.QuestionnaireAnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 问卷作答记录服务接口实现
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionnaireAnswerServiceImpl implements QuestionnaireAnswerService {
    private final QuestionnaireAnswerDao questionnaireAnswerDao;

    @Override
    public void saveQuestionnaireAnswer(QuestionnaireAnswerDTO questionnaireAnswerDTO) {
        QuestionnaireAnswer questionnaireAnswer = new QuestionnaireAnswer();
        questionnaireAnswer.setQuestionnaireReleaseId(questionnaireAnswerDTO.getQuestionnaireReleaseId());
        questionnaireAnswer.setContent(JSON.toJSONString(questionnaireAnswerDTO.getAnswer()));
        questionnaireAnswer.setStatus(Constants.Status.EBL);
        Date nowDate = new Date();
        questionnaireAnswer.setCreateTime(nowDate);
        questionnaireAnswer.setUpdateTime(nowDate);
        questionnaireAnswerDao.save(questionnaireAnswer);
    }
}