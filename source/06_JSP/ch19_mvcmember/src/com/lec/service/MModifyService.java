package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024; // 사진업로드 제한 용량 : 1MB
		String mphotofile = "";  // 첨부된 파일이 저장된 파일 이름		
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
				String param = params.nextElement();
				mphotofile = mRequest.getFilesystemName(param);			
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			String mphoto = mphotofile == null ? (String) session.getAttribute("mphoto"): mphotofile ;
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if( !mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			MemberDao dao = MemberDao.getInstance();
			MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			int result = dao.updateMember(member);
			if(result == MemberDao.SUCCESS) {
				// 회원정보 수정 완료
				request.setAttribute("updateResult",MemberDao.SUCCESS );
			} else {
				request.setAttribute("updateResult",MemberDao.FAIL);
			}
		} catch (Exception e) {
			
		}
		// 서버에 업로드된 파일을 소스 폴더로 복사
				File serverFile = new File(path + "/" + mphotofile);
				if(serverFile.exists() && !mphotofile.equals(((MemberDto)session.getAttribute("member")).getMphoto())) {
					InputStream is = null;
					OutputStream os = null;
					try {
						is = new FileInputStream(serverFile);
						os = new FileOutputStream("D:/Java_Choijinyoung/source/06_JSP/ch19_mvcmember/WebContent/memberPhotoUp/"+mphotofile);
						byte[] bs = new byte[(int) serverFile.length()];
						while(true) {
							int readByteCnt = is.read(bs);
							if(readByteCnt == -1) {
								break;
							}
							os.write(bs, 0 , readByteCnt);
						}
					} catch (IOException e) {
						System.out.println(e.getMessage());
					} finally {
						try {
							if(os != null) {
								os.close();
							}
							if(is != null) {
								is.close();
							}
						} catch (IOException e2) {
							System.out.println(e2.getMessage());
						}
					}
					
				}
				session.invalidate();

	}

}
