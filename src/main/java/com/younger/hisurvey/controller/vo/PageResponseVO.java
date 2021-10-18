package com.younger.hisurvey.controller.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author topyfine
 */
@Data
public class PageResponseVO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long pageNo;
    private Long pageSize;
    private Long total;
    private List<T> results;
}
