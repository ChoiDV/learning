package com.lec.ch19.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch19.dto.Book;

@Mapper
public interface BookDao {
	// 모든 책 리스트 (출판일 순)
	public List<Book> mainList();
	// 모든 책 가나다 순으로 페이징 처리해서 출력
	public List<Book> bookList(Book book);
	// 모든 책 개수
	public int totCntBook();
	// 특정책 dto 가져오기 
	public Book getDetailBook(int bnum);
	// 책 등록하기
	public int registerBook(Book book);
	// 책 수정하기
	public int modifyBook(Book book);
}
