package com.younger.hisurvey.service;


import com.younger.hisurvey.dto.OptionDTO;

/**
 * 题目选项服务接口
 *
 * @author topyfine
 * @description
 * @since 2021-10-18
 */
public interface OptionService {
    /**
     * 添加题目选项
     *
     * @param optionDTO
     */
    void saveOption(OptionDTO optionDTO);

    /**
     * 更新选项信息
     *
     * @param optionDTO
     */
    void updateOption(OptionDTO optionDTO);

    /**
     * 删除选项
     *
     * @param optionId
     */
    void removeOption(Long optionId);
}
