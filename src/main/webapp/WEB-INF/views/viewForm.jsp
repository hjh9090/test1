<%@page import="org.springframework.web.bind.annotation.ResponseBody"%>
<%@page import="org.springframework.web.bind.annotation.GetMapping"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원 정보 출력란</title>
<script src="resources/jq/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script>

$(document).ready(function () {
	$.ajax ({
		url:"viewForm",
		type:"GET",
		data:"${sessionScope.access}",
		success : function(res) {
			
			console.log(res);
		}//access_token값 실시간으로 갱신 가능

	
	});
});


</script>
</head>
<body>
	
	
	
</body>
</html>