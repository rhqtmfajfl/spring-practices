package com.poscoict.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscoict.fileupload.service.FileUploadService;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping({"","/form"})
	public String form() {
		return "form";
	}
	
	
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam(value="email", required=true)String email, 
			@RequestParam(value="upload-file") MultipartFile multipartfile,
			Model model) {  //fileupload가 없으면 에러 발생 upload-file
	
		
		System.out.println("email : " + email);
		
		String url = fileUploadService.resotre(multipartfile);  //임시로 업로드된 파일이 저장되어있다.
		
		model.addAttribute("url", url);
		
		return "result";
	}
}
