package com.cos.post.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.post.domain.post.Post;
import com.cos.post.domain.post.PostDto;
import com.cos.post.domain.post.PostRepository;
import com.cos.post.domain.user.User;
import com.cos.post.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class PostController {
	
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	
	
	
	@PostMapping("/post")
	public String 글쓰기(@RequestBody PostDto dto) {
		
		Post post = PostDto.toEntity(dto);
		User userEntity = userRepository.findById(1).get();
		
		post.setReadCount(0);
		post.setUser(userEntity);
		postRepository.save(post);
		return "ok";
	}

	
	@GetMapping("/post")
	public List<Post> 글목록(){
		return postRepository.findAll();
	}
	
	
	@GetMapping("/post/{id}")
	public Post 글상세(@PathVariable int id) {
		Post post = postRepository.findById(id).get();
		
		return post;//이부분에서 지연로딩이되는데 관련 개념을 일단좀 잡자.
		
		
	}
}
