package com.web.test.Notice.vo;
//게시판 하단의 페이징
public class Paging {
	private int totalCount;	//게시판 전체 데이터 개수
	private int displayPageNum = 5; //게시판 화면에서 한번에 보여질 페이지 번호의 개수
	/*
	displayPageNum
	이부분에 대한 설정이 하단 페이징 목록의 1 2 3 ... 10 을 결정한다.
	내가 10으로 설정했으면 [1~10 다음]까지만 하단에 나오고
	11페이지 이후부터 [이전 11 ~ 20 다음] 이런식으로 출력된다. 
	 */
	private int startPage; //화면의 시작 번호
	private int endPage; //화면의 끝번호
	private boolean prev;	//페이징 이전 버튼 활성화 여부
	private boolean next;	//페이징 다음 버튼 활성화 여부
	
	private int pageNum;
	private Criteria cri;
	
	private int pageSize; // 한 페이지당 보여줄 게시글 개
	
	
	 
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		pagingData();
	}

	private void pagingData() {

		endPage = (int)(Math.ceil(cri.getPage()/ (double)displayPageNum) * displayPageNum);
		//endPage = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 개수) * 화면에 보여질 페이지 번호의 개수
		startPage = (endPage - displayPageNum) + 1;
		//startPage = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 개수) + 1
		
		int tempEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		//마지막 페이지 번호 = 총 게시글 수 / 한페이지당 보여줄 게시글의 수
		
		prev = startPage == 1 ? false : true;
		//이전 버튼 생성 여부 = 시작 페이지 번호가 1과 같으면 false 아니면 true
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
		//다음 버튼 생성 여부 = 끝 페이지 번호 * 한페이지당 보여줄 게시글의 개수가 총 게시글의 수보다 크거나 같으면 false, 아니면 true
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "Paging [totalCount=" + totalCount + ", displayPageNum=" + displayPageNum + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", cri=" + cri + "]";
	}
}
