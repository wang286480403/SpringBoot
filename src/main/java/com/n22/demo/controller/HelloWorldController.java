package com.n22.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsiyong
 * @Description: HelloWorld测试
 * @date 2018/7/2717:03
 */
@RestController
public class HelloWorldController {
	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}
}
