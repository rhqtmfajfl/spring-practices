package com.poscoict.container.config.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //설정파일이라는 의미
@ComponentScan(basePackages=("com.poscoict.container.soundsystem"))
public class CDPlayerConfig {
	public CDPlayerConfig() {
		
	}
	//pom.xml 수정
}
