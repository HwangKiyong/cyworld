package com.web.test.Mini.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.test.Mini.mapper.MiniMapper;
import com.web.test.Mini.vo.MiniVo;
import com.web.test.Notice.vo.NoticeVo;
import com.web.test.Photo.vo.PhotoVo;
import com.web.test.Visit.vo.VisitVo;

@Service
public class MiniService {

	@Autowired
	private MiniMapper miniMapper;

	public int insertMini(MiniVo miniVo) {
		return miniMapper.insertMini(miniVo);
	}


	public List<MiniVo> miniList(String user_id) {
		return miniMapper.miniList(user_id);
	}
	
	public int diaryTodayCnt(String user_id) throws Exception {
		return miniMapper.diaryTodayCnt(user_id);
	}


	public int diaryTotalCnt(String user_id) throws Exception{
		return miniMapper.diaryTotalCnt(user_id);
	}

	public int visitTodayCnt(String user_id) throws Exception {
		return miniMapper.visitTodayCnt(user_id);
	}


	public int visitTotalCnt(String user_id) throws Exception{
		return miniMapper.visitTotalCnt(user_id);
	}
	
	public int photoTodayCnt(String user_id) throws Exception {
		return miniMapper.photoTodayCnt(user_id);
	}


	public int photoTotalCnt(String user_id) throws Exception{
		return miniMapper.photoTotalCnt(user_id);
	}


	public Map<String, Object> updateNews(Map<String, Object> total, String user_id) {
		return miniMapper.updateNews(user_id);
	}


	public List<PhotoVo> getPhotoname(String user_id) {
		return miniMapper.getPhotoname(user_id);
	}


	public List<VisitVo> getRegistertitle(String user_id) {
		return miniMapper.getRegistertitle(user_id);
	}


	public void updateTodayTotalByUserId(String user_id) {
		miniMapper.updateTodayTotalByUserId(user_id);
	}


	public int updateMini(MiniVo miniVo) {
		return miniMapper.updateMini(miniVo);
	}
	
	public int updateRoom(MiniVo miniVo) {
		return miniMapper.updateRoom(miniVo);
	}


}
