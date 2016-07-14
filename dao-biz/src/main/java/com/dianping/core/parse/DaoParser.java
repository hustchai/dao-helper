package com.dianping.core.parse;

import com.dianping.core.schema.DB.Table;
import com.dianping.core.schema.javaModel.Dao;

/**
 * Created by jychai on 16/6/30.
 */
public interface DaoParser {

    Dao parse(String packageName,Table table);
}
