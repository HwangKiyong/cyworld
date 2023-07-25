package com.web.test.Diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.test.Diary.service.DiaryService;
import com.web.test.Diary.vo.DiaryVo;
import com.web.test.Mini.vo.MiniVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class DiaryController {

	@Autowired
	private DiaryService diaryService;
	
	//다이어리 보여주는 화면
	@RequestMapping("/diary/{user_no}")		
	public String diary(@PathVariable("user_no")Integer user_no, Model model, HttpSession session) throws Exception {
		
		String user_id = (String) session.getAttribute("savedUserId");
		
		List<DiaryVo> list = diaryService.diaryList(user_id);
		
		List<MiniVo> mini = diaryService.miniList(user_id);	
		
		//다이어리 list와 miniVo에 today total 담아서 홈화면과 동일하게 유지시키기
		model.addAttribute("list", list);
		System.out.println("list " + list);
		model.addAttribute("mini", mini);
		model.addAttribute("user_no", user_no);
		return "/mini/diary";
	}
	
	//다이어리 추가
	@PostMapping("/diary/{user_no}/new")
	public String saveDiary(@PathVariable("user_no")Integer user_no, @ModelAttribute DiaryVo diaryVo, Model model) {
		model.addAttribute("diary", new DiaryVo());
		diaryService.insertDiary(diaryVo);
		return "redirect:/diary/{user_no}";
	}
		
	//다이어리 수정
	@PostMapping("/diary/{user_no}/edit")
	public String updateDiary(@PathVariable("user_no") Integer user_no, @RequestParam("diary_no") Integer diary_no, @ModelAttribute DiaryVo diaryVo, Model model) {
		diaryVo.setDiary_no(diary_no); 
	    diaryService.updateDiary(diaryVo);
	    
	    model.addAttribute("diary", diaryVo);
	    model.addAttribute("user_no", user_no);
	    return "redirect:/diary/{user_no}";
	}
	
	//다이어리 삭제
	@DeleteMapping("/diary/{user_no}/delete")
	public String deleteDiary(@PathVariable("user_no") Integer user_no, @RequestParam("diary_no") Integer diary_no) {
	    // diaryNo에 해당하는 다이어리 삭제 로직을 구현하세요
	    diaryService.deleteDiary(diary_no);
	    return "redirect:/diary/{user_no}";
	}
}
