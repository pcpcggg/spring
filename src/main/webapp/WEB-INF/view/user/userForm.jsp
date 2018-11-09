<%@page import="kr.or.ddit.user.util.model.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.util.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
	.ui-datepicker-trigger {float: left; width: 46px; padding-left: 10px;}
	#datepicker { float: left;}}
</style>
<script>

	$(document).ready(function(){
		// 개발 과정에서 사용한 기본 값 설정
		$("#userId").val();
		$("#name").val("testUserId");
		$("#addr1").val("대전 중구 중앙로 76");
		$("#addr2").val("영민빌딩 2층 대덕인재개발원");
		$("#zipcd").val("34940");
		$("#datepicker").val("2018-08-08");
		$("#email").val("newUser@gmail.com");
		$("#tel").val("0422228202");
		$("#pass").val("pass1234");
		
		// 주소검색 버튼 이벤트 핸들러
		$("#addrSearcBtn").click(function(){
			// 주소 검색 버튼 클릭이벤트가 발생 했을때 실행
			new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            console.log(data);
		            // 주소  : roadAddress
		            // 상세주소 : ""
		            // 우편번호 : zonecode
		            
		            // 주소 input value 설정 : data.roadAddress
		            // 우편번호 input value 설정: data.zonecode
		            $("#addr1").val(data.roadAddress);
		            $("#zipcd").val(data.zonecode);
		        }
		    }).open();
		});
	});
	
	
	$( function() {
	    $( "#datepicker" ).datepicker({
	      showOn: "button",
	      buttonImage: "/images/calendar.gif",
	      buttonImageOnly: true,
	      buttonText: "Select date",
	      changeYear : true,
	      changeMonth : true,
	      yearRange : "1930:2020",
	      dateFormat: "yy-mm-dd"
	    });
	  } );
	
</script>


			<div class="row">
	<div class="col-sm-8 blog-main">
		<form class="form-horizontal" role="form" method="post" action="/user/userForm" enctype="multipart/form-data">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<input name="profilePic" type="file" placeholder="첨부파일">
						</div>
					</div>
		
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="userId" name="userId" placeholder="사용자 아이디">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 암호</label>
						<div class="col-sm-10">
							<input type="password" class=" form-control" id="pass" name="pass" placeholder="암호를 입력하세요.">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="name" name="name" placeholder="이름">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10" >
							<input style="width: 80%; float: left;" type="text" class=" form-control" id="addr1" name="addr1" placeholder="주소" readonly="readonly">
							<button id="addrSearcBtn" type="button" class="btn btn-default" style=" float: right; margin-left: 20px">주소 검색</button>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="addr2" name="addr2" placeholder="상세주소">
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="zipcd" name="zipcd" placeholder="우편번호" readonly="readonly">
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<input id="datepicker" type="text" class=" form-control" name="birth" placeholder="생년월일" style="width: 90%" readonly="readonly">
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="email" name="email" placeholder="이메일">
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="tel" name="tel" placeholder="연락처">
						</div>
					</div>
					
			
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">사용자 등록</button>
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