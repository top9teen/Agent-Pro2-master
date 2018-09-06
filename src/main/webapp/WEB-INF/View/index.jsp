<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="access/img/logo/logo8.jpg" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="956640272040-88pnior229iloi51jvmvd1m6lneq1h1v.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<jsp:include page="../Template/Header.jsp"></jsp:include>

<style type="text/css">
body {
    /* The image used */

	background-color :#f6f6f6;
    /* Full height */
    height: 100%; 
     margin: 0;


    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}

</style>
<title>ReFinder</title>
</head>
<% String result =  ""  ; %>
<%	result = (String) request.getAttribute("msg"); %>
<body>
<%
						if (result.equals("G")) {
					%>
					<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>แบน </strong> โดนแบน 
					</div>
					
					<%
						}else if(result.equals("L")){
					%>
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<div class="alert alert-success">
						<strong>Success </strong> Logout Success
					</div>
					<%
						}else if(result.equals("F")){
					%>
					<div class="alert alert-danger">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>ผิดพลาด ! </strong> กรุณากรอก ให้ถูกต้อง !!
					</div>
					<%} %>
<jsp:include page="NormalPerson/FistPagePerson.jsp"></jsp:include>
</body>
<jsp:include page="../Template/Footer.jsp"></jsp:include>
</html>