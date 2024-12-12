package com.cvpedgram.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	// 상수
	// 파일 경로 저장
	public  final static String File_Upload_Path = "C:\\cvped\\springproject\\upload\\cvpedgram";
	
	// 저장된 파일경로를 문자열로 리턴하기 위해 String을 쓴다
	public static final String saveFile(int userId, MultipartFile file) {
		
		
		String directoryName = "/" + userId + "_" + System.currentTimeMillis();
		
		// 디렉토리 만들기
		
		// 파일의 천채 경로가 필요하다
		String directoryPath = File_Upload_Path + directoryName;
		
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
		
		
		return "/images" + directoryName + "/" + file.getOriginalFilename();
		
	}

}
