package com.cvpedgram.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvpedgram.like.like.Like;

public interface LikeRepository extends JpaRepository<Like,Integer> {
	
	// SELECT COUUNT(*) FROM `LIKE`  WHERE `postId` = #{}
	public int countByPostId(int postId);
	
	// SELECT COUNT(*) FROM `like` WHERE 
	public int countByPostIdAndUserId(int postId, int userId);

}
