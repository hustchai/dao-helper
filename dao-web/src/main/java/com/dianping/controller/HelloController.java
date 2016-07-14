package com.dianping.controller;

import com.dianping.Dto.CreateSQLDto;
import com.dianping.Dto.ReturnDto;
import com.dianping.core.manager.CreateTableManager;
import com.dianping.core.schema.DB.Table;
import com.dianping.core.schema.javaModel.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jychai on 16/6/28.
 */

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
   private CreateTableManager createTableManager;



    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView create(CreateSQLDto crateSQLDto) {

        String packName = crateSQLDto.getPackageName();
        Table table = createTableManager.getTable(crateSQLDto.getSql());
        String PO = createTableManager.getPO(packName,table);
        String Dao = createTableManager.getDao(packName,table);
        String Xml = createTableManager.getXML(packName,table);
        System.out.println(PO);
        System.out.println(Dao);
        System.out.println(Xml);

        ModelAndView mv = new ModelAndView();
        ReturnDto returnDto = new ReturnDto(PO,Dao,Xml);
        mv.addObject("returnDto",returnDto);
        mv.setViewName("/hello");
        return mv;
    }

}
