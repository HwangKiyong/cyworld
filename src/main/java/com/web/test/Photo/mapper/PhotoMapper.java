package com.web.test.Photo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.test.Mini.vo.MiniVo;
import com.web.test.Photo.vo.PhotoVo;

@Mapper
public interface PhotoMapper {

	List<PhotoVo> photoList(String user_id);
	
	List<MiniVo> miniList(String user_id);

	int insertPhoto(PhotoVo photoVo);

	int updatePhoto(PhotoVo photoVo);
	
	int deletePhoto(Integer photo_no);
}
