<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${pageList}" var="pv" varStatus="status"  >
	<tr class="userClick">
		<td>${pv.rnum}</td>
		<td>${pv.prod_id}</td>
		<td>${pv.lprod_nm}</td>
		<td>${pv.prod_name}</td>
		<td><fmt:formatDate value="${pv.prod_insdate}" pattern="yyyy-MM-dd"/></td>
	</tr>
</c:forEach>