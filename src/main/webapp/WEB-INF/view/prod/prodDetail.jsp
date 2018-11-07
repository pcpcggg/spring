<%@page import="kr.or.ddit.user.util.model.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.util.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/view/common/header.jsp"%>
<%@include file="/WEB-INF/view/common/left.jsp"%>

<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.DecimalFormat"%>


			<div class="row">
	<div class="col-sm-8 blog-main">
		<form class="form-horizontal" role="form">
				
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상품 아이디</label>
						<div class="col-sm-10">
							<label for="userNm" class=" control-label">${prodVo.prod_id}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상품 이름</label>
						<div class="col-sm-10">
							<label class=" control-label">${prodVo.prod_name}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">카테고리</label>
						<div class="col-sm-10">
							<label class="control-label">${prodVo.lprod_nm}</label>
						</div>
					</div>

					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">구매 날자</label>
						<div class="col-sm-10">
							<label class=" control-label"><fmt:formatDate value="${prodVo.prod_insdate}" pattern="yyyy-MM-dd"/></label>
						</div>
					</div>
					
					<br/>
					<br/>
					
				</form>
				
				<form method="get" action="/userUpdate">
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="hidden" name="userId" value="${userVo.userId}">
							<button type="submit" class="btn btn-default">수정하기</button>
						</div>
					</div>
				</form>
	</div>
</div>
			
		</div>
	</div>
	<!-- /.blog-main -->
	</div>
</body>
</html>