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

<style>
	.ui-datepicker-trigger {float: left; width: 46px; padding-left: 10px;}
	#datepicker { float: left;}}
</style>
<script>

	$(document).ready(function(){
		
		
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
	
	
	// 실시간 이미지 섬네일 변경
	function imageView1(e){
		var file = e.target.files;
		var fileArr = Array.prototype.slice.call(file);	
		var fileValue = $("#input_img1").val().split("\\");
		var fileName = fileValue[fileValue.length-1]; // 파일명
		fileArr.forEach(function(f){
			if(!f.type.match("image.*")){
				alert('미리보기는 이미지 파일만 가능합니다.');
				return;
			}
			if(fileName != "" ){
				$("#btn_delAttach").show();
				
			}else{
				$("#btn_delAttach").hide();
			}
			sel_file=f;
			
			var reader = new FileReader();
			reader.onload = function(e){
				$("#img1").attr('src',e.target.result);
			}
			reader.readAsDataURL(f);
		});
	}
	
	
	// 이미지 체인지
	$(function(){
		$('#input_img1').on("change",imageView1);
	}); 
	
	
	
	
	// 이미지 경로 비우기 
	
	$(document).ready(function(){
		$("#btn_delAttach").click(function(){
			$("#input_img1").val("");
			$("#img1").attr('src','/profile/243FE450575F82662D.png')
			$("#btn_delAttach").hide();
		});
		
	});
	
	
	// 파일 리셋 버튼 히든 처리
	$(document).ready(function(){
		$("#btn_delAttach").hide();
	});

</script>




			<div class="row">
	<div class="col-sm-8 blog-main">
		<form class="form-horizontal"  method="post" action="/user/userUpdate" enctype="multipart/form-data">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<div class="col-sm-10_left">
								<h2> 현재 프로필 이미지</h2>
								<c:choose>
									<c:when test="${userVo.profile == null}">
										<img src="/profile/no_image.png" width="300px;"/>
									</c:when>
									<c:otherwise>
										<img src="${userVo.profile}" width="300px;"/>
									</c:otherwise>
								</c:choose>
								
							</div>
							<div class="col-sm-10_right">
								<h2> 변경 될 프로필 이미지</h2>
								<img id="img1" src="/profile/243FE450575F82662D.png" />
								
							</div>
							<input name="profilePic" type="file" placeholder="첨부파일" id="input_img1" >
							<button type="button" id="btn_delAttach">X</button>
						</div>
					</div>
		
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="userId" name="userId" placeholder="사용자 아이디" readonly="readonly" value="${userVo.userId}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 암호</label>
						<div class="col-sm-10">
							<input type="password" class=" form-control" id="pass" name="pass" placeholder="암호를 입력하세요."  value="${userVo.pass}"/>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="name" name="name" placeholder="이름" value="${userVo.name}">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10" >
							<input style="width: 80%; float: left;" type="text" class=" form-control" id="addr1" name="addr1" placeholder="주소" readonly="readonly" value="${userVo.addr1}">
							<button id="addrSearcBtn" type="button" class="btn btn-default" style=" float: right; margin-left: 20px">주소 검색</button>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="addr2" name="addr2" placeholder="상세주소" value="${userVo.addr2}">
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="zipcd" name="zipcd" placeholder="우편번호" readonly="readonly" value="${userVo.zipcd}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<input id="datepicker" type="text" class=" form-control" name="birth" placeholder="생년월일" style="width: 90%" readonly="readonly" value="<fmt:formatDate value="${userVo.birth}" pattern="yyyy-MM-dd"/>">
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="email" name="email" placeholder="이메일" value="${userVo.email}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<input type="text" class=" form-control" id="tel" name="tel" placeholder="연락처" value="${userVo.tel}">
						</div>
					</div>
					
			
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-default" value="수정 완료">
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