package com.dianping.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by jychai on 16/6/30.
 */
@Data
@AllArgsConstructor
public class ReturnDto {
    private String PO;
    private String dao;
    private String xml;
}
