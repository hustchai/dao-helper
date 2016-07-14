package com.dianping.core.parse;

import com.dianping.core.schema.DB.Table;
import com.dianping.core.schema.javaModel.PO;

/**
 * Created by jychai on 16/6/30.
 */
public interface POParser {

    PO parser(String packageName,Table table);
}
