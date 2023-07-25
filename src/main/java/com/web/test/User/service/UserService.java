package com.web.test.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.test.Mini.vo.MiniVo;
import com.web.test.User.mapper.UserMapper;
import com.web.test.User.vo.UserVo;

@Service
public class UserService {

	
	@Autowired
	private UserMapper userMapper;

	public UserVo loginCheck(UserVo userVo) {
		return userMapper.loginCheck(userVo);
	}

	public List<MiniVo> todayList() {
		return userMapper.todayList();
	}
}
