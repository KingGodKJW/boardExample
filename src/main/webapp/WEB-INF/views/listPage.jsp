<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/views/layout/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<style>
.pagination {
	justify-content: center;
}
</style>
</head>
<body>
	
	
	<div class="container">
		<div class="row">
			<div class="col-md-11"><h2>게시판</h2></div>
			<div class="col-md-1 text-right">
				<!-- perPageNum의 값을 정하는 select 박스, 페이지당 보여줄 수  -->
				<select class="form-control" id="perPageSel">
					<option value="10">10</option>
					<option value="15">15</option>
					<option value="20">20</option>
				</select>
			</div>
		</div>
		<form id="boardForm" name="boardForm" method="post">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="result" items="${list }" varStatus="status">
						<tr>
							<td><c:out value="${result.id }" /></td>
							<td><a
								href='<c:url value='/board/boardView.do'/>${pg.makeQuery(pg.vo.page)}&id=${result.id}'><c:out
										value="${result.title }" /> </a>
							<c:if test="${result.reg_datetime>=nowday}">
									<img src="image/ico_new.gif">
								</c:if></td>
							<td><c:out value="${result.writer }" /></td>
							<td><c:out value="${result.reg_datetime }" /></td>
							<td><c:out value="${result.view_cnt}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
				<a href='#' onClick='fn_write()' class="btn btn-primary pull right">글쓰기</a>
				<a href='<c:url value='/listPage'/>' class="btn btn-warning">처음목록</a>
			</div>
		</form>

		<div class="text-center">
			<nav aria-label="pagination">
				<ul class="pagination">

					<!-- prev 버튼 -->
					<li class="page-item" id="page-prev"><a class="page-link"
						href="listPage${pg.makeQuery(pageMaker.startPage-1)}">
							Previous </a></li>

					<!-- 페이지 번호 (시작 페이지 번호부터 끝 페이지 번호까지) -->
					<c:forEach begin="${pg.startPage}" end="${pg.endPage}" var="idx">
						<li class="page-item" id="page${idx}"><a class="page-link"
							href="listPage${pg.makeQuery(idx)}"> <span>${idx}</span>
						</a></li>
					</c:forEach>

					<!-- next 버튼 -->
					<li class="page-item" id="page-next"><a class="page-link"
						href="listPage${pg.makeQuery(pg.endPage + 1)}"> Next </a></li>

				</ul>
			</nav>
		</div>

		<div class="form-group row justify-content-center">

			<div class="w100" style="padding-right: 10px">

				<select class="form-control form-control-sm" name="searchType"
					id="searchType">

					<option value="title" selected="selected">제목</option>

					<option value="content">본문</option>

					<option value="writer">작성자</option>

				</select>

			</div>

			<div class="w300" style="padding-right: 10px">

				<input type="text" class="form-control form-control-sm"
					name="keyword" id="keyword">

			</div>

			<div>

				<button class="btn btn-sm btn-primary" name="btnSearch"
					id="btnSearch">검색</button>

			</div>

		</div>




		<script>
			//글쓰기
			function fn_write() {

				var form = document.getElementById("boardForm");

				form.action = "<c:url value='/board/writeForm.do'/>";
				form.submit();

			}

			/*
			//글조회
			function fn_view(id){
			   
			   var form = document.getElementById("boardForm");
			   var url = "<c:url value='/board/boardView.do'/>";
			   url = url + "?id=" + id;
			   
			   form.action = url;    
			   form.submit(); 
			}
			 */
			$(function() {
				setPerPageNumSelect();
				setSearchType();
				//prev 버튼 활성화, 비활성화 처리
				var canPrev = '${pg.prev}';
				if (canPrev !== 'true') {
					$('#page-prev').hide();
				}

				//next 버튼 활성화, 비활성화 처리
				var canNext = '${pg.next}';
				if (canNext !== 'true') {
					$('#page-next').hide();
				}

				//현재 페이지 파란색으로 활성화
				var thisPage = '${pg.vo.page}';
				$('#page' + thisPage).addClass('active');
			})
			function setPerPageNumSelect() {
				var perPageNum = "${pg.vo.perPageNum}";
				var $perPageSel = $('#perPageSel');
				var thisPage = '${pg.vo.page}';
				$perPageSel.val(perPageNum).prop("selected", true);
				//PerPageNum가 바뀌면 링크 이동
				$perPageSel.on('change', function() {
					//pageMarker.makeQuery 사용 못하는 이유: makeQuery는 page만을 매개변수로 받기에 변경된 perPageNum을 반영못함
					window.location.href = "listPage?page=" + thisPage
							+ "&perPageNum=" + $perPageSel.val();
				})
			}
			function setSearchType() {
				var $searchType = $('#searchType');
				var $keyword = $('#keyword');

				//$searchType.val('${pg.vo.searchType}').prop("selected",true);

				//검색 버튼이 눌리면
				$('#btnSearch').on(
						'click',
						function() {
							console.log('클릭버튼 눌림');
							var searchTypeVal = $searchType.val();
							var keywordVal = $keyword.val();

							//검색어 입력 안했으면 검색창
							if (!keywordVal) {
								alert("검색어를 입력하세요!");
								$('#keyword').focus();
								return;
							}
							var url = "listPage?page=1" + "&perPageNum="
									+ "${pg.vo.perPageNum}" + "&searchType="
									+ searchTypeVal + "&keyword="
									+ encodeURIComponent(keywordVal);
							window.location.href = url;
						})
			}
		</script>
	</div>
</body>
</html>