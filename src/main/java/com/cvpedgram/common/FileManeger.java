package com.cvpedgram.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManeger {
	
	// 상수
	public static String file_Upload_Path = "C:\\cvped\\springproject\\upload\\cvpedgram";
	
	public static final String saveFile(int userId, MultipartFile file) {
		
		// 파일 이름을 유지
		// 같은 이름의 파일이 전달 된 경우를 대비해서 디렉토리를 만들어서 파일 저장
		// 디렉토리 이름에 사용자 정보 포함
		// 시간을 디텍토리 이름에 포함
		// UNIX TIME : 1970SUS 1월 1일 부터 흐른시간을 milli second(1/1000조) 로 표현한 값
		// ex : 2_89723598273
		
		String directoryName = "/" + userId + "_" + System.currentTimeMillis();
		
		// 디렉토리 만들기
		
		// 파일의 천채 경로가 필요하다
		String directoryPath = file_Upload_Path + directoryName;
		
		File directory = new File(directoryPath);
		
		if(!directory.mkdir()){
			// 디렉토리 생성 실패
			return null;
		}
		
		// 파일 저장
		String filePath = directoryPath + "/" + file.getOriginalFilename();
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath);
			
			Files.write(path, bytes);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			 // 예외 상황이 생기면
			 // 파일 저장에 실패
			return null;
		}
		
		// "C:\\cvped\\springproject\\upload\\memo";
		// images/2_89723598273
		
		return "/images" + directoryName + "/" + file.getOriginalFilename();
		
	}

}
