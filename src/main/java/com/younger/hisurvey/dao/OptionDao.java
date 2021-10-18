package com.younger.hisurvey.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.younger.hisurvey.dao.entity.Option;
import com.younger.hisurvey.dao.mapper.OptionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * 题目选项(survey_option)数据DAO
 *
 * @author topyfine
 * @since 2021-10-18
 * @description 
 */
@Slf4j
@Repository
public class OptionDao extends ServiceImpl<OptionMapper, Option> {

}