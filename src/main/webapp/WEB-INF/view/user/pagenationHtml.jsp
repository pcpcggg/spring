<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<li>
	<a href="javascript:getUserList(1);" aria-label="Previous">
		<span aria-hidden="true">&laquo;</span>
	</a>
</li>

<c:forEach var="page"  varStatus="status" begin="1" end="${pageCnt}">

	<li><a href="javascript:getUserListHtml(${status.index});">${status.index}</a></li>
</c:forEach>

<li>
	<a href="javascript:getUserList(1);" aria-label="Next">
  		<span aria-hidden="true">&raquo;</span>
  	</a>
</li>