package com.dianping.core.schema.javaModel.impl;

import com.dianping.core.schema.DB.Column;
import com.dianping.core.schema.javaModel.PO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jychai on 16/6/30.
 */
public class POImpl implements PO {

    private String packageName;
    private List<Column> columns;
    private String tableName;

    private static Map<String, String> typeTransferMap = new HashMap<String, String>() {
        {
            put("int", "Integer");
            put("tinyint", "Integer");
            put("smallint", "Integer");
            put("bigint", "Long");
            put("boolean", "Boolean");
            put("varchar", "String");
            put("text", "String");
            put("mediumText", "String");
            put("timestamp", "String");
            put("datetime", "String");
            put("decimal","Double");
            put("double", "Double");
        }
    };

    public POImpl(String packageName,String tableName,List<Column> columns) {
        this.packageName = packageName;
        this.columns = columns;
        this.tableName = tableName;
    }


    @Override
    public String constructor() {
        StringBuilder sb = new StringBuilder();
        sb.append("package ");
        sb.append(packageName);
        sb.append(".dao.po;");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("import lombok.Data;");
        sb.append("\r\n");
        sb.append("import org.apache.ibatis.type.Alias;");
        sb.append("\r\n");
        sb.append("import java.io.Serializable;");
        sb.append("\r\n");
        sb.append("\t/*");
        sb.append("\r\n");
        sb.append("\t* Created by HR Group");
        sb.append("\r\n");
        sb.append("\t*/");
        sb.append("\r\n");
        sb.append("@Alias(\"");
        sb.append(tableName);
        sb.append("PO\")");
        sb.append("\r\n");
        sb.append("@Data");
        sb.append("\r\n");
        sb.append("public class ");
        sb.append(tableName);
        sb.append("PO ");
        sb.append("implements Serializable {");
        sb.append("\r\n");
        sb.append(constructProperty());
        sb.append("}");
        return sb.toString();
    }

    private String constructProperty() {
        StringBuilder sb = new StringBuilder();
        for(Column c : columns) {
            sb.append("\t\t");
            sb.append("private ");
            sb.append(typeTransferMap.get(c.getType()));
            sb.append(" ");
            sb.append(firstReplace(c.getName()));
            sb.append(";");
            sb.append("\r\n");
        }
        return sb.toString();
    }

    //首字母大写变小写
    private String firstReplace(String str) {
        char[] chars = new char[1];
        chars[0] = str.charAt(0);
        String temp=new String(chars);
        if(chars[0]>='A'  &&  chars[0]<='Z')
        {
            return str.replaceFirst(temp, temp.toLowerCase());
        }
        return str;
    }


}
