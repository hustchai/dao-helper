package com.dianping.core.schema.DB;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by jychai on 16/6/29.
 */
@AllArgsConstructor
@Data
public class Column {
    private String name;

    private String type;

    private boolean isPrimaryKey;
    private boolean isAuoIncrement;


    private String comment;
}
