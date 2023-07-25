package com.web.test.User.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.web.test.User.vo.UserVo;

@Mapper
public interface SignupMapper {

	void insertRegister(UserVo userVo);

	void selectById(String user_id);	//아이디 중복확인
	
	Map<String, Object>selectByIdWithResult(String user_id) throws Exception;	//아이디 중복확인 결과 반환 

	String findId(UserVo userVo);
	
	String findPwd(UserVo userVo);
}
