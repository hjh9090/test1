<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>로그아웃</title>
<script>

function goHome() {
	
	location.href = "/test1";
}


</script>
</head>
<body>


<h1>로그아웃 되었습니다.</h1>

<input type = "button" value = "홈으로 돌아가기" onclick="goHome()">



</body>
</html>