package com.web.test.Diary.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.test.Diary.vo.DiaryVo;
import com.web.test.Mini.vo.MiniVo;

@Mapper
public interface DiaryMapper {

	List<DiaryVo> diaryList(String user_id);
	
	List<MiniVo> miniList(String user_id);

	int insertDiary(DiaryVo diaryVo);

	int updateDiary(DiaryVo diaryVo);

	int deleteDiary(Integer diary_no);

}
