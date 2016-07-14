package com.dianping.core.parse;

import com.dianping.core.schema.DB.Table;
import org.springframework.stereotype.Component;

/**
 * Created by jychai on 16/6/29.
 */
public interface DBParser {

    public Table parse(String schema);
}