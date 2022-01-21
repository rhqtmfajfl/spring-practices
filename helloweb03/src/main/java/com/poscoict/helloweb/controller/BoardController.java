package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/*
 * @RequestMapping: 메소드 단독 매핑
 * @
 * 
 */
@Controller
public class BoardController {
	
	
	@ResponseBody //response로 화면에 바로
	@RequestMapping("/board/write")
	public String write() {
		
		return "BoardController.write()";
	}
	
	
	@ResponseBody //response로 화면에 바로
	@RequestMapping("/board/view/{no}")   //no의 갓을 boardNo에 세팅
	public String view(@PathVariable("no") Long boardNo) { //
		
		return "BoardController.view( " + boardNo + ")";
	}
	
	
	
}
