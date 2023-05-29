<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 자바스크립트는 인터프리터 언어(위에서 순서대로 실행) -->
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">Username</label>
			<input type="text" class="form-control" placeholder="Enter Username" id="username">
		</div>
		
		<div class="form-group">
			<label for="password">Password</label>
			<input type="password" class="form-control" placeholder="Enter Password" id="password">
		</div>

		<div class="form-group">
			<label for="email">Email</label>
			<input type="email" class="form-control" placeholder="Enter Email" id="email">
		</div>

	</form>
	<button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>


