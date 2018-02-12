package com.winter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CertrolController {

	@RequestMapping("/")
	public String index() {
		return "system/index";
	}
	
	@RequestMapping("/consume")
	public String consume() {
		return "system/consume";
	}
	
}
