package com.poscoict.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poscoict.container.videosystem.DVDPlayer;
import com.poscoict.container.videosystem.DigitalVideoDisc;

@Configuration   // configuration은 무조건 이거 없어도 만들어 준다.
public class DvdPlayerConfig {
	
	
	@Bean
	public DigitalVideoDisc avengers() {
		
		return new Avengers();
	}
	
	@Bean
	public DVDPlayer dvdPlayer() {
		
		return new DVDPlayer();
	}
	
	
}
