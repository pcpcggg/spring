<%@page import="kr.or.ddit.user.util.model.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.util.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/view/common/header.jsp"%>
<%@include file="/WEB-INF/view/common/left.jsp"%>
 
			<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>번호</th>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>생일</th>
				</tr>
				
				<c:forEach items="${userList}" var="uv" varStatus="status"  >
					<tr>
						<td>${status.index +1}</td>
						<td>${uv.userId}</td>
						<td>${uv.name}</td>
						<td><fmt:formatDate value="${uv.birth}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>

			</table>
		</div>

		<a class="btn btn-default pull-right" href="/user/userForm.jsp">사용자 등록</a>

	
	</div>
</div>
			
		</div>
	</div>
	<!-- /.blog-main -->
	</div>
</body>
</html>