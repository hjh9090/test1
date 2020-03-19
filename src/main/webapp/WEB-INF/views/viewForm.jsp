<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원 정보 출력란</title>
<script src="resources/jq/jquery-3.4.1.min.js"></script>
<script>

$(document).ready(function () {
	$.ajax ({
		url:"viewForm",
		type:"GET",
		data:"${sessionScope.access}",
		success : function(res) {
			
			console.log(res);
			
			
		}
	});
});


</script>
</head>
<body>
<% 


%>

	
	
	
</body>
</html>