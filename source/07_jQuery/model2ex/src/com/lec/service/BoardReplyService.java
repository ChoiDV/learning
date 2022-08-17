package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.FileBoardDao;
import com.lec.dto.FileBoardDto;
import com.lec.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024*5; // 사진 업로드 제한 용량 : 5M
		String fFileName = ""; // 첨부된 파일이 저장된 파일 이름
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize,
											"utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			fFileName = mRequest.getFilesystemName(param);
			int fId = Integer.parseInt(mRequest.getParameter("fId"));
			String mId = mRequest.getParameter("mId"); 
			String fTitle = mRequest.getParameter("fTitle");
			String fContent = mRequest.getParameter("fContent");
			String pageNum = mRequest.getParameter("pageNum");
			int fGroup = Integer.parseInt(mRequest.getParameter("fGroup"));
			int fStep = Integer.parseInt(mRequest.getParameter("fStep"));
			int fIndent = Integer.parseInt(mRequest.getParameter("fIndent"));
			String fIp = request.getRemoteAddr();
			fFileName = fFileName==null ? "NOIMG.JPG" : fFileName;
			FileBoardDao dao = FileBoardDao.getInstance();	
			request.setAttribute("replyBoardResult", dao.reply(mId, fTitle, fContent, fFileName, fGroup, fStep, fIndent, fIp));
			request.setAttribute("pageNum", pageNum );
			request.setAttribute("fId", fId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		// 서버에 업로드된 파일을 소스 폴더로 복사
		File serverFile = new File(path + "/" + fFileName);
		if(serverFile.exists() && !fFileName.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\Java_Choijinyoung\\source\\07_jQuery\\model2ex\\WebContent\\freeBoardUp/"+fFileName);
				byte[] bs = new byte[(int) serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt==-1) break;
					os.write(bs, 0, readByteCnt);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (IOException e) {
					
				}
			}
		}
	}

	}


