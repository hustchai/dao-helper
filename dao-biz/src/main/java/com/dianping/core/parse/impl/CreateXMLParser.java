package com.dianping.core.parse.impl;

import com.dianping.core.parse.XMLParser;
import com.dianping.core.schema.DB.Table;
import com.dianping.core.schema.javaModel.XML;
import com.dianping.core.schema.javaModel.impl.XMLImpl;
import org.springframework.stereotype.Component;

/**
 * Created by jychai on 16/6/30.
 */
@Component
public class CreateXMLParser implements XMLParser {

    @Override
    public XML parse(String packageName, Table table) {
        return new XMLImpl(packageName,table);
    }
}
