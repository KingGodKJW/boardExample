<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	
	
	
	<c:if test="${not empty member}">
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
	<a class="navbar-brand" href="#">${member.m_name}님 반갑습니다.</a>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">

    <span class="navbar-toggler-icon"></span>

  </button>



  <div class="collapse navbar-collapse" id="navbarsExample03">

    <ul class="navbar-nav mr-auto">

      <li class="nav-item active">

        <a class="nav-link" href="/kjw/listPage">Board <span class="sr-only">(current)</span></a>

      </li>

      <li class="nav-item">

        <a class="nav-link" href="/kjw/member/logout">로그아웃</a>

      </li>


    </ul>

    <form class="form-inline my-2 my-md-0">

      <input class="form-control" type="text" placeholder="Search">

    </form>

  </div>

</nav>
	
	
	
	</c:if>
	
	<c:if test="${empty member}">
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="#">KJW Board HomePage</a>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">

    <span class="navbar-toggler-icon"></span>

  </button>



  <div class="collapse navbar-collapse" id="navbarsExample03">

    <ul class="navbar-nav mr-auto">

      <li class="nav-item active">

        <a class="nav-link" href="/kjw/listPage">Board <span class="sr-only">(current)</span></a>

      </li>

      <li class="nav-item">

        <a class="nav-link" href="/kjw/member/login">로그인</a>

      </li>
      
      <li class="nav-item">
      
      	<a class="nav-link" href="/kjw/register">회원 가입</a>
      </li>


    </ul>

    <form class="form-inline my-2 my-md-0">

      <input class="form-control" type="text" placeholder="Search">

    </form>

  </div>

</nav>
</c:if>
