<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String result = "";
result = (String) request.getAttribute("save"); 
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
body {
    /* The image used */
  /*  background-image: url("access/img/bg/bg-index.jpg"); */
	background-color : #f6f6f6;
    /* Full height */
    height: 100%; 
     margin: 0;


    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
.require-red{
    display: inline;
    color: red;
}



</style>
<jsp:include page="../../Template/Header.jsp"></jsp:include>
<title>ReFinder</title>
</head>

<body>

	<jsp:include page="../../Template/manu.jsp"></jsp:include>
	<!-- Modal that pops up when you click on "New Message" -->

	<div class="w3-main" style="margin-left: 400px;">

		<i
			class="fa fa-bars w3-button w3-white w3-hide-large w3-xlarge w3-margin-left w3-margin-top"
			onclick="w3_open()"></i>

<div class="w3-modal-content w3-animate-zoom w3-card " style="background-color: #0193d7" >
<h1 style="font-style: italic; color: white;" align="center">เก็บข้อมูล</h1>
<h2 align="center" style="color: red;">*<span style="color:white;">กรุณากรอกข้อมูลที่เป็นจริงเพื่อประโยชน์แก่ตัวท่านเอง</span></h2>

</div>


<%if(result.equals("1")){ %>
<div class="w3-modal-content w3-card w3-animate-bottom" >
<jsp:include page="FormHistory/PageHistory.jsp"></jsp:include>
</div>
<%} else if  (result.equals("2")){ %>

<jsp:include page="FormHistory/PageHistory2.jsp"></jsp:include>


<%} else if  (result.equals("3")){ %>

<jsp:include page="FormHistory/PageHistory3.jsp"></jsp:include>


<%} else if  (result.equals("4")){ %>

<jsp:include page="FormHistory/PageHistory4.jsp"></jsp:include>


<%} %>


<!-- end class -->
	</div>

	<jsp:include page="../../Template/Footer.jsp"></jsp:include>
</body>
	
	
</html>