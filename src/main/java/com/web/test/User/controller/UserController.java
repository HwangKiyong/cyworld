package com.web.test.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.test.Mini.vo.MiniVo;
import com.web.test.User.service.UserService;
import com.web.test.User.vo.UserVo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	//로그인화면으로 이동
	@RequestMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	//로그인시 db에 있는정보 확인
	@RequestMapping("/loginCheck")
	public String loginCheck(UserVo userVo, Model model, HttpSession session,
		@RequestParam(required = false) String remember, HttpServletResponse response) throws Exception {
		UserVo user = userService.loginCheck(userVo);
		
		if(user == null) {
			System.out.println("없는 정보입니다.");
			model.addAttribute("msg", "아이디 비밀번호를 확인하세요");
			return "user/login";
		}
		
		if(user != null && userVo.getUser_pwd().equals(user.getUser_pwd()) && userVo.getUser_id().equals(user.getUser_id())) {
			System.out.println("로그인 성공");
			
			// 아이디 저장 체크 여부 확인
			if (remember != null && remember.equals("on")) {
				// 쿠키 생성 및 설정
				Cookie cookie = new Cookie("savedUserId", user.getUser_id());
				cookie.setMaxAge(7 * 24 * 60 * 60); // 7일 동안 유효
				response.addCookie(cookie);
//				session.setAttribute("user", user);
//				model.addAttribute("user", user);
//				model.addAttribute("remember", remember);
			} else {
				// 쿠키 삭제
				Cookie cookie = new Cookie("savedUserId", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			
			System.out.println(user.getUser_id());
			System.out.println(remember);
			
			session.setAttribute("savedUserId", user.getUser_id());
			session.setAttribute("user", user);
			model.addAttribute("user", user); // user 객체를 Model에 추가
			
			String user_id = (String) session.getAttribute("savedUserId");
			
			List<MiniVo> mini = userService.todayList();
			model.addAttribute("mini", mini);
			
			return "/common/mainPage";
		} else {
			model.addAttribute("msg", "아이디 비밀번호를 확인하세요");
			System.out.println("로그인 실패");
			return "/user/login";
		}
	}
	
	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃");
		return "redirect:/login";
	}
	
}
