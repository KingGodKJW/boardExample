<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="/WEB-INF/views/layout/Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login form</title>

<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cancle").on("click", function(){
				
				location.href = "/kjw/listPage";
						    

	</script>
</head>
<body>
<div id="container">
			<form action="/kjw/login" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="m_id">아이디</label>
					<input class="form-control" type="text" id="m_id" name="m_id" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="m_pw">패스워드</label>
					<input class="form-control" type="password" id="m_pw" name="m_pw" />
				</div>
				
				<div class="form-group has-feedback">
					<input type="submit" class="btn btn-success" type="submit" id="submit" value="로그인">
					<button class="cancle btn btn-danger" type="button">취소</button>
				</div>
			</form>
		</div>
		
		<script type="text/javascript">
		var msg = "${msg}";
		
		if(msg==="Success"){
			alert("회원가입 완료.");
		}else if(msg==="fail"){
			alert("회원정보 불일치");
		}
		
		</script>
</body>
</html>