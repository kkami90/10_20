package com.cos.post.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.post.domain.comment.Comment;
import com.cos.post.domain.comment.CommentRepository;
import com.cos.post.domain.post.Post;
import com.cos.post.domain.post.PostRepository;
import com.cos.post.domain.user.User;
import com.cos.post.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor //repository final선언용
@RestController
public class CommentController {
	
	private CommentRepository commentRepository;
	private PostRepository postRepository;
	private UserRepository userRepository;
	
	@PostMapping("/post/{postId}/comment")
	public String 댓글입력(@RequestBody Comment com,@PathVariable int postId) {
		Post postentity = postRepository.findById(postId).get();
		User userentity = userRepository.findById(1).get();
		com.setPost(postentity);
		com.setUser(userentity);
		commentRepository.save(com);
		
		return "성공";
	}
	
	@GetMapping("/comment")
	public List<Comment> 댓글출력(){
		return commentRepository.findAll();
	}
	

}
