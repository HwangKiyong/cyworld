package com.web.test.Notice.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.web.test.Notice.vo.Criteria;
import com.web.test.Notice.vo.NoticeVo;

@Repository
public interface NoticeMapper {

	
	//페이징처리
	int noticeListCnt() throws Exception;

	public List<NoticeVo> noticeList(Criteria cri);
	
	//조회수증가
	Long updateView(Long notice_no);
	
	//검색기능
	public List<NoticeVo> searchNotices(@Param("searchCondition")String searchCondition,
										@Param("searchKeyword")String searchKeyword, @Param("cri")Criteria cri, final NoticeVo param)throws Exception;
	
	int searchList(String title, String writer, String searchCondition, String searchKeyword);
	
	NoticeVo getNoticeById(Long notice_no);
	
	//게시글 상세 조회
	NoticeVo selectNotice(Long notice_no);
		
	//게시글 등록
	int insertNotice(NoticeVo noticeVo);
		
	//게시글 수정
	int updateNotice(NoticeVo noticeVo);
		
	//게시글 삭제
	int deleteNotice(Long notice_no);

	int searchList(final NoticeVo param);
}
