package com.poscoict.container.config.videosystem.mixing;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poscoict.container.config.videosystem.DVDPlayerConfig;
import com.poscoict.container.videosystem.DVDPlayer;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DVDPlayerConfig.class})  //DvdPlayerConfig 클래스 생성 필요
public class DVDPlayerMixingConfig01Test {
	
	@Autowired
	private DVDPlayer dvdPlayer;
	
	@Test
	public void testPlayerNotNull() {
		assertNotNull(dvdPlayer);
	}
	
}