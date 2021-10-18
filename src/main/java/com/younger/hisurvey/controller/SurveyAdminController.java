package com.younger.hisurvey.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.younger.hisurvey.controller.base.Result;
import com.younger.hisurvey.controller.base.Results;
import com.younger.hisurvey.controller.vo.*;
import com.younger.hisurvey.dao.OptionDao;
import com.younger.hisurvey.dao.entity.Option;
import com.younger.hisurvey.dao.entity.Questionnaire;
import com.younger.hisurvey.dto.OptionDTO;
import com.younger.hisurvey.dto.QuestionDTO;
import com.younger.hisurvey.dto.QuestionnaireDTO;
import com.younger.hisurvey.service.OptionService;
import com.younger.hisurvey.service.QuestionService;
import com.younger.hisurvey.service.QuestionnaireReleaseService;
import com.younger.hisurvey.service.QuestionnaireService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author topyfine
 * @description 管理端接口
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/survey/admin")
public class SurveyAdminController {
    private final QuestionnaireService questionnaireService;
    private final QuestionService questionService;
    private final OptionService optionService;
    private final OptionDao optionDao;
    private final QuestionnaireReleaseService questionnaireReleaseService;

    /**
     * 添加问卷
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/addQuestionnaire")
    public Result<String> addQuestionnaire(@Validated @RequestBody AddQuestionnaireRequestVO requestVO) {
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
        BeanUtils.copyProperties(requestVO, questionnaireDTO);
        questionnaireService.saveQuestionnaire(questionnaireDTO);
        return Results.success("操作成功");
    }

    /**
     * 编辑问卷
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/updateQuestionnaire")
    public Result<String> updateQuestionnaire(@Validated @RequestBody UpdateQuestionnaireRequestVO requestVO) {
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
        BeanUtils.copyProperties(requestVO, questionnaireDTO);
        questionnaireService.updateQuestionnaire(questionnaireDTO);
        return Results.success("操作成功");
    }

    /**
     * 删除问卷
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/deleteQuestionBank")
    public Result<String> deleteQuestionBank(@Validated @RequestBody DeleteQuestionnaireRequestVO requestVO) {
        questionnaireService.removeQuestionnaire(requestVO.getQuestionnaireId());
        return Results.success("操作成功");
    }

    /**
     * 查询问卷信息
     *
     * @param requestVO
     * @return
     */
    @PostMapping(value = "/getQuestionnaire", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<GetQuestionnaireResponseVO> getQuestionnaire(@Validated @RequestBody GetQuestionnaireRequestVO requestVO) {
        GetQuestionnaireResponseVO responseVO = new GetQuestionnaireResponseVO();
        QuestionnaireDTO questionnaireDTO = questionnaireService.getQuestionnaire(requestVO.getQuestionnaireId());
        BeanUtils.copyProperties(questionnaireDTO, responseVO);
        return Results.success(responseVO);
    }

    /**
     * 查询问卷列表
     *
     * @param pageRequestVO
     * @return
     */
    @PostMapping("/getQuestionnaireList")
    public PageResponseVO<GetQuestionnaireListQuestionnaireVO> getQuestionnaireList(@RequestBody @Validated PageRequestVO<GetQuestionnaireListQueryVO> pageRequestVO) {
        PageResponseVO<GetQuestionnaireListQuestionnaireVO> pageResponseVO = new PageResponseVO<>();
        Page<Questionnaire> queryPage = new Page<>(pageRequestVO.getPageNo(), pageRequestVO.getPageSize(), true);
        QuestionnaireDTO questionnaireDTO = new QuestionnaireDTO();
        if (pageRequestVO.getQuery() != null) {
            BeanUtils.copyProperties(pageRequestVO.getQuery(), questionnaireDTO);
        }
        IPage<Questionnaire> iPage = questionnaireService.listQuestionnaires(queryPage, questionnaireDTO);
        List<GetQuestionnaireListQuestionnaireVO> questionnaireVOList = iPage.getRecords().stream().map(questionnaire -> {
            GetQuestionnaireListQuestionnaireVO questionnaireVO = new GetQuestionnaireListQuestionnaireVO();
            BeanUtils.copyProperties(questionnaire, questionnaireVO);
            questionnaireVO.setQuestionnaireId(questionnaire.getId());
            return questionnaireVO;
        }).collect(Collectors.toList());
        pageResponseVO.setResults(questionnaireVOList);
        pageResponseVO.setPageNo(iPage.getCurrent());
        pageResponseVO.setPageSize(iPage.getSize());
        pageResponseVO.setTotal(iPage.getTotal());
        return pageResponseVO;
    }

    /**
     * 发布问卷
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/publishQuestionnaire")
    public Result<String> publishQuestionnaire(@Validated @RequestBody PublishQuestionnaireRequestVO requestVO) {
        questionnaireReleaseService.saveQuestionnaireRelease(requestVO.getQuestionnaireId());
        return Results.success("操作成功");
    }

    /**
     * 问卷添加题目
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/addQuestion")
    public Result<String> addQuestion(@Validated @RequestBody AddQuestionRequestVO requestVO) {
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(requestVO, questionDTO);
        questionService.saveQuestion(questionDTO);
        return Results.success("操作成功");
    }

    /**
     * 编辑题目
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/updateQuestion")
    public Result<String> updateQuestion(@Validated @RequestBody UpdateQuestionRequestVO requestVO) {
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(requestVO, questionDTO);
        questionService.updateQuestion(questionDTO);
        return Results.success("操作成功");
    }

    /**
     * 删除题目
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/deleteQuestion")
    public Result<String> deleteQuestion(@Validated @RequestBody DeleteQuestionRequestVO requestVO) {
        questionService.removeQuestion(requestVO.getQuestionId());
        return Results.success("操作成功");
    }

    /**
     * 获取题目信息
     *
     * @param requestVO
     * @return
     */
    @PostMapping(value = "/getQuestion", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<GetQuestionResponseVO> getQuestion(@Validated @RequestBody GetQuestionRequestVO requestVO) {
        GetQuestionResponseVO responseVO = new GetQuestionResponseVO();
        QuestionDTO questionDTO = questionService.getQuestion(requestVO.getQuestionId());
        BeanUtils.copyProperties(questionDTO, responseVO);
        return Results.success(responseVO);
    }

    /**
     * 添加题目选项
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/addOption")
    public Result<String> addOption(@Validated @RequestBody AddOptionRequestVO requestVO) {
        OptionDTO optionDTO = new OptionDTO();
        BeanUtils.copyProperties(requestVO, optionDTO);
        optionService.saveOption(optionDTO);
        return Results.success("操作成功");
    }

    /**
     * 编辑题目选项
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/updateOption")
    public Result<String> updateOption(@Validated @RequestBody UpdateOptionRequestVO requestVO) {
        OptionDTO optionDTO = new OptionDTO();
        BeanUtils.copyProperties(requestVO, optionDTO);
        optionService.updateOption(optionDTO);
        return Results.success("操作成功");
    }

    /**
     * 删除题目选项
     *
     * @param requestVO
     * @return
     */
    @PostMapping("/deleteOption")
    public Result<String> deleteOption(@Validated @RequestBody DeleteOptionRequestVO requestVO) {
        optionService.removeOption(requestVO.getOptionId());
        return Results.success("操作成功");
    }

    /**
     * 查询题目选项详情
     *
     * @param requestVO
     * @return
     */
    @PostMapping(value = "/getOption", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<GetOptionResponseVO> getOption(@Validated @RequestBody GetOptionRequestVO requestVO) {
        GetOptionResponseVO responseVO = new GetOptionResponseVO();
        Option option = optionDao.getById(requestVO.getOptionId());
        BeanUtils.copyProperties(option, responseVO);
        responseVO.setOptionId(option.getId());
        return Results.success(responseVO);
    }
}
