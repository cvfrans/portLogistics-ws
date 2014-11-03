package com.portlogistics.controller;


import com.portlogistics.bean.OpeSlp;
import com.portlogistics.service.itz.OpeBookingService;
import com.portlogistics.service.itz.OpeSlpService;
import com.portlogistics.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class GeneralController {


    @Autowired
    private OpeSlpService opeSlpService;

    @Autowired
    private OpeBookingService opeBookingService;

	@RequestMapping("/person")
	public OpeSlp getPersonDetail(@RequestParam(value = "id",required = false, defaultValue = "0") Integer id) {

        List<OpeSlp> lstOpenSlp = opeSlpService.listaOpeSlp(id);

		return lstOpenSlp.get(0);

	}
    @RequestMapping("/noticiasSlp")
    public List<Map<String,Object>> mostrarNoticiasSlp(
            @RequestParam(value = "valor",required = false, defaultValue = "") String valor,
            @RequestParam(value = "indicador",required = false, defaultValue = "") String indicador)
    {


        List<Map<String,Object>> lstBookingDuaMap = opeBookingService.listarBookingDua(valor, indicador);

        return lstBookingDuaMap;
        /*
        List<Map<String,Object>> lstBookingDuaMap = new ArrayList<Map<String, Object>>();
        lstBookingDuaMap.add(param);
        return lstBookingDuaMap;
        */

    }
}