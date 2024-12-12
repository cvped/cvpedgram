package com.cvpedgram.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cvpedgram.comment.comment.Comment;
import com.cvpedgram.comment.repository.CommentRepository;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public boolean addComment(int userId,int postId,String contents) {
		
		Comment comment = Comment.builder()
				.userId(userId)
				.postId(postId)
				.contents(contents)
				.build();
		
		try {
			commentRepository.save(comment);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public List<Comment>getCommnetList(int postId){
		return commentRepository.findByPostId(postId);
	}

	
}
