package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping: 클래스(타입) + 메소드(핸들러)
 * 
 * 
 */

@Controller
@RequestMapping("/user")  //user까지 매핑
public class UserContorller {
		
	@RequestMapping(value="/join",method = RequestMethod.GET)  //annotation에 기본 값이 있는데 그건 vluae="/join" 이렇게 된다.  value는 기본 값인데 다른 걸 붙여주려면 생략하면 안된다
	public String join() {    								//GET방식으로 메소드 호출 가능
//		return"UserController/join()";						
															/*
															 * 
															 */
		
		
		return"/WEB-INF/views/join.jsp";   //  join만 해줘ㄱ도 가능
	}
	
	/*
	 * 
	 */
	
	@RequestMapping(value="/join",method = RequestMethod.POST)  //annotation에 기본 값이 있는데 그건 vluae="/join" 이렇게 된다.  value는 기본 값인데 다른 걸 붙여주려면 생략하면 안된다
	public String join(UserVo vo) {    								//POST방식이면 이쪽으로 들어온다.
																	/*
																	 * Handler에 역할이 잇는데 능력안에서 최대한 맞춰주려고 한다. request 내가 dispathcer servlet을 만들고 내가 코드를
																	 * 짠다고 생각하면 쉽다. 
																	 * uservo에 값을 채우려고 하는데
																	 * request로 getno 값을 가져 온다.
																	 * 그리고 uservo의 필드에 맞게 값을 가져 온다.
																	 * ㄱuservo 객체를 만들기 위해 객체의 정보를 가져온게 리플렉션???
																	 * 어떤 객체를 만들때 사용한 클래스의 정보   -> 
																	 *   -> jvm에 클래스의 가 있는데 거기에 필드 정보 등이 있다. 클래스를 만들었을때라고 가정
																	 *   -> jvm에서 이정보는 heap에 들어가 있따  이 객체는 class Class 클래스의 정보를 담는 클래스
																	 *   -> 만약 내가 객체를 만들면 힙에 객체정보가 들어가는데 그 정보는 class Class가 가지고 있다.
																	 *   -> 
																	 */
//		return"UserController/join()";
		
		
		System.out.println(vo);
		
		return"redirect:/";
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) { //@RequestParam annotation은 메소드와 필드에 붙을 수 있고, 클래스와 파라미터에 붙을 수 있다.
													  	  // annotaion  n에 값이 들어가면 값이 들어간다.
		/*
		 * 만일, n이라는 이름의 파라미터가 없는 경우 
		 * 400 ㄷbad request 에러가 발생한다.
		 * 
		 * 
		 */
		System.out.println(name);
		return "UserController.update(" + name + ")";  
														/*
														 * Messageconvert에서 simpleHtml message에 한글 안
														 */
	}
	
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=true, defaultValue="") String name,
			@RequestParam(value="a", required=true, defaultValue="0") Integer age) { //@RequestParam annotation은 메소드와 필드에 붙을 수 있고, 클래스와 파라미터에 붙을 수 있다.
													  	  // annotaion  n에 값이 들어가면 값이 들어간다.
		/*
		 * 만일, n이라는 이름의 파라미터가 없는 경우 
		 * 400 ㄷbad request 에러가 발생한다.
		 * 
		 * value="n", required=false
		 * required를 false를 주면 n이 없어도 에러가 발생핟지 ㅇ낳는다.
		 * 
		 * value="n", required=true, defaultValue=""  이렇게 하면 required는 true이고 defaultValue로 기본 값을 설정 해준다.
		 * 
		 * 
		 * value="n", required=true, defaultValue="0"  int일때 안에 아무것도 없고 숫자를 주고 싶으면
		 */
		
		if(age==null) {
			age=0;
		}
		System.out.println("--------" + name + "-------");
		System.out.println("--------" + age + "-------");

//		return "UserController.update(" + name + ")";  /*
														 /* Messageconvert에서 simpleHtml message에 한글 안깨지게 해줘야 한다.
														 */
		return "UserController.update()";											
	}
	
	
	
	
	
}
