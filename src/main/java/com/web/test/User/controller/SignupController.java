package com.web.test.User.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.test.Mini.service.MiniService;
import com.web.test.Mini.vo.MiniVo;
import com.web.test.User.service.SignupService;
import com.web.test.User.vo.UserVo;

@Controller
public class SignupController {
	
	@Autowired
	private SignupService signupService;
	
	//회원가입 페이지로 이동
	@GetMapping("/signup")
	public String signup() {
		return "/user/signup";
	}
	
	//아이디찾기 페이지로 이동
	@GetMapping("/findId")
	public String findId() {
		return "/user/findId";
	}
	
	//비밀번호 찾기 페이지로 이동
	@GetMapping("/findPwd")
	public String findPwd() {
		return "/user/findPwd";
	}
	
	//회원가입 완료
	@PostMapping("/signupOk")
	public String signupOk(@ModelAttribute("userVo") UserVo userVo,MiniVo miniVo, Model model) throws Exception{
			signupService.insertRegister(userVo, miniVo);
			signupService.insertMini(userVo, miniVo);			
			return "/user/login";		//INSERT 후 성공페이지로 이동		
	}
	
	//id찾기
	@PostMapping("/findIdOk")
	@ResponseBody
	public ResponseEntity<String> findIdOk(@ModelAttribute("userVo") UserVo userVo) {
		try {
	        String userId = signupService.findId(userVo);
	        
	        if (userId != null) {
	        	System.out.println(userId);
	            return ResponseEntity.ok(userId);
	        } else {
	        	System.out.println(userId);
	        	return ResponseEntity.ok(null);  // 수정된 부분
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	//비밀번호 찾기
	@PostMapping("/findPwdOk")
	@ResponseBody
	public ResponseEntity<String> findPwdOk(@ModelAttribute("userVo") UserVo userVo) {
		try {
	        String userId = signupService.findPwd(userVo);
	        
	        if (userId != null) {
	            return ResponseEntity.ok(userId);
	        } else {
	        	return ResponseEntity.ok(userId);
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	//아이디 중복확인
	@ResponseBody
	@RequestMapping(value = "/checkIdDuplicate", method = RequestMethod.POST)
	public Map<String, Object> checkIdDuplicate(@RequestParam("id") String user_id) {
		Map<String, Object> result = signupService.checkDuplicateId(user_id);
		if(result.get("result").equals("error")) {
			System.out.println("error occurred: " + result.get("message"));
		}else {
			System.out.println(result);
		}
		
		return result;
	}
}
