<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${pageList}" var="user" varStatus="status"  >
	<tr class="userClick">
		<td>${user.rnum}</td>
		<td>${user.userId}</td>
		<td>${user.name}</td>
		<td><fmt:formatDate value="${uv.birth}" pattern="yyyy-MM-dd"/></td>
	</tr>
</c:forEach>