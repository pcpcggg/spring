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
			var userId = $(this).children()[1].innerHTML;
			
			$("#userId").val(userId);
			$("#frm").submit();
		});
	});
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
				<tr>
					<th>번호</th>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>생일</th>
				</tr>
				<%--
				<%
					List<UserVo> userList = (List<UserVo>)request.getAttribute("pageList");
					
					
				
					for(UserVo uv : userList ){
						DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date nowDate = new Date();
						String tempDate = sdFormat.format(uv.getBirth());	
				%>
					<tr class="userClick">
						<td><%= uv.getRnum() %></td>
						<td><%= uv.getUserId() %></td>
						<td><%= uv.getName() %></td>
						<td><%= tempDate %></td>
					</tr>
				
				<%} %>
				 --%>
				<c:forEach items="${pageList}" var="uv" varStatus="status"  >
					<tr class="userClick">
						<td>${uv.rnum}</td>
						<td>${uv.userId}</td>
						<td>${uv.name}</td>
						<td><fmt:formatDate value="${uv.birth}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>

			</table>
		</div>

		<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href=""><<</a></li>
				<li>
					<a href="/userPageList?page=1&pageSize=10" aria-label="Previous">
        				<span aria-hidden="true">&laquo;</span>
      				</a>
      			</li>
				<%--
					int pagetCnt = (Integer)request.getAttribute("pageCnt");
					int pageSize = 11;
					for(int pageNum =1; pageNum <= userList.size() ; pageNum++){ 
				%>
						<li><a href="userPageList?page=<%=pageNum%>&pageSize=<%=pageSize%>"><%=pageNum%></a></li>
				<%	} --%>
				<c:set var="pageNum" value="${pageCnt}"/>
				<c:set var="pageSize" value="11"/>
				<c:forEach items="${pageList}" var="page"  varStatus="status">
					<li><a href="userPageList?page=${status.index+1}&pageSize=${pageSize}">${status.index+1}</a></li>
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