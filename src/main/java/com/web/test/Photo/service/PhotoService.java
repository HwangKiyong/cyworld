package com.web.test.Photo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.test.Mini.vo.MiniVo;
import com.web.test.Photo.mapper.PhotoMapper;
import com.web.test.Photo.vo.PhotoVo;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoMapper photoMapper;

	public List<PhotoVo> photoList(String user_id) {
		return photoMapper.photoList(user_id);
	}
	
	public List<MiniVo> miniList(String user_id) {
		return photoMapper.miniList(user_id);
	}
	
	public int insertPhoto(PhotoVo photoVo) {
		return photoMapper.insertPhoto(photoVo);
	}
	
	public int updatePhoto(PhotoVo photoVo) {
		return photoMapper.updatePhoto(photoVo);
	}

	public int deletePhoto(Integer photo_no) {
		return photoMapper.deletePhoto(photo_no);
	}
}
