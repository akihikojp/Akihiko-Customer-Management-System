package jp.co.rakus.Akihiko_Customer_Management_System.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testtest")
public class TestController {

	@RequestMapping("/testtest")
	public String testtest(){
		
		return "test";
	}
}
