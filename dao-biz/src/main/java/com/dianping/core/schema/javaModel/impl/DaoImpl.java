package com.dianping.core.schema.javaModel.impl;

import com.dianping.core.schema.DB.Table;
import com.dianping.core.schema.javaModel.Dao;
import org.springframework.stereotype.Component;

/**
 * Created by jychai on 16/6/30.
 */
public class DaoImpl implements Dao {

    private String packageName;
    private Table table;

    public DaoImpl(String packageName,Table table) {
        this.packageName = packageName;
        this.table = table;
    }


    @Override
    public String constructor() {
        StringBuilder sb = new StringBuilder();
        sb.append("package ");
        sb.append(packageName);
        sb.append(".dao;");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("import ");
        sb.append(packageName);
        sb.append(".dao.po.");
        sb.append(table.getName());
        sb.append("PO;");
        sb.append("\r\n");
        sb.append("import org.apache.ibatis.annotations.Param;");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\t/*");
        sb.append("\r\n");
        sb.append("\t* Created by HR Group");
        sb.append("\r\n");
        sb.append("\t*/");
        sb.append("\r\n");
        sb.append("public interface ");
        sb.append(table.getName());
        sb.append("Dao {");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\t\t");
        sb.append("int deleteByPrimaryKey(@Param(\"id\") Integer id);");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\t\t");
        sb.append("int insert(@Param(\"po\") ");
        sb.append(table.getName());
        sb.append("PO ");
        sb.append(firstReplace(table.getName()));
        sb.append("po);");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\t\t");
        sb.append(table.getName());
        sb.append("PO ");
        sb.append("selectByPrimaryKey(@Param(\"id\") Integer id);");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("\t\t");
        sb.append("int updateByPrimaryKey(@Param(\"po\") ");
        sb.append(table.getName());
        sb.append("PO ");
        sb.append("record);");
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("}");

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
