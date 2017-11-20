package com.handwriting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/")
	String home(){
		return "hello, world!";
	}
}
