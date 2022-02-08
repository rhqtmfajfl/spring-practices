package com.poscoict.container.videosystem;

public class DVDPlayer {
	//여기에서는 autowired를 하지 못한다.
	
	private DigitalVideoDisc dvd;
	
	
	public void play() {
		dvd.play();
		
	}

}
