package com.poscoict.container.config.videosystem;

import com.poscoict.container.videosystem.DigitalVideoDisc;

public class Avengers implements DigitalVideoDisc {

	private String studio = "MARVEL";
	private String title = "Avengers";
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing Movie" + studio + "'s"  + title);
	}

}