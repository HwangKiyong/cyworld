package com.web.test.Visit.controller;

import java.util.ArrayList;
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

import com.web.test.Mini.vo.MiniVo;
import com.web.test.Visit.service.VisitService;
import com.web.test.Visit.vo.VisitVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class VisitController {

	@Autowired
	private VisitService visitService;
	
	//방명록 조회하기
	@RequestMapping("/visit/{user_no}")
	public String visit(@PathVariable("user_no")Integer user_no, Model model, HttpSession session, VisitVo visitVo) {
		
		String user_id = (String) session.getAttribute("savedUserId");
		
		List<VisitVo> list = visitService.visitList(user_id);
		
		List<MiniVo> mini = visitService.miniList(user_id);		
		
		List<String> registerTitles = new ArrayList<>();
	    for (VisitVo visit : list) {
	        String registerTitle = visit.getRegister_title();
	        registerTitles.add(registerTitle);
	    }

	    session.setAttribute("registerTitles", registerTitles);
	    
		model.addAttribute("list", list);	
		model.addAttribute("mini", mini);
		model.addAttribute("user_no", user_no);		
		System.out.println(list);
		return "/mini/visit";
	}
	
	//방명록 글쓰기
	@PostMapping("/visit/{user_no}/new")
	public String saveVisit(@PathVariable("user_no")Integer user_no, @ModelAttribute VisitVo visitVo, Model model) {
		model.addAttribute("visit", new VisitVo());
		visitService.insertVisit(visitVo);
		return "redirect:/visit/{user_no}";
	}
	
	//방명록 수정하기
	@PostMapping("/visit/{user_no}/edit")
	public String updateVisit(@PathVariable("user_no") Integer user_no, @RequestParam("register_no") Integer register_no, @ModelAttribute VisitVo visitVo, Model model) {
		visitVo.setRegister_no(register_no); 
	    visitService.updateVisit(visitVo);
	    
	    model.addAttribute("visit", visitVo);
	    model.addAttribute("user_no", user_no);
	    return "redirect:/visit/{user_no}";
	}
	
	//방명록 삭제
	@DeleteMapping("/visit/{user_no}/delete")
	public String deleteVisit(@PathVariable("user_no") Integer user_no, @RequestParam("register_no") Integer register_no) {
	    // diaryNo에 해당하는 다이어리 삭제 로직을 구현하세요
		visitService.deleteVisit(register_no);
	    return "redirect:/visit/{user_no}";
	}
}
