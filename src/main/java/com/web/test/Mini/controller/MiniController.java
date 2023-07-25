package com.web.test.Mini.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.web.test.Mini.service.MiniService;
import com.web.test.Mini.vo.MiniVo;
import com.web.test.Photo.vo.PhotoVo;
import com.web.test.Visit.vo.VisitVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class MiniController {

	@Autowired
	private MiniService miniService;
	
	//홈화면 보여주기
	@RequestMapping("/home/{user_no}")
	public String mini(@PathVariable("user_no")Integer user_no, Model model, HttpSession session) throws Exception {
		
		String user_id = (String) session.getAttribute("savedUserId");		
		
		miniService.updateTodayTotalByUserId(user_id);
		
		List<MiniVo> mini = miniService.miniList(user_id);
		
		
		List<PhotoVo> photo = miniService.getPhotoname(user_id);	//updated news를 위한 사진첩 이름가져오기
		
		List<VisitVo> visit = miniService.getRegistertitle(user_id);	//updated news를 위한 방명록 제목 가져오기
		
		
		int diaryToday = miniService.diaryTodayCnt(user_id);	//다이어리 오늘 쓴 갯수
		int diaryTotal = miniService.diaryTotalCnt(user_id);	//다이어로 총 갯수
		
		int visitToday = miniService.visitTodayCnt(user_id);	//방명록 오늘 쓴 갯수
		int visitTotal = miniService.visitTotalCnt(user_id);	//방명록 총 갯수
		
		int photoToday = miniService.photoTodayCnt(user_id);	//사진첩 오늘 갯수
		int photoTotal = miniService.photoTotalCnt(user_id);	//사진첩 총 갯수
		
		model.addAttribute("mini", mini);
		model.addAttribute("diaryToday", diaryToday);
		model.addAttribute("diaryTotal", diaryTotal);
		
		model.addAttribute("visitToday", visitToday);
		model.addAttribute("visitTotal", visitTotal);
		
		model.addAttribute("photoToday", photoToday);
		model.addAttribute("photoTotal", photoTotal);
		
		model.addAttribute("user_no", user_no);
		
		model.addAttribute("photo", photo);
		model.addAttribute("visit", visit);
		
		System.out.println("mini " + mini);
		System.out.println("visit " + visit);
		return "/mini/home";
	}
	
	//프로필 상태메세지 만들기
	@RequestMapping("/home/{user_no}/new")
	public String uploadProfile(@PathVariable("user_no") Integer user_no,
								@RequestParam(value = "mini_no", required = false) Integer mini_no,
								@ModelAttribute MiniVo miniVo,
	                            @RequestParam("photoFile") MultipartFile photoFile, Model model, HttpSession session) throws Exception {
		
		String user_id = (String) session.getAttribute("savedUserId");	
		
		List<MiniVo> mini = miniService.miniList(user_id);
		
	    if (!photoFile.isEmpty()) {	
	        try {
	            // 파일 저장 로직 구현
	            String fileName = photoFile.getOriginalFilename();
	            miniVo.setMini_profile(fileName);

	            // 파일저장소 구현
	            String savePath = "src/main/resources/static/profile/";
	            File directory = new File(savePath);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }

	            String filePath = directory.getAbsolutePath() + File.separator + fileName;
	            File destFile = new File(filePath);

	            // MultipartFile을 File로 변환하여 저장
	            photoFile.transferTo(destFile);

	            // 파일 이름을 UTF-8로 인코딩하여 모델에 추가
	            String encodedFileName = URLEncoder.encode(fileName, "UTF-8");
	            model.addAttribute("fileName", encodedFileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    model.addAttribute("mini", new MiniVo());
	    model.addAttribute("mini_no", miniVo.getMini_no());
	    
	    if(miniVo.getMini_profile() == null) {	    	
	    miniService.insertMini(miniVo);	    
	    }     
	    miniService.updateMini(miniVo);
	    
	    System.out.println(miniVo);
	    
	    return "redirect:/home/{user_no}";
	}
	
	//미니룸 수정하기
	@RequestMapping("/home/{user_no}/mini")
	public String uploadMini(@PathVariable("user_no") Integer user_no,
							@RequestParam(value = "mini_no", required = false) Integer mini_no,
							@ModelAttribute MiniVo miniVo,
	                        @RequestParam("photoFile") MultipartFile photoFile, Model model, HttpSession session) throws Exception {
		
		String user_id = (String) session.getAttribute("savedUserId");	
		
		List<MiniVo> mini = miniService.miniList(user_id);
		
	    if (!photoFile.isEmpty()) {
	        try {
	            // 파일 저장 로직 구현
	            String fileName = photoFile.getOriginalFilename();
	            miniVo.setMini_room(fileName);

	            // 예시로는 "static/img" 폴더에 저장하는 것으로 가정합니다.
	            String savePath = "src/main/resources/static/miniroom/";
	            File directory = new File(savePath);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }

	            String filePath = directory.getAbsolutePath() + File.separator + fileName;
	            File destFile = new File(filePath);

	            // MultipartFile을 File로 변환하여 저장
	            photoFile.transferTo(destFile);

	            // 파일 이름을 UTF-8로 인코딩하여 모델에 추가
	            String encodedFileName = URLEncoder.encode(fileName, "UTF-8");
	            model.addAttribute("fileName", encodedFileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    model.addAttribute("mini", new MiniVo());
	    model.addAttribute("mini_no", miniVo.getMini_no());
	    
	    
	    miniService.updateRoom(miniVo);
	    
	    System.out.println(miniVo);
	    
	    return "redirect:/home/{user_no}";
	}
}
