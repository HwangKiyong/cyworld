package com.web.test.Diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.test.Diary.mapper.DiaryMapper;
import com.web.test.Diary.vo.DiaryVo;
import com.web.test.Mini.vo.MiniVo;

@Service
public class DiaryService {

	@Autowired
	private DiaryMapper diaryMapper;
	
	public List<DiaryVo> diaryList(String user_id) {
		return diaryMapper.diaryList(user_id);
	}

	public List<MiniVo> miniList(String user_id) {
		return diaryMapper.miniList(user_id);
	}
	
	public int insertDiary(DiaryVo diaryVo) {
		return diaryMapper.insertDiary(diaryVo);
	}

	public int updateDiary(DiaryVo diaryVo) {
		return diaryMapper.updateDiary(diaryVo);
	}

	public int deleteDiary(Integer diary_no) {
		return diaryMapper.deleteDiary(diary_no);
	}

	
}
