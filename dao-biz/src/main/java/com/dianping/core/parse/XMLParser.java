package com.dianping.core.parse;

import com.dianping.core.schema.DB.Table;
import com.dianping.core.schema.javaModel.XML;

/**
 * Created by jychai on 16/6/30.
 */
public interface XMLParser {
    XML parse(String packageName, Table table);
}
