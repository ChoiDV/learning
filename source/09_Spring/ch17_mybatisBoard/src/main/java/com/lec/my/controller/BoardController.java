package com.lec.my.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.my.dto.MVC_Board;
import com.lec.my.service.MVC_BoardService;
import com.lec.my.util.Paging;

@Controller
public class BoardController {
	@Autowired
	private MVC_BoardService boardService;
	
	@RequestMapping(value="boardList.do",method= {RequestMethod.GET, RequestMethod.POST })
	public String boardList(String pageNum, Model model) {
		model.addAttribute("boardList",boardService.boardList(pageNum));
		model.addAttribute("paging",new Paging(boardService.totCnt(), pageNum));
		return "boardList";
	}
	@RequestMapping(value="detail.do",method=RequestMethod.GET)
	public String detail(int bid, Model model) {
		boardService.hitup(bid);
		model.addAttribute("detail",boardService.detail(bid));
		return "detail";
	}
	@RequestMapping(value="writeView.do",method= {RequestMethod.GET, RequestMethod.POST})
	public String writeView(Model model) {
		return "write";
	}
	@RequestMapping(value="write.do",method=RequestMethod.POST)
	public String write(MVC_Board board, HttpServletRequest request, Model model) {
		board.setBip(request.getRemoteAddr());
		model.addAttribute("writeResult",boardService.insertBoard(board));
		return "forward:boardList.do";
	}
	@RequestMapping(value="updateView.do",method= {RequestMethod.GET,RequestMethod.POST })
	public String updateView(int bid, Model model) {
		model.addAttribute("boardDto",boardService.detail(bid));
		return "updateView";
	}
	@RequestMapping(value="update.do",method=RequestMethod.POST)
	public String update(MVC_Board board, HttpServletRequest request, Model model) {
		board.setBip(request.getRemoteAddr());
		model.addAttribute("updateResult",boardService.update(board));
		return "forward:boardList.do";
	}
	@RequestMapping(value="delete.do",method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", boardService.delete(bid));
		return "forward:boardList.do";
	}
	@RequestMapping(value="replyView.do",method=RequestMethod.GET)
	public String reply(int bid, Model model) {
		model.addAttribute("bid",bid);
		return "replyWriteView";
	}
	@RequestMapping(value="replyWrite.do",method=RequestMethod.POST)
	public String replyWrite(MVC_Board board, int bid, Model model, HttpServletRequest request) {
		MVC_Board mvc = boardService.detail(bid);
		board.setBip(request.getRemoteAddr());
		board.setBgroup(mvc.getBgroup());
		board.setBstep(mvc.getBstep()+1);
		board.setBindent(mvc.getBindent()+1);
		boardService.stepA(mvc);
		model.addAttribute("bid",mvc.getBid());
		model.addAttribute("replyResult",boardService.reply(board));
		return "forward:boardList.do";
	}
}
