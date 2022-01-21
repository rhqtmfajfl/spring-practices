package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping 클래스(타입) 단독 매핑
 * 
 * 
 * 
 * 
 */
@Controller
@RequestMapping("/guestbook/")  //guestbook으로 들어왔을 때 guestbook의 모든 경오
//핸들러의 이름이 다음 경로가 된다.
public class GuestbookController {
	
	
	@ResponseBody
	@RequestMapping  // 단독매핑인데 뒤에 url을 주지 않았다.
	public String list() {  // 이거 실행하려면 /guestbook/list
		
		return "GuestbookController.list()";
	}
	
	@ResponseBody
	@RequestMapping  // 단독매핑인데 뒤에 url을 주지 않았다.
	public String delete() {  // 이거 실행하려면 /guestbook/list
		
		return "GuestbookController.delete()";
	}
	
	
	
}
