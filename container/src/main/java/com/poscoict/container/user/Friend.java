package com.poscoict.container.user;

public class Friend {

	private String name;
	
	//값을 세팅하면 applicationContext.xml에서 property를 사용하고 di라고 하기는 한다.
	public Friend(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + "]";
	}
	
	
}
