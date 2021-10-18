package com.younger.hisurvey.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.younger.hisurvey.dao.entity.Option;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目选项(survey_option)数据Mapper
 *
 * @author topyfine
 * @since 2021-10-18
 * @description
 */
@Mapper
public interface OptionMapper extends BaseMapper<Option> {

}
