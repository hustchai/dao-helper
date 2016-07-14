package com.dianping.core.schema.DB;

import lombok.Data;

import java.util.List;

/**
 * Created by jychai on 16/6/29.
 */
@Data
public class Table {

    private String name;

    private List<Column> columns;

    private String comment;

    public String getAutoIncrementKey() {
        String autoIncrementKey = null;
        for (Column column: columns) {
            if (column.isAuoIncrement()) {
                autoIncrementKey = column.getName();
                break;
            }
        }
        return autoIncrementKey;
    }
}
