package com.younger.hisurvey.service.impl;

import com.younger.hisurvey.constant.Constants;
import com.younger.hisurvey.dao.OptionDao;
import com.younger.hisurvey.dao.entity.Option;
import com.younger.hisurvey.dto.OptionDTO;
import com.younger.hisurvey.service.OptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 题目选项服务接口实现
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class OptionServiceImpl implements OptionService {
    private final OptionDao optionDao;

    @Override
    public void saveOption(OptionDTO optionDTO) {
        Option option = new Option();
        BeanUtils.copyProperties(optionDTO, option);
        option.setStatus(Constants.Status.EBL);
        Date nowDate = new Date();
        option.setCreateTime(nowDate);
        option.setUpdateTime(nowDate);
        optionDao.save(option);
    }

    @Override
    public void updateOption(OptionDTO optionDTO) {
        Option record = optionDao.getById(optionDTO.getOptionId());
        if (record == null) {
            return;
        }
        Option option = new Option();
        option.setId(record.getId());
        option.setContent(optionDTO.getContent());
        option.setIsRightAnswer(optionDTO.getIsRightAnswer());
        option.setSort(optionDTO.getSort());
        optionDao.updateById(option);
    }

    @Override
    public void removeOption(Long optionId) {
        Option record = optionDao.getById(optionId);
        if (record == null) {
            return;
        }
        Option option = new Option();
        option.setId(record.getId());
        option.setStatus(Constants.Status.DEL);
        optionDao.updateById(option);
    }
}