package com.web.test.Visit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.test.Diary.vo.DiaryVo;
import com.web.test.Mini.vo.MiniVo;
import com.web.test.Visit.vo.VisitVo;

@Mapper
public interface VisitMapper {

	List<VisitVo> visitList(String user_id);
	
	List<MiniVo> miniList(String user_id);

	int insertVisit(VisitVo visitVo);

	int updateVisit(VisitVo visitVo);
	
	int deleteVisit(Integer register_no);
}
