package com.cos.post.domain.user;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cos.post.domain.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor //디펄트 생성자 만드는용도
@AllArgsConstructor //풀 생성자 만드는 용도
@Builder
@Data //get,set자동설정
@Entity //테이블생성
public class User {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@Column(unique = true)
	private String username;
	private String password;
	private String email;
	private String role; //권한용
	
	
	@JsonIgnoreProperties({"user"})//현재 무한루프상태이므로 이렇게 무시하고싶은 변수명을 적어준다
	//아래와 같이 선언함으로서 자신이 연관관계의 주인이 아님을 알림.테이블에 해당컬럼을 안만든다.
	@OneToMany(mappedBy = "user")//Post오브젝트(Many쪽 변수)의 user변수 넣어줌
	private List<Post> posts;

}
