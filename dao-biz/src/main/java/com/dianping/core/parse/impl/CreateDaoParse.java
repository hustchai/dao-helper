package com.dianping.core.parse.impl;

import com.dianping.core.parse.DaoParser;
import com.dianping.core.schema.DB.Table;
import com.dianping.core.schema.javaModel.Dao;
import com.dianping.core.schema.javaModel.impl.DaoImpl;
import org.springframework.stereotype.Component;

/**
 * Created by jychai on 16/6/30.
 */
@Component
public class CreateDaoParse implements DaoParser {

    private String packageName;
    private Table table;


    @Override
    public Dao parse(String packageName, Table table) {
        return new DaoImpl(packageName,table);
    }
}
