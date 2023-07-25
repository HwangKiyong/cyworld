package com.web.test.Visit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.test.Diary.vo.DiaryVo;
import com.web.test.Mini.vo.MiniVo;
import com.web.test.Visit.mapper.VisitMapper;
import com.web.test.Visit.vo.VisitVo;

@Service
public class VisitService {

	@Autowired
	private VisitMapper visitMapper;
	
	public List<VisitVo> visitList(String user_id) {
		return visitMapper.visitList(user_id);
	}
	
	public List<MiniVo> miniList(String user_id) {
		return visitMapper.miniList(user_id);
	}

	public int insertVisit(VisitVo visitVo) {
		return visitMapper.insertVisit(visitVo);
	}
	
	public int updateVisit(VisitVo visitVo) {
		return visitMapper.updateVisit(visitVo);
	}

	public int deleteVisit(Integer register_no) {
		return visitMapper.deleteVisit(register_no);
	}
	
}
