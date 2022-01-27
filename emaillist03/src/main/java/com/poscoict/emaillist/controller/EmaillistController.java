package com.poscoict.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poscoict.emaillist.repository.EmaillistRepository;
import com.poscoict.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	@Autowired  //annotatin으로 자동으로 생성
	private EmaillistRepository emaillistRepository; //new 객체를 따로 선언을 안하고 그냥 여기서 @Autowired를 사용해서 편하게 간단
	
	
//	@ResponseBody  //AJAX 사용전에는 굳이 사용안해도 됨
	@RequestMapping("")   // emaillist03 하면 들어가게끔 해준다.  
	public String index(Model model) {
		
//		System.out.println(emaillistRepository);
		List<EmaillistVo> list = new EmaillistRepository().findAll();
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/index.jsp";    //"emaillist";
	}
	
	
	
	@RequestMapping("/form")
	public String form() {
		
		
		return "/WEB-INF/views/form.jsp";
		
		
	}
	
	
	@RequestMapping(value = "/add" , method=RequestMethod.POST)  //insert 가능하게 됨
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		
		System.out.println(vo);
		return "redirect:/";
		
	}
}