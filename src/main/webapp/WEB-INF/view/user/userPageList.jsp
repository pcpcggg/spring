<%@page import="kr.or.ddit.user.util.model.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.util.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.DecimalFormat"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>



<script>

$(document).ready(function(){
	console.log("123");
	// tr에 select (class = "userCilck")
	
	$("#userList").on("click", ".userClick", function(){
		console.log("1234");
		var userId = $(this).children()[1].innerHTML;
		
		$("#userId").val(userId);
		$("#frm").submit();
	
	});
	//getUserList(1);
	getUserPagenationHtml(1);
	getUserListHtml(1);
	
});


function getUserListHtml(page) {
	var pageSize = 10;
	
	$.ajax({
		url : "/user/userPageListAjaxHtml",
		type : "get",
		data : "page="+page+"&pageSize="+pageSize,
		success : function(dt){
			$("#userList").html(dt);
		}
	});
}	

function getUserPagenationHtml(page) {
	var pageSize = 10;
	$.ajax({
		url : "/user/userPagenationAjaxHtml",
		type : "get",
		data : "page="+page+"&pageSize="+pageSize,
		success : function(dt){
			$(".pagination").html(dt);
		}
	});
}
//page인자 를 받아서
//해당페이지에 속하는 사용자 리스트 정보를 가져온다.
function getUserList(page) {
	var pageSize = 10;
	
	console.log("page : " + page);
	
	//ajax call
	//사용자 리스트 데이터만 가져오기
	//html(as-is) --> json(to-be) 데이터를 받는 형태로 변경
	
	$.ajax({
		type : "GET",
		url : "/user/userPageListAjax",
		data : "page="+page +"&pageSize="+pageSize,
		success : function(data) {
			// data(사용자 json 데이터)를 바탕으로
			// 사용자 리스트를 갱신
			// 1.기존 리스트를 삭제
			// 2.data를 이용하여 table 태그(tr)를 작성
			// 3.기존 리스트 위치에다가 붙여넣기
			console.log(data);
			
			var html ="";
			var htmlPage = "";
				
			$.each(data.pageList, function(idx, user) {
				console.log(user);
				html += "<tr class='userClick'>";
				html += "<td>"+user.rnum+"</td>";
				html += "<td>"+user.userId+"</td>";
				html += "<td>"+user.name+"</td>";
				html += "<td>"+user.formattedBirth+"</td>";
				html += "</tr>";
				
			});
			
			for(var i = 1; i <= data.pageCnt; i++){
				htmlPage += "<li><a href='javascript:getUserList(" + i + ");'>" + i +"</a></li>";
			}
			
			var pre = "<li><a href='javascript:getUserList(1);' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
			var next = "<li><a href='javascript:getUserList("+ data.pageCnt +");' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>"
			
			$("#userList").html("");
			$("#userList").html(html);
			$(".pagination").html("");
			$(".pagination").html(pre + htmlPage + next);
			
		}
	});
	
}
	
</script>

<style>
.userClick {cursor: pointer;}
.userClick:hover { background: #ccc !important;}
</style>

<form action="/user/userDetail" method="get" id="frm" >
	<input type="hidden" id="userId" name="userId"/>
</form>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자 userPageList</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>사용자 아이디</th>
						<th>사용자 이름</th>
						<th>생일</th>
					</tr>
				</thead>
				<tbody id="userList">
					<c:forEach items="${pageList}" var="uv" varStatus="status"  >
						<tr class="userClick">
							<td>${uv.rnum}</td>
							<td>${uv.userId}</td>
							<td>${uv.name}</td>
							<td><fmt:formatDate value="${uv.birth}" pattern="yyyy-MM-dd"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<%--
				<li><a href=""><<</a></li>
				
				<li>
					<a href="javascript:getUserList(1);" aria-label="Previous">
        				<span aria-hidden="true">&laquo;</span>
      				</a>
      			</li>
				
				
				<li>
					<a href="/userPageList?page=1&pageSize=10" aria-label="Previous">
        				<span aria-hidden="true">&laquo;</span>
      				</a>
      			</li>
				
				 
				<c:set var="pageNum" value="${pageCnt}"/>
				<c:set var="pageSize" value="10"/>
				
				
				<c:forEach items="${pageList}" var="page"  varStatus="status">
					<li><a href="javascript:getUserList(${status.index+1});">${status.index+1}</a></li>
				</c:forEach>
				
				
				<c:forEach items="${pageList}" var="page"  varStatus="status">
					<li><a href="userPageList?page=${status.index+1}&pageSize=${pageSize}">${status.index+1}</a></li>
				</c:forEach>
				
				<li>
					<a href="javascript:getUserList(1);" aria-label="Next">
        				<span aria-hidden="true">&raquo;</span>
      				</a>
				</li>
				<li><a href="">>></a></li>
				--%>
			</ul>
		</div>
	</div>
</div>
			
		</div>
	</div>
	<!-- /.blog-main -->
	</div>
</body>
</html>