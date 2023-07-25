package com.web.test.User.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.test.Mini.vo.MiniVo;
import com.web.test.User.vo.UserVo;

@Mapper
public interface UserMapper {

	UserVo loginCheck(UserVo userVo);

	List<MiniVo> todayList();
}
