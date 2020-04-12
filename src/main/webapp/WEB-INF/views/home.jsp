<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<title>Home</title>
<style type="text/css">

img
{
	width: 50px;
	height: 50px;
}

</style>
<script>

$(document).ready(function () {
	
	console.log(${requestScope.Profile});
	
})
	
</script>
</head>
<body>
<h1>
	API 로그인 실습 예제입니다. 
</h1>

<c:if test="${sessionScope.sessionId != null}">

<c:if test="${sessionScope.sessionNickname != null}">

<p>${sessionScope.sessionNickname}님 환영합니다.</p>
	<img src='${sessionScope.Profile}'>
	<form action="logout" method = "GET" >
	<input type = "submit" value = "로그아웃">
	</form>
	<form action="deleteNaver" method = "GET">
	<input type = "submit" value="회원탈퇴">
	</form>
</c:if>
<c:if test="${sessionScope.sessionNickname == null}">
	<p>${sessionScope.sessionName}님 환영합니다.</p>
	<img src='${sessionScope.Profile}'>
	<form action="logout" method = "GET" >
	<input type = "submit" value = "로그아웃">
	</form>
	<form action="deleteGoogle" method = "GET">
	<input type = "submit" value = "회원 탈퇴">
	</form>
	</c:if>
</c:if>

<c:if test="${sessionScope.sessionId == null}">

<form action="naverlogin" method = "GET">

<input type = "submit" value="네이버 로그인 페이지로 가기">

</form>

<form action="googlelogin" method = "GET">
<input type = "submit" value = "구글 로그인 페이지로 가기">

</form>

</c:if>

</body>
</html>
