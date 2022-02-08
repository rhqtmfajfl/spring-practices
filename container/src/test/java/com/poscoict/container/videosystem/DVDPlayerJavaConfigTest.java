package com.poscoict.container.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poscoict.container.config.videosystem.DVDPlayerConfig;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DVDPlayerConfig.class})  //DvdPlayerConfig 클래스 생성 필요
public class DVDPlayerJavaConfigTest {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private DigitalVideoDisc dvd;
	
	@Qualifier("dvdPlayer04")
	@Autowired
	private DVDPlayer dvdPlayer;
	
	@Test
	public void testDVDNotNull() {
		assertNotNull(dvd); // dvd 변수 정의 필요	
	}
	
	
	@Test
	public void testDVDPlyaerNotNull() {
		assertNotNull(dvdPlayer);
		
	}
	
	
	@Test
	public void testPlay() {
		dvdPlayer.play();
		assertEquals("Playing Movie MARVEL's Avengers", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));// 화면에 나오게끔해준다. 글을 출력되게 하려면
		//Avengers에 나타내야 한다.
	}
	
}
