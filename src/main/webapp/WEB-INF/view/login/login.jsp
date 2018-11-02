<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="http://getbootstrap.com/favicon.ico">
<!-- Bootstrap core CSS -->
<link href="http://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="http://getbootstrap.com/docs/4.1/examples/sign-in/signin.css" rel="stylesheet">

<title>Insert title here</title>
<style type="text/css">
	ul { list-style: none;}
	li span { width: 65px; display:inline-block; margin-bottom: 5px;}
	
	
</style>
<%@include file="/common/basicLib.jsp" %>

<script type="text/javascript">

	$(document).ready(function(){
		console.log("test");
		//remember 쿠키값이 y이면
		
		if(getCookie("remember") == "Y"){
			//remember-me 체크박스 체크
			$("#idSaveCheck").attr("checked", true);
			// userId input value를 userId 쿠키 값으로 설정
			$("#userId").val(getCookie("userId"));
		}else{
			$("#idSaveCheck").attr("checked", flase);
		}
		
	});
		/*	
		
		var userInputId = getCookie("userId");
	    $("input[name='userId']").val(userInputId); 
	    
	    if($("input[name='userId']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
	        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
	    }
	    
	    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
	        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
	            var userInputId = $("input[name='userId']").val();
	            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
	        }else{ // ID 저장하기 체크 해제 시,
	            deleteCookie("userInputId");
	        }
	    });
	    
	 // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
	    $("input[name='id']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
	        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
	            var userInputId = $("input[name='userId']").val();
	            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
	        }
	    });
	    
	});
	
	
	function setCookie(cookieName, value, exdays){
	    var exdate = new Date();
	    exdate.setDate(exdate.getDate() + exdays);
	    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
	    document.cookie = cookieName + "=" + cookieValue;
	}
	 
	function deleteCookie(cookieName){
	    var expireDate = new Date();
	    expireDate.setDate(expireDate.getDate() - 1);
	    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
	}
	*/
	function getCookie(cookieName){
		var cookies = document.cookie.split("; ");
		
		var cookieValue = "";
		for(var i = 0; i< cookies.length; i++){
			var str = cookies[i];
			if(str.startsWith(cookieName +"="))
				cookieValue = str.substring((cookieName + "=").length);
		}
		return cookieValue;
	}
	
	
</script>

</head>
<body>
	<%-- 브라우저 주소줄에 입력한경우 : get
		 form 태그의 method 속성 : get/post
	 --%>
	

	<form class="form-signin" style="text-align: center;" method="post" action="/user/loginProcess">
      <img class="mb-4" src="http://getbootstrap.com/docs/4.1/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label class="sr-only">아이디</label>
      <input type="text" name="userId" id="userId" class="form-control" placeholder="아이디를 넣어주세요." required autofocus>
      <label class="sr-only">암호</label>
      <input type="password" name="pass" id="inputPassword" class="form-control" placeholder="암호를넣어주세요." required>
      
      <div class="checkbox" style="text-align: left;">
         <label>
           <input type="checkbox" value="remember-me" name="remember-me"  id="idSaveCheck"> 아이디 기억하기
         </label>
       </div>
  
      <input class="btn btn-lg btn-primary btn-block"  type="submit" value="로그인">
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>

     
	
</body>
</html>