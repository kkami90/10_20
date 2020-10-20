package com.cos.post.domain.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cos.post.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String title;
	@Column(length = 100000)
	private String content;
	private int readCount;
	
//	자바에서는 아래와같이 참조할값을 객체로 만들어 넣어버리면 사용이 가능하겠지만 DB에 들어갈 
//	테이블에서는 아래와같은 오브젝트를 담을수가 없기에 어노테이션을 걸어 할수있게만든다
//	아래는 자동 FK생성 기능. 추가로 포랭키의 주인은 이곳 Post기에 여기를 Many로 함.
	@ManyToOne 
	@JoinColumn(name="userId")
//	현재 User에서 무시설정을 해놓음으로서 Post에서 Select할때는 괜찮지만
//	유저에서 포스트를 볼때는 이놈이 무시된다. 그렇게 무한로딩을 방지
	private User user;

}
