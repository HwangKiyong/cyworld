package com.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.test.User.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/index")
public class HomeController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
//	@GetMapping("/mainPage")
//	public String index(UserVo userVo, Model model, HttpSession session) throws Exception {
//		log.info("메인 컨트롤러");
//		return "/common/mainPage";
//	}
}
