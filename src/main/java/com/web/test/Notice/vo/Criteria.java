package com.web.test.Notice.vo;

public class Criteria {
	//특정 페이지 조회를 위한 클래스
	private int page;	//현재 페이지 번호
	private int perPageNum;	//페이지당 보여줄 게시글의 수
	
	public int getPageStart() {
		//특정 페이지의 범위를 정하는 구간, 현재 페이지의 게시글 시작 번호
		//0 ~ 10 , 10 ~ 20 이런식으로
		return (this.page - 1) * perPageNum;
	}
	
	public Criteria() {
		//기본생성자: 최초 게시판 진입시 필요한 기본값
		this.page = 1;
		this.perPageNum = 5;				
		//이 부분에 대한 설정이 처음 들어갔을 대 페이지 표시와 목록에 몇 개나 보여줄지를 설정한다.
	}
	
	//현재 페이지 번호 page : getter, setter
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}
	
	//페이지당 보여줄 게시글의 개수 perPageNum: getter, setter
	public int getPerPageNum() {
		return perPageNum;
	}
	
	public void setPerPageNum(int perPageNum) {
		int cnt = this.perPageNum;
		
		if(perPageNum != cnt) {
			this.perPageNum = cnt;
		} else {
			this.perPageNum = perPageNum;
		}
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}	
}
