package com.cos.post.domain.post;

import lombok.Data;

@Data
public class PostDto {
	private String title;
	private String content;
	
	public static Post toEntity(PostDto dto) {
		Post post = Post.builder().title(dto.getTitle()).content(dto.getContent()).build();
		return post; 
	}

}
