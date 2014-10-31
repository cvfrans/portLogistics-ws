package com.portlogistics.controller;


import com.portlogistics.bean.OpeSlp;
import com.portlogistics.service.itz.OpeSlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class GeneralController {


    @Autowired
    private OpeSlpService opeSlpService;

	@RequestMapping("/person")
	public OpeSlp getPersonDetail(@RequestParam(value = "id",required = false, defaultValue = "0") Integer id) {

        List<OpeSlp> lstOpenSlp = opeSlpService.listaOpeSlp(id);

		return lstOpenSlp.get(0);

	}
}