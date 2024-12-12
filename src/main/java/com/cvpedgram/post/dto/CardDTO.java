package com.cvpedgram.post.dto;

import java.util.List;

import com.cvpedgram.comment.comment.Comment;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class CardDTO {
	
	
	private int postId;
	private int userId;
	
	private String contents;
	private String imagePath;
	
	private String logingId;
	
	private int likeCount;
	private boolean isLike;
	
	List<Comment> commentList;

}
