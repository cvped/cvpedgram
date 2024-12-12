package com.cvpedgram.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cvpedgram.comment.comment.Comment;
import com.cvpedgram.comment.service.CommentService;
import com.cvpedgram.common.FileManager;
import com.cvpedgram.like.service.LikeService;
import com.cvpedgram.post.domain.Post;
import com.cvpedgram.post.dto.CardDTO;
import com.cvpedgram.post.repository.PostRepository;
import com.cvpedgram.user.domain.User;
import com.cvpedgram.user.service.UserService;

@Service
public class PostService {

private PostRepository postRepository;
private UserService userService;
private LikeService likeService;
private CommentService commentService;
	
	// 생성자를 저장해 변수를 얻어온다
	public PostService(PostRepository postRepository,UserService userService, LikeService likeService, CommentService commentService) {
		this.postRepository = postRepository;
		this.userService = userService;
		this.likeService = likeService;
		this.commentService = commentService;
	}
	
	//  file 경로 저장
	public boolean addPost(int userId, String contents, MultipartFile file) {
		
		String imagePath = FileManager.saveFile(userId, file);
		
		Post post = Post.builder()
			 .userId(userId)
			.contents(contents)
			.imagePath(imagePath)
			.build();
		
		// 저장 실패 성공 여부 확인하기위해서 
		try {
			 postRepository.save(post);
			return true;
		} catch(Exception e) {
			return false;
		}

	}
		
		
		public List<CardDTO> getPostList(int loginUserId) {
			
			// 조회된 게시글마다 작성자의 로그인 ID 얻어오기
			List<Post> postList = postRepository.findAllByOrderByIdDesc();
			
			List<CardDTO> cardList = new ArrayList<>();
			for(Post post:postList) {
				
				int userId = post.getUserId();
				User user = (User) userService.getUserById(userId);
				int likecount = likeService.getLikeCount(post.getId());
				boolean islike = likeService.isLike(post.getId(),loginUserId);
				
				List<Comment> commentList = commentService.getCommnetList(post.getId());
				
				CardDTO card = CardDTO.builder()
				.postId(post.getId())
				.userId(userId)
				.contents(post.getContents())
				.imagePath(post.getImagePath())
				.logingId(user.getLoginId())
				.likeCount(likecount)
				.isLike(islike)
				.commentList(commentList)
				.build();
				
				cardList.add(card);
			}
			
			return cardList;
			
		}
		
	

	
}
