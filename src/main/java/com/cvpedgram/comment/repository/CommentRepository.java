package com.cvpedgram.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvpedgram.comment.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{
	
	// WHERE `postId` = #{}
	public List<Comment> findByPostId(int postId);

}
