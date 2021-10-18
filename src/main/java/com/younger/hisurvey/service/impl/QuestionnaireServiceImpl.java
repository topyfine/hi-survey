package com.younger.hisurvey.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.younger.hisurvey.constant.Constants;
import com.younger.hisurvey.dao.OptionDao;
import com.younger.hisurvey.dao.QuestionDao;
import com.younger.hisurvey.dao.QuestionnaireDao;
import com.younger.hisurvey.dao.entity.Option;
import com.younger.hisurvey.dao.entity.Question;
import com.younger.hisurvey.dao.entity.Questionnaire;
import com.younger.hisurvey.dto.OptionDTO;
import com.younger.hisurvey.dto.QuestionDTO;
import com.younger.hisurvey.dto.QuestionnaireDTO;
import com.younger.hisurvey.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 问卷服务接口实现
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionnaireDao questionnaireDao;
    private final QuestionDao questionDao;
    private final OptionDao optionDao;

    @Override
    public void saveQuestionnaire(QuestionnaireDTO questionnaireDTO) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName(questionnaireDTO.getName());
        questionnaire.setRemark(questionnaireDTO.getRemark());
        questionnaire.setScore(questionnaireDTO.getScore());
        questionnaire.setStatus(Constants.Status.EBL);
        Date nowDate = new Date();
        questionnaire.setCreateTime(nowDate);
        questionnaire.setUpdateTime(nowDate);
        questionnaireDao.save(questionnaire);
    }

    @Override
    public void updateQuestionnaire(QuestionnaireDTO questionnaireDTO) {
        Questionnaire record = questionnaireDao.getById(questionnaireDTO.getQuestionnaireId());
        if (record == null) {
            return;
        }
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setId(record.getId());
        questionnaire.setName(questionnaireDTO.getName());
        questionnaire.setRemark(questionnaireDTO.getRemark());
        questionnaire.setScore(questionnaireDTO.getScore());
        questionnaireDao.updateById(questionnaire);
    }

    @Override
    public void removeQuestionnaire(Long questionnaireId) {
        Questionnaire record = questionnaireDao.getById(questionnaireId);
        if (record == null) {
            return;
        }
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setId(record.getId());
        questionnaire.setStatus(Constants.Status.DEL);
        questionnaireDao.updateById(questionnaire);
    }

    @Override
    public QuestionnaireDTO getQuestionnaire(Long questionnaireId) {
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
        Questionnaire questionnaire = questionnaireDao.getById(questionnaireId);
        if (questionnaire == null) {
            return questionnaireDTO;
        }
        BeanUtils.copyProperties(questionnaire, questionnaireDTO);
        questionnaireDTO.setQuestionnaireId(questionnaireId);
        // 问卷题目
        List<Question> questionList = questionDao.list(
                new QueryWrapper<Question>().eq("questionnaire_id", questionnaireId)
                        .eq("status", Constants.Status.EBL)
                        .orderByAsc("sort")
        );
        if (CollectionUtils.isEmpty(questionList)) {
            return questionnaireDTO;
        }
        List<Long> questionIdList = questionList.stream().map(Question::getId).collect(Collectors.toList());
        Map<Long, List<Option>> optionMap = optionDao.list(
                new QueryWrapper<Option>().in("question_id", questionIdList)
                        .eq("status", Constants.Status.EBL)
                        .orderByAsc("sort")
        ).stream().collect(Collectors.groupingBy(Option::getQuestionId));
        List<QuestionDTO> questionDTOList = questionList.stream().map(question -> {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setQuestionId(question.getId());
            // 题目选项
            List<Option> optionList = optionMap.get(question.getId());
            if (CollectionUtils.isEmpty(optionList)) {
                return questionDTO;
            }
            List<OptionDTO> optionDTOList = optionList.stream().map(option -> {
                OptionDTO optionDTO = new OptionDTO();
                BeanUtils.copyProperties(option, optionDTO);
                optionDTO.setOptionId(option.getId());
                return optionDTO;
            }).collect(Collectors.toList());
            questionDTO.setOptionList(optionDTOList);
            return questionDTO;
        }).collect(Collectors.toList());
        questionnaireDTO.setQuestionList(questionDTOList);
        return questionnaireDTO;
    }

    @Override
    public IPage<Questionnaire> listQuestionnaires(IPage<Questionnaire> queryPage, QuestionnaireDTO questionnaireDTO) {
        QueryWrapper<Questionnaire> queryWrapper = new QueryWrapper<Questionnaire>()
                .eq("status", Constants.Status.EBL)
                .orderByDesc("update_time");
        if (!StringUtils.isEmpty(questionnaireDTO.getName())) {
            queryWrapper.like("name", questionnaireDTO.getName());
        }
        // 不分页
        if (queryPage.getSize() == 0) {
            List<Questionnaire> records = questionnaireDao.list(queryWrapper);
            queryPage.setRecords(records);
            queryPage.setTotal(records.size());
            return queryPage;
        }
        return questionnaireDao.page(queryPage, queryWrapper);
    }
}