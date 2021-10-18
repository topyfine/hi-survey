package com.younger.hisurvey.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.younger.hisurvey.constant.Constants;
import com.younger.hisurvey.dao.QuestionnaireReleaseDao;
import com.younger.hisurvey.dao.entity.QuestionnaireRelease;
import com.younger.hisurvey.dto.QuestionnaireDTO;
import com.younger.hisurvey.service.QuestionnaireReleaseService;
import com.younger.hisurvey.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 问卷发布记录服务接口实现
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionnaireReleaseServiceImpl implements QuestionnaireReleaseService {
    private final QuestionnaireReleaseDao questionnaireReleaseDao;
    private final QuestionnaireService questionnaireService;

    @Override
    public synchronized void saveQuestionnaireRelease(Long questionnaireId) {
        QuestionnaireDTO questionnaireDTO = questionnaireService.getQuestionnaire(questionnaireId);
        // 版本更新，保证线程安全
        synchronized (this) {
            QuestionnaireRelease questionnaireRelease = new QuestionnaireRelease();
            questionnaireRelease.setQuestionnaireId(questionnaireId);
            questionnaireRelease.setContent(JSON.toJSONString(questionnaireDTO));
            QuestionnaireRelease lastQuestionnaireRelease = questionnaireReleaseDao.getOne(
                    new QueryWrapper<QuestionnaireRelease>().eq("questionnaire_id", questionnaireId)
                            .eq("status", Constants.Status.EBL)
                            .orderByDesc("version")
                            .last(Constants.SqlCondition.LIMIT_1)
            );
            int version = lastQuestionnaireRelease == null ? 1 : lastQuestionnaireRelease.getVersion() + 1;
            questionnaireRelease.setVersion(version);
            questionnaireRelease.setStatus(Constants.Status.EBL);
            Date nowDate = new Date();
            questionnaireRelease.setCreateTime(nowDate);
            questionnaireRelease.setUpdateTime(nowDate);
            questionnaireReleaseDao.save(questionnaireRelease);
        }
    }
}