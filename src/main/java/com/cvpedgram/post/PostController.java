package com.cvpedgram.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cvpedgram.post.domain.Post;
import com.cvpedgram.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {

	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/list-view")
	public String memoList(
			Model model
			,HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> memoList = postService.getPostList(userId);
		
		model.addAttribute("memoList",memoList);
		
		return "post/list";
	}
	
	@GetMapping("/create-view")
	public String memoenter() {
		return "post/enter";
	}
	
	@GetMapping("/input-view")
	public String memoinput(@RequestParam("id") int id
			,Model model) {
		
		Post memo = postService.getPost(id);
		
		model.addAttribute("memo",memo);
		
		return "post/input";
	}
}
