package com.poscoict.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.poscoict.container.user.User;
import com.poscoict.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {
//		testBeanFactory01();  // beanfactory구현
		
//		testBeanFactory02();
		
		
		//XML Auto Configuration(Annotation Scanning)
//		testApllicationContext01();
		
		
		//XML Explicit Configuration(Explicit Configuration)
		testApplicationContext02();
		
	}
	
	//XML Auto Configuration(Annotation Scanning)
	private static void testApllicationContext01() {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscoict/container/config/user/applicationContext01.xml");
		//ClassPathXmlApplicationContext  내부에서 class 파일로 만든다.
		
		User1 user1 = ac.getBean(User1.class);
		
		System.out.println(user1.getName());
		
		
		//bean id가 자동으로 설정됨
		user1 = (User1)ac.getBean("user1");
		System.out.println(user1.getName());

	}
	
	
	//XML Explicit Configuration(Explicit Configuration)
		private static void testApplicationContext02() {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscoict/container/config/user/applicationContext02.xml");
			//resource에 xml property를 만든다.
			
//			User1 user1 = ac.getBean(User1.class);
//			
//			System.out.println(user1.getName());
//			
//			
//			//Bean id 가 자동으로 설정되지 않음
//			//명시적으로 설정 해야한다.
//			user1 = ac.getBean(User1.class);
//			
//			System.out.println(user1.getName());
//			
			
			User user = null;
			
			//id로 빈 가져오기
			user =(User)ac.getBean("user");
			System.out.println(user);
			
			//name으로 가져오기
			user=(User)ac.getBean("usr");  //내부에서 해당되는 usr이 없으면 null을 리턴해주지 않는다. 그래서 이이부분을 exception이 안일어나게 하려면
			System.out.println(user);  //처음 이부분을 실행하면 에러 발생
			
			
			//Type으로 빈 가져오기 두개의 같은 타입이 있는 경우 처음에 에러 발생
			// 같은 타입의 bean이 두 개 이상 있으면, type으로 가져오기는 실패 한다. 그런경우에는
			//user = ac.getBean(User.class);  //여기선 id가 user인것을 가져오게 된다.
			
			//1. id, type
			//2. name, type
			
			user = ac.getBean("user2", User.class);   //bean이 user2를 자겨오는 것이다.
			
			System.out.println(user);
			
			
			//2개 파라미터 생성자로 생성된 빈 가져오기1
			user=(User)ac.getBean("user3");  
			System.out.println(user); 
			
			//2개 파라미터 생성자로 생성된 빈 가져오기2
			user=(User)ac.getBean("user4");  
			System.out.println(user); 
			
			//setter를 사용한 빈 가져오기1
			user=(User)ac.getBean("user5");  
			System.out.println(user); 
			
			//setter를 사용한 빈 가져오기2(DI)
			user=(User)ac.getBean("user6");  
			System.out.println(user); 
			
			//setter를 사용한 빈 가져오기3(List Property)
			user=(User)ac.getBean("user7");  
			System.out.println(user); 
			
		}

	
	//XML Auto Configuration(Annotation Scanning)
	private static void testBeanFactory01() {
		
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscoict/container/config/user/applicationContext01.xml"));
		//resource에 xml property를 만든다.
		
		User1 user1 = bf.getBean(User1.class);
		
		System.out.println(user1.getName());
		
		
		//bean id가 자동으로 설정됨
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());

	}
	
	
	//XML Explicit Configuration(Explicit Configuration)
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscoict/container/config/user/applicationContext02.xml"));
		//resource에 xml property를 만든다.
		
		User1 user1 = bf.getBean(User1.class);
		
		System.out.println(user1.getName());
		
		
		//Bean id 가 자동으로 설정되지 않음
		//명시적으로 설정 해야한다.
		user1 = bf.getBean(User1.class);
		
		System.out.println(user1.getName());
		
	}

}
