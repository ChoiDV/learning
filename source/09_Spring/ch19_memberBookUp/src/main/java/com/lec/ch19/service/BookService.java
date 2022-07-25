package com.lec.ch19.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;

public interface BookService {
	// 모든 책 리스트
	public List<Book> mainList();
	// 모든 책 가나다 순 페이징 출력
	public List<Book> bookList(String pageNum);
	// 모든 책 개수
	public int totCntBook();
	//  특정 책 상세보기
	public Book getDetailBook(int bnum);
	// 책 등록하기
	public int registerBook(MultipartHttpServletRequest mRequest, Book book);  // 파일첨부를 위해 멀티파트리퀘스트 객체도 같이 
	public int registerBook(MultipartHttpServletRequest mRequest); // 2가지 방법이 있는데 이 방법은 비추 
	// 책 수정하기
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book);
//	public int modifyBook(MultipartHttpServletRequest mRequest); // 2가지 방법이 있는데 이 방법은 비추
}
