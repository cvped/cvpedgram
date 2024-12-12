package com.cvpedgram.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cvpedgram.like.service.LikeService;

import jakarta.servlet.http.HttpSession;

public class LikeRestController {
	
	private LikeService likeService;
	
	public LikeRestController(LikeService likeService) {
		this.likeService = likeService;
	}
	
	@PostMapping("/like")
	public Map<String,String>like(
			@RequestParam("postId") int postId
			,HttpSession session){
		
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String,String> resultMap = new HashMap<>();
		if(likeService.addLike(userId, postId)) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
}

}
