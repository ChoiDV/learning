package com.lec.ch13.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileUploadService {
	public boolean fileUp(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		boolean isUpload = false;  // 이게 true면 파일업로드가 됐다
		// 파일 업로드 로직 
		// 파일 업로드된 파일명 받아서, 서버에 업로드, 프로젝트 폴더에 복사
		String uploadPath = mRequest.getRealPath("upload/");  // 서버 기준의 저장되는 폴더 , 서버에 업로드 되는 폴더 
		String backupPath = "D:\\Java_Choijinyoung\\source\\09_Spring\\ch13_fileup\\src\\main\\webapp\\upload/";  // 물리적으로 저장할 폴더?
		String[] filenames = new String[3];
		int i = 0;
		Iterator<String> params = mRequest.getFileNames();  // file1, file2, file3
		while(params.hasNext()) {
			String param = params.next();
			System.out.println(i+" 번째 파라미터 이름 : " + param);
			MultipartFile mFile = mRequest.getFile(param);
			filenames[i] = mFile.getOriginalFilename(); // param으로 첨부한 파일의 오리지널 파일명
			if(filenames[i] != null && !filenames[i].equals("")) {
				if(new File(uploadPath + filenames[i]).exists()) {  // uploadPath (upload/ ) + filename[i] 즉, upload파일밑에 파일(첨부한 파일이름)이 있니?
					filenames[i] = System.currentTimeMillis()+filenames[i];  // 이경우는 중복되었을 경우니까 파일명 앞에 currentTimeMillis를 붙인다.
																		     //  currentTimeMillis는 매시간 매초마다 바뀌니까 저걸로 구분가능하다.
				} // if - 중복된 파일명일 경우 변경
				try {
					mFile.transferTo(new File(uploadPath+filenames[i])); // 서버에 파일저장 ( 서버의 파일저장폴더 밑에 파일이름으로 저장 (중복된 파일이름일경우 시간붙인 파일이름 저장)
					System.out.println("서버에 저장된 파일 : " + uploadPath + filenames[i]);
					System.out.println("백업 복사 파일 : " + backupPath + filenames[i]);
					isUpload = filecopy(uploadPath + filenames[i],backupPath + filenames[i]);
				} catch (IOException e) {
					// 예외가 나는경우는 파일저장 폴더가 없을때 예외발생
					System.out.println(e.getMessage() + " 파일저장폴더가 없음");
				}  
			}else {
				System.out.println(i+" 번째는 파일 첨부 안함");
				isUpload = true;
			}  // 파일 첨부			
			i++;
		}  // while
		mav.addObject("filename",filenames); // filenames는 배열  ModelAndView 객체에 담아주기
		return isUpload;
	}

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
