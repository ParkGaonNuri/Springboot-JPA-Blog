package com.nuri.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nuri.blog.model.User;

// JpaRepository는 User 테이블을 관리하는 Repo이고, User 테이블의 Primary key는 Integer
// JSP로 치면 DAO
// 자동으로 bean 등록이 됨 @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	
	
	
	
	
	
	// JPA Naming 쿼리 
	
	// native query 만드는 
	// SELECT * FROM user WHERE username = ?1 AND password = ?2;
	// User findByUsernameAndPassword(String username, String password);
	
//	@Query(value="SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//	User login(String username, String Password);

}
