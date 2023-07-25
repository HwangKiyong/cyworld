package com.web.test.Mini.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.test.Mini.vo.MiniVo;
import com.web.test.Photo.vo.PhotoVo;
import com.web.test.Visit.vo.VisitVo;

@Mapper
public interface MiniMapper {

	List<MiniVo> miniList(String user_id);

	int insertMini(MiniVo miniVo);
	
	int updateMini(MiniVo miniVo);
	
	int updateRoom(MiniVo miniVo);

	public int diaryTodayCnt(String user_id) throws Exception;

	public int diaryTotalCnt(String user_id) throws Exception;
	

	public int visitTodayCnt(String user_id) throws Exception;

	public int visitTotalCnt(String user_id) throws Exception;
	
	public int photoTodayCnt(String user_id) throws Exception;

	public int photoTotalCnt(String user_id) throws Exception;

	Map<String, Object> updateNews(String user_id);

	List<PhotoVo> getPhotoname(String user_id);

	List<VisitVo> getRegistertitle(String user_id);

	void updateTodayTotalByUserId(@Param("user_id") String user_id);

}
