package com.nuri.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; //썸머노트 라이브러리 : <html> 태그가 섞여서 디자인 됨
	
	@ColumnDefault("0")
	private int count; //조회수
	
	@ManyToOne // Many = Board, One = User 한 명의 유저는 여러 개의 게시글을 쓸 수 있음 // OneToOne, OneToMany 등
	@JoinColumn(name="userId")
	private User user; //DB는 오브젝트를 저장할 수 없다(Foreign key 사용). 자바는 ORM 덕분에 오브젝트를 저장할 수 있다.
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy : 연관 관계의 주인이 아님(난 FK가 아님). DB에 칼럼을 만들지 마세요
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;

}
