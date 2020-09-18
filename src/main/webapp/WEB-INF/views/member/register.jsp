<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layout/Header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cancle").on("click", function(){
				
				location.href = "<c:url value='/listPage'/>";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#m_id").val()==""){
					alert("아이디를 입력해주세요.");
					$("#m_id").focus();
					return false;
				}
				if($("#m_pw").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#m_pw").focus();
					return false;
				}
				if($("#m_name").val()==""){
					alert("성명을 입력해주세요.");
					$("#m_name").focus();
					return false;
				}
				if($("#m_email").val()==""){
					alert("이메일을 입력해주세요.");
					$("#m_email").focus();
					return false;
				}
			});
			
				
			
		})
	</script>
	<body>
		<div id="container">
			<form action="/kjw/register" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="m_id">아이디</label>
					<input class="form-control" type="text" id="m_id" name="m_id" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="m_pw">패스워드</label>
					<input class="form-control" type="password" id="m_pw" name="m_pw" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="m_name">성명</label>
					<input class="form-control" type="text" id="m_name" name="m_name" />
				</div>
					<div class="form-group has-feedback">
					<label class="control-label" for="m_email">이메일</label>
					<input class="form-control" type="text" id="m_email" name="m_email" />
				</div>
				
				<div class="form-group has-feedback">
					<input class="btn btn-success" type="submit" id="submit" value="회원가입">
					<button class="cancle btn btn-danger" type="button">취소</button>
				</div>
			</form>
		</div>

</body>
</html>