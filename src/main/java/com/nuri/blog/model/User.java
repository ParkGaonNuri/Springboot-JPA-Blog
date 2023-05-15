package com.nuri.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Builder 패턴
@Entity // User 클래스가 자동으로 MySQL에 테이블 생성 // ORM -> Java Object -> 테이블로 매핑해주는 기술
@DynamicInsert // insert할 때 null인 필드 제외
public class User {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY: 프로젝트에서 연결된 DB의 넘버링 전략을 따라감
	private int id; // auto_increment, 시퀀스
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100) // 123456 => 해쉬(비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; //Enum을 쓰는게 좋음 // admin, user, manager // 도메인 = 범위
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;

}
