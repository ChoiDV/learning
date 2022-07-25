package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.dto.Book;
import com.lec.ch19.util.Paging;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	String backupPath = "D:\\Java_Choijinyoung\\source\\09_Spring\\ch19_memberBookUp\\src\\main\\webapp\\bookImgFileUpload/";
	
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public List<Book> bookList(String pageNum) {
		Paging paging = new Paging(bookDao.totCntBook(), pageNum,3,3);
		Book book = new Book();
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookDao.bookList(book);
	}

	@Override
	public int totCntBook() {
		return bookDao.totCntBook();
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookDao.getDetailBook(bnum);
	}

	@Override 
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) { // 책 등록
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames();  // tempBimg1, tempBimg2
		String[] bimg = new String[2];  //  = { "", "" }; 랑 같음
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx] != null && !bimg[idx].equals("")) {  // 이럴경우 파일 첨부했을 경우
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 첨부한 파일 이름과 같은 이름의 파일이 서버에 있니? ( 같은이름의 파일이 이미 저장되어있는 경우 )
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버 파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업 파일 : " + backupPath);
					boolean result = filecopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업성공" : idx+" 번째 백업 실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} else { 
				// 파일 첨부 안한경우 bimg[idx] = ""
				bimg[idx] = "";
			}
			idx++;
		}
		book.setBimg1(bimg[0]); // 첫번째 첨부한 파일 이름
		book.setBimg2(bimg[1]); // 두번째 첨부한 파일 이름
		return bookDao.registerBook(book);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames();  // tempBimg1, tempBimg2
		String[] bimg = new String[2];  //  = { "", "" }; 랑 같음
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx] != null && !bimg[idx].equals("")) {  // 이럴경우 파일 첨부했을 경우
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 첨부한 파일 이름과 같은 이름의 파일이 서버에 있니? ( 같은이름의 파일이 이미 저장되어있는 경우 )
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버 파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업 파일 : " + backupPath);
					boolean result = filecopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업성공" : idx+" 번째 백업 실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} else { 
				// 파일 첨부 안한경우 bimg[idx] = ""
				bimg[idx] = "";
			}
			idx++;
		}
		Book book = new Book();
		book.setBnum(Integer.parseInt(mRequest.getParameter("bnum")));
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		book.setBinfo(mRequest.getParameter("binfo"));
		return bookDao.registerBook(book);
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames();  // tempBimg1, tempBimg2
		String[] bimg = new String[2];  //  = { "", "" }; 랑 같음
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx] != null && !bimg[idx].equals("")) {  // 이럴경우 파일 첨부했을 경우
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 첨부한 파일 이름과 같은 이름의 파일이 서버에 있니? ( 같은이름의 파일이 이미 저장되어있는 경우 )
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버 파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업 파일 : " + backupPath);
					boolean result = filecopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업성공" : idx+" 번째 백업 실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			} else { 
				// 파일 첨부 안한경우 bimg[idx] = ""
				bimg[idx] = "";
			}
			idx++;
		}
		book.setBimg1(bimg[0]); 
		book.setBimg2(bimg[1]);
		return bookDao.modifyBook(book);
	}

//	@Override
//	public int modifyBook(MultipartHttpServletRequest mRequest) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		// 복사
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int) file.length()];  // 파일 크기를 1MB로 제한했기때문에 long 형이 들어올수 없으므로 int로 형변환
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) {
					break;
				}
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + serverFile + " 이란 파일이 없습니다.");
		} catch (IOException e) {
			// 이거는 파일 읽어올때 예외 
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os != null) {
					os.close();
				}
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}

}
