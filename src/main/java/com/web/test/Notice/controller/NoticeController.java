package com.web.test.Notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.test.Notice.service.NoticeService;
import com.web.test.Notice.vo.Criteria;
import com.web.test.Notice.vo.NoticeVo;
import com.web.test.Notice.vo.Paging;


@Controller
public class NoticeController {
	
	 @Autowired
	    private NoticeService noticeService;		
	 
	 //게시글 조회
	 @RequestMapping("/notice")
	 public String NoticeList(Long notice_no, Criteria cri, Model model) throws Exception {
		 
		 //전체 글 개수 조회
		 int noticeListCnt = noticeService.noticeListCnt();
		 //페이징 객체
		 Paging paging = new Paging();
		 paging.setCri(cri);
		 paging.setTotalCount(noticeListCnt);
		 
		 List<NoticeVo> list = noticeService.noticeList(cri);
		 
		 model.addAttribute("list", list);
		 model.addAttribute("paging", paging);
		 		 
		 System.out.println(cri);
		 System.out.println(list);
		 
		 return "notice/list";
	 }
	 
	 //write.jsp 들어가기위한 메소드	 
	 @RequestMapping("/write")
	 public String write() {
		 return "notice/write";
	 }
	 
	 //조회수 증가
	 @RequestMapping("/notice/increaseViewCount")
	 public String increaseViewCount(@RequestParam Long notice_no) {
		 noticeService.updateView(notice_no);
		 return "redirect:/notice/list";
	 }
	 
	//게시글 상세 조회
	 @GetMapping("/notice/{notice_no}")
	 public String getNotice(@PathVariable("notice_no") Long notice_no, Model model) {
	     NoticeVo notice = noticeService.selectNotice(notice_no);
	     model.addAttribute("notice", notice);	       
	     System.out.println(notice);
	     return "notice/detail";
	 }
	    
	 //게시글 작성
	 @PostMapping("/notice/new")
	 public String newNoticeForm(@ModelAttribute NoticeVo noticeVo, Model model) {
		 model.addAttribute("notice", new NoticeVo());
		 noticeService.insertNotice(noticeVo);
		 return "redirect:/notice";
	 }
	 
	 //게시글 수정
	 @RequestMapping("/notice/{notice_no}/edit")
	 public String modifyNotice(@PathVariable("notice_no") Long notice_no, Model model) {
		 NoticeVo notice = noticeService.selectNotice(notice_no);
		 model.addAttribute("notice", notice);
		 return "notice/modifyNotice";
	 }
	 
	 //게시글 수정 처리
	 @PostMapping("/notice/{notice_no}/edit")
	 public String editNotice(@PathVariable Long notice_no, @ModelAttribute NoticeVo noticeVo) {
		 noticeVo.setNotice_no(notice_no);
		 noticeService.updateNotice(noticeVo);
		 return "redirect:/notice/" + notice_no;
	 }	 
	 
	 //게시글 삭제 처리
	 @RequestMapping("/notice/{notice_no}/delete")
	 public String deleteNotice(@PathVariable("notice_no") Long notice_no) {
		 noticeService.deleteNotice(notice_no);
		 return "redirect:/notice";
	 }
	 
	 //검색하기
	 @GetMapping("/search")
	 public String searchNotice(@RequestParam(required = false) String searchCondition,	//@RequestParam url파라미터로 전달받은 value를 메서드의 파라미터로 받을 수 있게 해주는 어노테이션이다.
				@RequestParam(required = false) String searchKeyword,	//@RequestParam 을 쓰게되면 어노테이션 쓴것만 파라미터로 받게된다.
				Criteria cri, final NoticeVo param,
				Model model) throws Exception {		 
		 
		 int searchList = noticeService.searchList(param);
		 System.out.println("param " + param);
		 System.out.println("searchCondition " + searchCondition);
		 System.out.println("searchKeyword " + searchKeyword);
		 //검색시 페이징
		 Paging paging = new Paging();
		 
		 paging.setCri(cri);
		 paging.setTotalCount(searchList);
		 
		 List<NoticeVo> searchResults = noticeService.searchNotices(searchCondition, searchKeyword, cri, param);
		 
		 System.out.println("searchCondition " + searchCondition);
		 System.out.println("searchKeyword " + searchKeyword);
		 System.out.println("cri " + cri);
		 
		 model.addAttribute("paging", paging);
		 model.addAttribute("searchKeyword", searchKeyword);
		 model.addAttribute("searchResults", searchResults);
		 
		 System.out.println("searchResults " + searchResults);
		 return "notice/list";
	 }
	 
}	  

/*
 로그인과 게시판의 형이 다르다
 대부분 로그인은 String으로 많이 처리한다.
 게시판은 각각 다 다를수 있다.
 배열이 들어가기 때문이다.
 */
 

