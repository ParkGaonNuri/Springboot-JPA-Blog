package com.nuri.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//스프링이 com.nuri.blog 패키지 이하를 스캔해서 모든 파일을 메모리에 new하는 것은 아니고
//특정 어노테이션이 붙어있는 클래스 파일들을 new해서(IoC) 스프링 컨테이너에서 관리

// 사용자가 요청 -> 응답(HTML 파일) @Controller
// 사용자가 요청 -> 응답(Data) @RestController

@RestController
public class HttpControllerTest {
	// ctrl + d = 줄 복사
	
	// 인터넷 브라우저 요청은 오직 get 밖에 할 수 없음
	// http://localhost:8080/http/get (select)
//	@GetMapping("/http/get")
//	public String getTest(@RequestParam int id, @RequestParam String username) {
//		return "get 요청: "+ id + ", " + username;
//	}
	
	private static final String TAG = "HttpControllerTest : ";
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
		System.out.println(TAG + "getter : " + m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG + "setter : " + m.getUsername());
		return "lombok test 완료";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) { // http://localhost:8080/http/get?id=1&username=ssar&password=1234&email=ssar@nate.com // MessageConverter (스프링부트)
		return "get 요청: "+ m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/post (insert)
	@PostMapping("/http/post") // text/plain, application/json
	public String postTest(@RequestBody Member m) { // MessageConverter (스프링부트)
		return "post 요청: "+ m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}

}
