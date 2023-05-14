package com.nuri.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Getter
// @Setter
// @Data : Getter, Setter 한번에 만들기
// @AllArgsConstructor : 전체 생성자 만들기
// @NoArgsConstructor : 빈 생성자 만들기
// @RequiredArgsConstructor : final 붙은 필드의 생성자를 만들어 줌
// @Builder : 

@Data
@NoArgsConstructor
public class Member {
	
	// 필드
	private  int id;
	private  String username;
	private  String password;
	private  String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
}
