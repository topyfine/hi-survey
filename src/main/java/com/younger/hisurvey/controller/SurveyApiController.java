package com.younger.hisurvey.controller;

import com.alibaba.fastjson.JSON;
import com.younger.hisurvey.controller.base.Result;
import com.younger.hisurvey.controller.base.Results;
import com.younger.hisurvey.controller.vo.*;
import com.younger.hisurvey.dao.QuestionnaireAnswerDao;
import com.younger.hisurvey.dao.QuestionnaireReleaseDao;
import com.younger.hisurvey.dao.entity.QuestionnaireAnswer;
import com.younger.hisurvey.dao.entity.QuestionnaireRelease;
import com.younger.hisurvey.dto.QuestionnaireAnswerDTO;
import com.younger.hisurvey.dto.QuestionnaireAnswerQuestionnaireDTO;
import com.younger.hisurvey.dto.QuestionnaireDTO;
import com.younger.hisurvey.service.QuestionnaireAnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author topyfine
 * @description 应用端接口
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/survey/api")
public class SurveyApiController {
    private final QuestionnaireReleaseDao questionnaireReleaseDao;
    private final QuestionnaireAnswerService questionnaireAnswerService;
    private final QuestionnaireAnswerDao questionnaireAnswerDao;

    /**
     * 获取问卷
     *
     * @param requestVO
     * @return
     */
    @PostMapping(value = "/getQuestionnaire", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<GetQuestionnaireReleaseResponseVO> getQuestionnaire(@Validated @RequestBody GetQuestionnaireReleaseRequestVO requestVO) {
        GetQuestionnaireReleaseResponseVO responseVO = new GetQuestionnaireReleaseResponseVO();
        QuestionnaireRelease questionnaireRelease = questionnaireReleaseDao.getById(requestVO.getQuestionnaireReleaseId());
        responseVO.setQuestionnaireReleaseId(questionnaireRelease.getId());
        GetQuestionnaireReleaseQuestionnaireVO questionnaireVO = new GetQuestionnaireReleaseQuestionnaireVO();
        QuestionnaireDTO questionnaireDTO = JSON.parseObject(questionnaireRelease.getContent(), QuestionnaireDTO.class);
        BeanUtils.copyProperties(questionnaireDTO, questionnaireVO);
        responseVO.setContent(questionnaireVO);
        return Results.success(responseVO);
    }

    /**
     * 提交问卷
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/addQuestionnaireAnswer")
    public Result<String> addQuestionnaireAnswer(@Validated @RequestBody AddQuestionnaireAnswerRequestVO requestVO) {
        QuestionnaireAnswerDTO questionnaireAnswerDTO = new QuestionnaireAnswerDTO();
        BeanUtils.copyProperties(requestVO, questionnaireAnswerDTO);
        questionnaireAnswerService.saveQuestionnaireAnswer(questionnaireAnswerDTO);
        return Results.success("操作成功");
    }

    /**
     * 查看问卷回答
     *
     * @param requestVO
     * @return
     */
    @PostMapping(value = "/getQuestionnaireAnswer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<GetQuestionnaireAnswerResponseVO> getQuestionnaireAnswer(@Validated @RequestBody GetQuestionnaireAnswerRequestVO requestVO) {
        GetQuestionnaireAnswerResponseVO responseVO = new GetQuestionnaireAnswerResponseVO();
        QuestionnaireAnswer questionnaireAnswer = questionnaireAnswerDao.getById(requestVO.getQuestionnaireAnswerId());
        responseVO.setQuestionnaireAnswerId(questionnaireAnswer.getId());
        GetQuestionnaireAnswerQuestionnaireVO questionnaireVO = new GetQuestionnaireAnswerQuestionnaireVO();
        QuestionnaireAnswerQuestionnaireDTO answerQuestionnaireDTO = JSON.parseObject(questionnaireAnswer.getContent(), QuestionnaireAnswerQuestionnaireDTO.class);
        BeanUtils.copyProperties(answerQuestionnaireDTO, questionnaireVO);
        responseVO.setAnswer(questionnaireVO);
        return Results.success(responseVO);
    }
}
