package com.lec.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.my.dao.MVC_BoardDao;
import com.lec.my.dto.MVC_Board;
import com.lec.my.util.Paging;

@Service
public class MVC_BoardServiceImpl implements MVC_BoardService {
	@Autowired
	private MVC_BoardDao boardDao;
	
	@Override
	public List<MVC_Board> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.totCnt(), pageNum);
		MVC_Board board = new MVC_Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board);
	}

	@Override
	public int totCnt() {
		return boardDao.totCnt();
	}

	@Override
	public int insertBoard(MVC_Board board) {
		return boardDao.insertBoard(board);
	}

	@Override
	public int hitup(int bid) {
		return boardDao.hitup(bid);
	}

	@Override
	public MVC_Board detail(int bid) {
		return boardDao.detail(bid);
	}

	@Override
	public int stepA(MVC_Board board) {
		return boardDao.stepA(board);
	}

	@Override
	public int reply(MVC_Board board) {
		return boardDao.reply(board);
	}

	@Override
	public int update(MVC_Board board) {
		return boardDao.update(board);
	}

	@Override
	public int delete(int bid) {
		return boardDao.delete(bid);
	}
}
