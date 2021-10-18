package com.younger.hisurvey.controller.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author topyfine
 */
@Data
public class PageRequestVO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @Min(1)
    private Integer pageNo;
    @NotNull
    @Min(0)
    private Integer pageSize;
    /**
     * 查询条件
     */
    private T query;
}
