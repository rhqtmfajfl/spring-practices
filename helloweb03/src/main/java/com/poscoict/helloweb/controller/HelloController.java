package com.poscoict.helloweb.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

   @RequestMapping("/hello")
   public String hello() {
      return "/WEB-INF/views/hello.jsp";

   }
   
   @RequestMapping("/hello2")
   public String hello2(String name) {
	  System.out.println("name:" + name);
      return "/WEB-INF/views/hello2.jsp";
   }
   
   
   //jsp로 데이터를 전달 할때 어떻게 해야 하는가?
   @RequestMapping("/hello3")
   public ModelAndView hello3(String id) {
	   ModelAndView mav = new ModelAndView();
	   mav.addObject("id",id); //id라는 이름으로 id 넣기
	   mav.setViewName("/WEB-INF/views/hello3.jsp"); //이부분에서 포워딩해서 넘겨준다는의미
	   
      return mav;
   }
   
   
   @RequestMapping("/hello4")  // 이거 추천 
   public String hello4(String id,Model model) {  //모델 던질 게 있다 
	   model.addAttribute("id", id);
      return "/WEB-INF/views/hello4.jsp";
   }
   
   
   //redirect
   @RequestMapping("/hello5")
   public String hello5() {

      return "redirect:/hello";   //redirect  /hello 위에서 매핑명을 hello만 표현 하면 된다.

   }
   
   
   @ResponseBody //api
   @RequestMapping("/hello6")
   public String hello6() {

      return "<h1>Hello World5</h1>";   //브라우저로 바로가는 스트링이 된다.

   }
   

//   @ResponseBody //api
//   @RequestMapping("/hello6")
//   public String hello6(BoardVo vo) {  하면 BoardVo와 같은 타입의 vo 만들어 진다.
//
//      return "<h1>Hello World5</h1>";   //브라우저로 바로가는 스트링이 된다.
//
//   }
   
   
   
   /* 절대 비추(기술 침투가 되는 코드를 볼수 있기때문에 톰캣에서만 사용한다.) */
   @RequestMapping("/hello7")
   public void hello7(HttpServletRequest req,
			  HttpServletResponse resp,
			  HttpSession session,
			  Writer out) throws IOException {  //void 응답을 않겠다.    
	  //hello7ㅇ	   
	   String id = req.getParameter("id");
	   out.write("<h1>Hello " + id +" World7</h1>");
   }
   
   
}