package com.cvpedgram.like.service;

import org.springframework.stereotype.Service;

import com.cvpedgram.like.like.Like;
import com.cvpedgram.like.repository.LikeRepository;

@Service
public class LikeService {
	
	private LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	public boolean addLike(int userId,int postId) {
		
		Like like = Like.builder()
				.postId(postId)
				.userId(userId)
				.build();
		
		try {
			likeRepository.save(like);
			return true;
			
		} catch(Exception e) {
			return false;
		}
			
	}
	
	// 게시글의 아이디를 얻어온다
	public int getLikeCount(int postId){
		
		return likeRepository.countByPostId(postId);
		
	}
	
	public boolean isLike(int postId, int userId){
		
		int count = likeRepository.countByPostIdAndUserId(postId, userId);
		
		if(count > 0) {
			return true;
		}else {
			return false;
		}
	}

}
