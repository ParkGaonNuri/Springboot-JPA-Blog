let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{ // function(){} 가 아닌 ()=>{}를 쓰는 이유는 this를 바인딩하기 위해서
			this.save();
		});
	},
	save: function() {
		//alert('user의 save함수 호출');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		//console.log(data); -> 자바스크립트 오브젝트
		//console.log(JSON.stringify(data)); -> JSON 문자열
		
		// ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		// ajax호출 시 default가 비동기 호출
		$.ajax({
			type:"POST",
			url: "/blog/api/user",
			data: JSON.stringify(data), // http body 데이터
			contentType: "application/json; charset=utf-8", // body 데이터가 어떤 타입인지(MIME)
			dataType: "json" // 서버로부터 응답이 왔을 때 기본적으로 모든 것이 문자열(String) 이지만 생긴 게 JSON이라면 JavaScript로 변환 
		}).done(function(resp){
			// 성공하면 done
			alert("회원가입이 완료되었습니다.");
			//alert(resp);
			console.log(resp);
			//location.href = "/blog";
		}).fail(function(error){
			// 실패하면 fail
			alert(JSON.stringify(error));
		}); 
	}
}

index.init();