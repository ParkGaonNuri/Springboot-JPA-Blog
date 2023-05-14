package com.nuri.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller는 파일을 return
@Controller
public class TempControllerTest {
	
	// http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// 파일 리턴 기본 경로: src/main/resources/static에 있는 home.html을 리턴해라
		// 리턴명을 /home.html이라고 해야 src/main/resources/static/home.html로 인식함
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/a.jpg";
	}
	
	// static은 브라우저가 인식할 수 있는 정적 파일만 배치 가능
	// jsp는 정적인 파일이 아니기 때문에 'not found' 에러가 발생
	@GetMapping("/temp/jsp")
	public String tempjsp() {
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// 풀네임 : /WEB-INF/views/test.jsp
		return "test";
	}

}
