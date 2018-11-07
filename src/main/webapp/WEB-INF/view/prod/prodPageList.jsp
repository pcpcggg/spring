<%@page import="kr.or.ddit.user.util.model.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.util.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.DecimalFormat"%>

<%@include file="/WEB-INF/view/common/header.jsp"%>
<%@include file="/WEB-INF/view/common/left.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>



<script>
	$(document).ready(function(){
		console.log("123");
		// tr에 select (class = "userCilck")
		
		$(".userClick").on("click", function(){
			console.log("1234");
			var prodId = $(this).children()[1].innerText;
			
			$("#prodId").val(prodId);
			$("#frm").submit();
		});
	});
</script>

<style>
.userClick {cursor: pointer;}
.userClick:hover { background: #ccc !important;}
</style>

<form action="/prodDetail" method="get" id="frm" >
	<input type="hidden" id="prodId" name="prodId"/>
</form>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자 userPageList</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>번호</th>
					<th>상품 아이디</th>
					<th>상품 이름</th>
					<th>상품 카테고리</th>
					<th>구매 날자</th>
				</tr>
				
				<c:forEach items="${pageList}" var="pv" varStatus="status"  >
					<tr class="userClick">
						<td>${pv.rnum}</td>
						<td>${pv.prod_id}</td>
						<td>${pv.lprod_nm}</td>
						<td>${pv.prod_name}</td>
						<td><fmt:formatDate value="${pv.prod_insdate}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>

			</table>
		</div>

		<a class="btn btn-default pull-right" href="/userForm">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href=""><<</a></li>
				<li>
					<a href="/userPageList?page=1&pageSize=10" aria-label="Previous">
        				<span aria-hidden="true">&laquo;</span>
      				</a>
      			</li>
			
				<c:set var="pageNum" value="${pageCnt}"/>
				<c:set var="pageSize" value="10"/>
				<c:forEach items="${pageList}" var="page"  varStatus="status" begin="1" end="${pageCnt}">
					<li><a href="prod?page=${status.index}&pageSize=${pageSize}">${status.index}</a></li>
				</c:forEach>
	
				<li>
					<a href="" aria-label="Next">
        				<span aria-hidden="true">&raquo;</span>
      				</a>
				</li>
				<li><a href="">>></a></li>
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