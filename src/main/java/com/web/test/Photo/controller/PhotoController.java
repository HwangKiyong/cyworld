package com.web.test.Photo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.test.Mini.vo.MiniVo;
import com.web.test.Photo.service.PhotoService;
import com.web.test.Photo.vo.PhotoVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	@Value("${photo.temporary.path}")
    private String savePath; // properties 파일에서 설정 값을 읽어옵니다.
	
	//사진첩 조회하기
	@RequestMapping("/photo/{user_no}")
	public String photo(@PathVariable("user_no")Integer user_no, Model model, HttpSession session) throws Exception {
		
		String user_id = (String) session.getAttribute("savedUserId");	
		List<PhotoVo> photo = photoService.photoList(user_id);	
		
		List<MiniVo> mini = photoService.miniList(user_id);
		model.addAttribute("list", photo);
		
		model.addAttribute("mini", mini);
		System.out.println("photo: " + photo);
		model.addAttribute("user_no", user_no);
		return "/mini/photo";
	}
	
	//사진첩 새로만들기
	@RequestMapping("/photo/{user_no}/new")
	public String uploadPhoto(@PathVariable("user_no") Integer user_no, @ModelAttribute PhotoVo photoVo,
	                          @RequestParam("photoFile") MultipartFile photoFile, Model model) throws Exception {
	    if (!photoFile.isEmpty()) {
	        try {
	            // 파일 저장 로직 구현
	            String fileName = photoFile.getOriginalFilename();
	            photoVo.setPhoto_path(fileName);

	            // 예시로는 "static/img" 폴더에 저장하는 것으로 가정합니다.
	            String savePath = "src/main/resources/static/img/";
	            File directory = new File(savePath);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }

	            String filePath = directory.getAbsolutePath() + File.separator + fileName;
	            File destFile = new File(filePath);

	            // MultipartFile을 File로 변환하여 저장
	            photoFile.transferTo(destFile);

	            model.addAttribute("fileName", fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    model.addAttribute("photo", new PhotoVo());
	    photoService.insertPhoto(photoVo);
	    return "redirect:/photo/{user_no}";
	}	  
	
	//사진첩 수정- 사진수정은 불가 인스타그램 참고
	@PostMapping("/photo/{user_no}/edit")
	public String updatePhoto(@PathVariable("user_no") Integer user_no, @RequestParam("photo_no") Integer photo_no, @ModelAttribute PhotoVo photoVo, Model model) {
		photoVo.setPhoto_no(photo_no); 
	    photoService.updatePhoto(photoVo);
	    
	    model.addAttribute("photo", photoVo);
	    model.addAttribute("user_no", user_no);
	    return "redirect:/photo/{user_no}";
	}
	
	//사진첩 삭제
	@DeleteMapping("/photo/{user_no}/delete")
	public String deletePhoto(@PathVariable("user_no") Integer user_no, @RequestParam("photo_no") Integer photo_no) {
	    // diaryNo에 해당하는 다이어리 삭제 로직을 구현하세요
		photoService.deletePhoto(photo_no);
	    return "redirect:/photo/{user_no}";
	}
}
