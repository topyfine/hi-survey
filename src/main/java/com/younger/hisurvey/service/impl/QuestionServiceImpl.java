package com.younger.hisurvey.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.younger.hisurvey.constant.Constants;
import com.younger.hisurvey.dao.OptionDao;
import com.younger.hisurvey.dao.QuestionDao;
import com.younger.hisurvey.dao.entity.Option;
import com.younger.hisurvey.dao.entity.Question;
import com.younger.hisurvey.dto.OptionDTO;
import com.younger.hisurvey.dto.QuestionDTO;
import com.younger.hisurvey.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目服务接口实现
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;
    private final OptionDao optionDao;

    @Override
    @Transactional
    public void saveQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        BeanUtils.copyProperties(questionDTO, question);
        question.setStatus(Constants.Status.EBL);
        Date nowDate = new Date();
        question.setCreateTime(nowDate);
        question.setUpdateTime(nowDate);
        questionDao.save(question);
        if (CollectionUtils.isEmpty(questionDTO.getOptionList())) {
            return;
        }
        List<Option> optionList = questionDTO.getOptionList().stream().map(optionDTO -> {
            Option option = new Option();
            BeanUtils.copyProperties(optionDTO, option);
            option.setQuestionId(question.getId());
            option.setStatus(Constants.Status.EBL);
            option.setCreateTime(nowDate);
            option.setUpdateTime(nowDate);
            return option;
        }).collect(Collectors.toList());
        optionDao.saveBatch(optionList);
    }

    @Override
    public void updateQuestion(QuestionDTO questionDTO) {
        Question record = questionDao.getById(questionDTO.getQuestionId());
        if (record == null) {
            return;
        }
        Question question = new Question();
        question.setId(record.getId());
        question.setType(questionDTO.getType());
        question.setContent(questionDTO.getContent());
        question.setSort(questionDTO.getSort());
        questionDao.updateById(question);
    }

    @Override
    public void removeQuestion(Long questionId) {
        Question record = questionDao.getById(questionId);
        if (record == null) {
            return;
        }
        Question question = new Question();
        question.setId(record.getId());
        question.setStatus(Constants.Status.DEL);
        questionDao.updateById(question);
    }

    @Override
    public QuestionDTO getQuestion(Long questionId) {
        QuestionDTO questionDTO = new QuestionDTO();
        Question question = questionDao.getById(questionId);
        BeanUtils.copyProperties(question, questionDTO);
        questionDTO.setQuestionId(questionId);
        List<Option> optionList = optionDao.list(
                new QueryWrapper<Option>().eq("question_id", questionId)
                        .eq("status", Constants.Status.EBL)
                        .orderByDesc("sort")
        );
        if (CollectionUtils.isEmpty(optionList)) {
            return questionDTO;
        }
        List<OptionDTO> optionDTOList = optionList.stream().map(surveyOption -> {
            OptionDTO optionDTO = new OptionDTO();
            BeanUtils.copyProperties(surveyOption, optionDTO);
            optionDTO.setOptionId(surveyOption.getId());
            return optionDTO;
        }).collect(Collectors.toList());
        questionDTO.setOptionList(optionDTOList);
        return questionDTO;
    }
}