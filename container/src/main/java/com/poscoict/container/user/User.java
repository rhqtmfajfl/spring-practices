package com.poscoict.container.user;

import java.util.List;

public class User {
	private Long no =0L;
	
	private String name = "홍길동";
	private Friend friend = null;  //이부분을 의존성이라고 한다.
	private List<String> friends;
	
	//이렇게 기본생성자를 명시를안하더라도 자동으로 생성자를 넣어준다.
	//하지만 생성자가 있으면 기본 생성자를 안만든다.
	//그러므로 기본생성자를 overloading 해준다.
	public User() {
		
	}

	//파라미터 1개인 생성자 test
//	
	public User(String name) {
		this.name = name;
	}

	public User(Long no, String name) {
		this.no = no;
		this.name = name;
	}
	
//	public User(Long no, String name, Friend friend) {
//		this.no = no;
//		this.name = name;
//		this.friend = friend;
//	}
	
	public void setNo(Long no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public void setFriend(Friend friend) {  //이게 있어야 주입이 된다.
		this.friend = friend;
	}
	

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + "]";
	}

//	@Override
//	public String toString() {
//		return "User [name=" + name + "]";
//	}
//	
	
	
}
