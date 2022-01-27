package com.poscoict.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.poscoict.guestbook.repository.guestbookRepository;
import com.poscoict.guestbook.vo.guestbookVo;

@Controller
public class guestbookController {
	
	
//	@ResponseBody
//	@RequestMapping("")
//	public String index() {
//		
//		return "guestbook";
//	}

	@Autowired  //annotatin으로 자동으로 생성
	private guestbookRepository guestbookRepository; //new 객체를 따로 선언을 안하고 그냥 여기서 @Autowired를 사용해서 편하게 간단
	
	
//	@ResponseBody  //AJAX 사용전에는 굳이 사용안해도 됨
	@RequestMapping("")   // emaillist03 하면 들어가게끔 해준다.  
	public String index(Model model) {
		
//		System.out.println(emaillistRepository);
		List<guestbookVo> list = new guestbookRepository().findAll();
		
		model.addAttribute("list", list);  //list형식으로 객체 만듬
		
		System.out.println("testsetsetasetaet");
		return "/WEB-INF/views/index.jsp";    //"emaillist";
	}
	
	
	
	@RequestMapping("/index")  // guestbook에 등록한 리스트명
	public String form() {
		
		
		return "/WEB-INF/views/index.jsp";
		
		
	}
	
	
	@RequestMapping(value = "/add" , method=RequestMethod.POST)  //insert 가능하게 됨
	public String add(guestbookVo vo) {
		guestbookRepository.insert(vo);
		
		System.out.println(vo);
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/deleteform" , method=RequestMethod.GET)  //delete 가능하게 됨
	public ModelAndView send(int no) {
//		guestbookRepository.delete(vo);
		ModelAndView mav2 = new ModelAndView();
		mav2.addObject("no", no);
//		System.out.println(vo);
		mav2.setViewName("/WEB-INF/views/deleteform.jsp");
		return mav2;
		
	}
	
	@RequestMapping(value = "/delete" , method=RequestMethod.POST)  //delete 가능하게 됨
	public String delete(guestbookVo vo) {
		guestbookRepository.delete(vo);
		
//		System.out.println(vo);
		return "redirect:/";
		
	}
}
