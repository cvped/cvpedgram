package com.cvpedgram.post;


import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cvpedgram.post.service.PostService;

import jakarta.servlet.http.HttpSession;

public class PostRestController {

	
private PostService postService;
	
	public PostRestController(PostService postService) {
		this.postService = postService;
	}
	
	@PostMapping("/create")
	public Map<String,String> createPost(
			@RequestParam("contents")String contents
			,@RequestParam("imageFile")MultipartFile file
			,HttpSession session){
				
		int userId = (Integer)session.getAttribute("userId");
		
	}
}
