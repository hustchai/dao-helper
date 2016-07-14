package com.dianping.core.parse.impl;

import com.dianping.core.parse.POParser;
import com.dianping.core.schema.DB.Column;
import com.dianping.core.schema.DB.Table;
import com.dianping.core.schema.javaModel.PO;
import com.dianping.core.schema.javaModel.impl.POImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jychai on 16/6/30.
 */
@Component
public class CreatePOParser implements POParser {


    @Override
    public PO parser(String packageName,Table table) {
         String tableName = table.getName();
         List<Column> columns = table.getColumns();
        return new POImpl(packageName,tableName,columns);

    }
}
