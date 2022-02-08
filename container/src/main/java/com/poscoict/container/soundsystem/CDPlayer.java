package com.poscoict.container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	
	@Autowired  //의존성을 해결하기 위해 container에 요청할 때 Autowired를 사용한다. 그러면 
	private CompactDisc cd;  // CompactDisc에 대한 기능을 찾게 된다. 수정과 확장성에 대해서 
	// 확장성이 좋아지게 하기 위해서 CompactDisc를 인터페이스로 사용

	public void play() {
		cd.play();
	}
}