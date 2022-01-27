package com.poscoict.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	private static String SAVE_PATH = "/upload-images";
	//upload-images 경로에 드라이브를 쓸 필요는 없다. 윈도우 용이면 드라이버를 결정해 줘야한다.
	//여기서는 내가 실행하고 있는 것은 위도우 이므로 나는 c 에 디렉토리를 만드는데 경로는 내가 사용하고 있는 c 드라이브에 upload images를 사용한다.
	// 자바 디렉토리 존재여부 확인하기 하면 된다.  자바 디렉토리 경로 생성하는 방법으로 찾아 보낟.
	// 디렉토리는 외부에다가 만들어야 한다. 이클립스내에 디렉토리를 만들면 안되낟.
	// 물리적으로 저장하는 곳은 
	
	
	
	public String resotre(MultipartFile multipartfile) {
		//url을 만들어 내야 한다.
		String url = null;
		
		
		try {
		
			if(multipartfile.isEmpty()) {
				return url;
			}
			
			
			String originFileName = multipartfile.getOriginalFilename();
			long fileSize = multipartfile.getSize();
			
			System.out.println("#########" + originFileName);
			System.out.println("#########" + fileSize);
			
			
			byte[] data = multipartfile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "");
			//savepath 에서 디렉토리가 존재하지 않으면 만들수 있도록 한다.
			//내가 경로를 설정 해주면 좋다.
			
		} catch(IOException ex) {
			throw new RuntimeException("file upload error : " + ex);
		}
		
		
		return url;
	}
	
	
	
}
