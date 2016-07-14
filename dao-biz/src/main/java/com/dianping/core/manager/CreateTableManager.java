package com.dianping.core.manager;

import com.dianping.core.parse.impl.CreateDaoParse;
import com.dianping.core.parse.impl.CreatePOParser;
import com.dianping.core.parse.impl.CreateTableParse;
import com.dianping.core.parse.impl.CreateXMLParser;
import com.dianping.core.schema.DB.Table;
import com.dianping.core.schema.javaModel.Dao;
import com.dianping.core.schema.javaModel.PO;
import com.dianping.core.schema.javaModel.XML;
import com.dianping.core.schema.javaModel.impl.DaoImpl;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jychai on 16/6/29.
 */
@Component
public class CreateTableManager {

    @Autowired
    private CreateTableParse createTableParse;
    @Autowired
    private CreatePOParser createPOParser;
    @Autowired
    private CreateDaoParse createDaoParse;
    @Autowired
    private CreateXMLParser createXMLParser;


    public Table getTable(String schema) {
        return createTableParse.parse(schema);
    }

    public String getPO(String packName,Table table) {
       PO PO = createPOParser.parser(packName, table);
        return PO.constructor();
    }

    public String getDao(String packageName,Table table) {
        Dao dao = createDaoParse.parse(packageName, table);
        return dao.constructor();
    }

    public String getXML(String packageName,Table table) {
        XML xml = createXMLParser.parse(packageName,table);
        return xml.constructor();
    }
}
