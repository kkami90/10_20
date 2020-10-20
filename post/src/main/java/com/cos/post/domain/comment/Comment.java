package com.cos.post.domain.comment;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cos.post.domain.post.Post;
import com.cos.post.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor //디펄트 생성자 만드는용도
@AllArgsConstructor //풀 생성자 만드는 용도
@Builder
@Data //get,set자동설정
@Entity //테이블생성
public class Comment {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String content;
	@JoinColumn(name="postId")
	@ManyToOne
	private Post post;
	
	@JoinColumn(name="userId")
	@ManyToOne
	private User user;
	
}
