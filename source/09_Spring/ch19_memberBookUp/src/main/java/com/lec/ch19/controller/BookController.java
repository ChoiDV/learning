package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(params="method=detail", method= {RequestMethod.GET, RequestMethod.POST})
	public String detail(int bnum,String pageNum, Model model) {
		model.addAttribute("bookDetail",bookService.getDetailBook(bnum));
		model.addAttribute("pageNum", pageNum);
		return "book/detail";
	}
	@RequestMapping(params="method=list",method= {RequestMethod.GET, RequestMethod.POST})
	public String bookList(Book book,String pageNum, Model model) {
		model.addAttribute("bookList", bookService.bookList(pageNum, book));
		model.addAttribute("paging",new Paging(bookService.totCntBook(book), pageNum,3,3));
		return "book/list";
	}
	@RequestMapping(params="method=registerForm",method=RequestMethod.GET)
	public String registerForm() {
		return "book/registerForm";
	}
	@RequestMapping(params="method=register",method=RequestMethod.POST)
	public String registerBook(MultipartHttpServletRequest mRequest, Book book,Model model) {
		model.addAttribute("registerResult",bookService.registerBook(mRequest, book));
		return "forward:book.do?method=list";
	}
	@RequestMapping(params="method=modifyForm",method=RequestMethod.GET)
	public String modifyForm(int bnum, Model model, String pageNum ) {
		model.addAttribute("modifyBook", bookService.getDetailBook(bnum));
		return "book/modifyForm";
	}
	@RequestMapping(params="method=modify", method=RequestMethod.POST)
	public String modifyBook(MultipartHttpServletRequest mRequest, Book book, Model model, String pageNum) {
		model.addAttribute("modifyResult", bookService.modifyBook(mRequest, book));
		return "forward:book.do?method=detail&bnum="+book.getBnum()+"&pageNum="+pageNum;
		
	}
}
