package com.web.test.Notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.test.Notice.mapper.NoticeMapper;
import com.web.test.Notice.vo.Criteria;
import com.web.test.Notice.vo.NoticeVo;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NoticeService.class);
	
	public NoticeService(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}
	
	//페이징처리
	public int noticeListCnt() throws Exception {
		return noticeMapper.noticeListCnt();
	}	
	
	public List<NoticeVo> noticeList(Criteria cri) {
		return noticeMapper.noticeList(cri);
	}
	
	//조회수 증가
	public Long updateView(Long notice_no) {
		return noticeMapper.updateView(notice_no);
	}
		
	//검색하기
	public List<NoticeVo> searchNotices(String searchCondition, String searchKeyword, Criteria cri, final NoticeVo param) throws Exception {
		return noticeMapper.searchNotices(searchCondition, searchKeyword, cri, param);
	}
	
//	public int searchList(String title, String writer, String searchCondition, String searchKeyword) {
//		return noticeMapper.searchList(title, writer, searchCondition, searchKeyword);
//	}
	
	public NoticeVo getNoticeById(Long notice_no) {
		return noticeMapper.getNoticeById(notice_no);
	}
	
	//게시글 상세조회
	public NoticeVo selectNotice(Long notice_no) {
	   return noticeMapper.selectNotice(notice_no);
	}
	
	//게시글 작성
	public int insertNotice(NoticeVo noticeVo) {
	     return noticeMapper.insertNotice(noticeVo);
	}
	
	//게시글 수정
	public int updateNotice(NoticeVo noticeVo) {
	    return noticeMapper.updateNotice(noticeVo);
	}
	
	//게시글 삭제
	public int deleteNotice(Long notice_no) {
	    return noticeMapper.deleteNotice(notice_no);
	}

	public int searchList(final NoticeVo param) {
		return noticeMapper.searchList(param);
	}
		
}
