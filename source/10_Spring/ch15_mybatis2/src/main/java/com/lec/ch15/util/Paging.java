package com.lec.ch15.util;

import lombok.Data;

@Data
public class Paging {
	private int currentPage = 1;
	private int pageSize;
	private int blockSize;
	private int startRow;
	private int endRow;
	private int totCnt;
	private int pageCnt;
	private int startPage;
	private int endPage;
	// Paging paging = new Paging(currentPage (14) , pageNum(2 or null ), 10 , 10 )
	public Paging(int totCnt, String pageNum, int pageSize, int blockSize) {
		if(pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
			// pageNum이 null이 아니면 int로 바꾸고 null이면 1
		}
		this.pageSize = pageSize;  
		this.blockSize = blockSize;  
		startRow = (currentPage - 1) * pageSize + 1;
		endRow = startRow + pageSize -1;
		this.totCnt = totCnt;
		pageCnt = (int)Math.ceil((double)totCnt / pageSize);
		startPage = ((currentPage-1)/blockSize) * blockSize +1;
//		startPage = currentPage - (currentPage-1) % blockSize;  // startPage 구하는 방법2
		endPage = startPage + blockSize -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
	}
	// Pagin pagin = new Paging(14, pageNum )
	public Paging(int totCnt, String pageNum ) {
		if(pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
			// pageNum이 null이 아니면 int로 바꾸고 null이면 1
		}
		this.pageSize = 10;  
		this.blockSize = 10;  
		startRow = (currentPage - 1) * pageSize + 1;
		endRow = startRow + pageSize -1;
		this.totCnt = totCnt;
		pageCnt = (int)Math.ceil((double)totCnt / pageSize);
		startPage = ((currentPage-1)/blockSize) * blockSize +1;
//		startPage = currentPage - (currentPage-1) % blockSize;  // startPage 구하는 방법2
		endPage = startPage + blockSize -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
	}
}
