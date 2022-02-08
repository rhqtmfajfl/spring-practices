package com.poscoict.container.videosystem;

public class DVDPlayer {
	//여기에서는 autowired를 하지 못한다.

	private DigitalVideoDisc dvd;

	public DVDPlayer() {
	}

	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}

	public DigitalVideoDisc getDvd() {
		return dvd;
	}

	public void setDvd(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}

	public void play() {
		dvd.play();
	}
}
