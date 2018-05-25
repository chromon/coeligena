package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * index controller
 *
 * Created by Ellery on 2017/8/10.
 */

@Controller
public class IndexController {

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index() {



		return "../../index";
	}
}
