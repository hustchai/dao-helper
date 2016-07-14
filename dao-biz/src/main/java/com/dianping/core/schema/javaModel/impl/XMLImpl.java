package com.dianping.core.schema.javaModel.impl;

import com.dianping.core.schema.DB.Column;
import com.dianping.core.schema.DB.Table;
import com.dianping.core.schema.javaModel.XML;

/**
 * Created by jychai on 16/6/30.
 */
public class XMLImpl implements XML {

    private String packageName;
    private Table table;

    public XMLImpl(String packageName,Table table) {
        this.packageName = packageName;
        this.table = table;
    }

    @Override
    public String constructor() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        sb.append("\r\n");
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >");
        sb.append("\r\n");
        sb.append("<mapper namespace=\"");
        sb.append(packageName);
        sb.append(".dao.");
        sb.append(table.getName());
        sb.append("Dao\">");
        sb.append("\r\n");
        sb.append("<sql id=\"Base_Column_List\">");
        sb.append("\r\n");
        sb.append(createSQLBase());
        sb.append("\r\n");
        sb.append("</sql>\r\n");

        sb.append("<select id=\"selectByPrimaryKey\" resultType=\"");
        sb.append(table.getName());
        sb.append("PO\" ");
        sb.append("parameterType=\"java.lang.Integer\">");
        sb.append("\r\n");
        sb.append("select");
        sb.append("\r\n");
        sb.append("<include refid=\"Base_Column_List\"/>");
        sb.append("\r\n");
        sb.append("from ");
        sb.append(table.getName());
        sb.append("\r\n");
        sb.append("where Id = #{id,jdbcType=INTEGER}");
        sb.append("\r\n");
        sb.append("</select>");
        sb.append("\r\n");


        sb.append("<delete id=\"deleteByPrimaryKey\" parameterType=\"java.lang.Integer\">");
        sb.append("\r\n");
        sb.append("delete from ");
        sb.append(table.getName());
        sb.append("\r\n");
        sb.append("where Id = #{id,jdbcType=INTEGER}");
        sb.append("\r\n");
        sb.append("</delete>");
        sb.append("\r\n");

        sb.append("<insert id=\"insert\" parameterType=\"");
        sb.append(table.getName());
        sb.append("PO");
        sb.append("\" useGeneratedKeys=\"true\" keyProperty=\"po.id\">");
        sb.append("\r\n");
        sb.append("insert into ");
        sb.append(table.getName());
        sb.append(" (");
        sb.append(createSQLBase());
        sb.append(")");
        sb.append("\r\n");
        sb.append("values (");
        sb.append(createValues());
        sb.append(")");
        sb.append("\r\n");
        sb.append("</insert>");
        sb.append("\r\n");

        sb.append("<update id=\"updateByPrimaryKey\" parameterType=\"");
        sb.append(table.getName());
        sb.append("PO\">");
        sb.append("\r\n");
        sb.append("update ");
        sb.append(table.getName());
        sb.append("\r\n");
        sb.append("set");
        sb.append("\r\n");
        sb.append(updateSQL());
        sb.append("\r\n");
        sb.append("where Id = #{po.id,jdbcType=INTEGER}");
        sb.append("\r\n");
        sb.append("</update>");
        sb.append("\r\n");

        sb.append("</mapper>");


        return sb.toString();
    }

    private String updateSQL() {
        StringBuilder sb = new StringBuilder();
        for(Column c : table.getColumns()) {
            sb.append(c.getName());
            sb.append(" ");
            sb.append("= #{po.");
            sb.append(firstReplace(c.getName()));
            sb.append("},");
        }
        String str = sb.toString();
        return str.substring(0,str.length()-1);
    }

    private String createSQLBase() {
        StringBuilder sb = new StringBuilder();
        for(Column c :table.getColumns()) {
            sb.append(c.getName());
            sb.append(",");
        }
        String str = sb.toString();
        return str.substring(0,str.length()-1);
    }

    private String createValues() {
        StringBuilder sb = new StringBuilder();
        for(Column c : table.getColumns()) {
            sb.append("#{po.");
            sb.append(firstReplace(c.getName()));
            sb.append("},");
        }
        String str = sb.toString();
        return str.substring(0,str.length()-1);
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
