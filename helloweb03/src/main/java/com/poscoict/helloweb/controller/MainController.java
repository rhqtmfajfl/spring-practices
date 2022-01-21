package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@ResponseBody
	@RequestMapping({"","/main","/main/a/b/c/d"}) //{ } 배열 초기화 할때 쓰는 기호로 여러개를 매핑할 때 사용한다.
	public String main() {
		
		return "MainController.main()";
	}
	
	
	

	
	
	
	
}
