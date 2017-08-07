package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMVCController {

	@RequestMapping("/index")
	public String helloMVC() {
		return "collectionLog";
	}
}
