<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="access/img/logo/logo8.jpg" />
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

</style>
<jsp:include page="../../Template/Header.jsp"></jsp:include>
<title>ReFinder</title>
</head>
<% String result = ""; %>
<%	result = (String) request.getAttribute("re"); %>
<body>

	<jsp:include page="../../Template/manu.jsp"></jsp:include>
	<!-- Modal that pops up when you click on "New Message" -->

	<div class="w3-main" style="margin-left: 400px;">

		<i
			class="fa fa-bars w3-button w3-white w3-hide-large w3-xlarge w3-margin-left w3-margin-top"
			onclick="w3_open()"></i>

<div class="w3-modal-content w3-animate-zoom w3-card" style="background-color: #0193d7" >
<h1 style="font-style: italic;" align="center">ระบบวิเคราะห์สินเชื่อรถยนต์</h1>
<h2 align="center" style="color: red;">*<span style="color: black;">กรุณากรอกรหัสผ่านเดิมและรหัสผ่านใหม่</span></h2>

</div>

<div class="w3-modal-content w3-card w3-animate-bottom" >
<%
						if (result.equals("G")) {
					%>
					<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>Danger </strong> กรุณาใส่รหัสให้ถูกต้อง
					</div>
					
					<%
						}else if(result.equals("L")){
					%>
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<div class="alert alert-success">
						<strong>Success </strong> สำเร็จ
					</div>
					<%
						}
					%>
				<form action="refass" name = "refass">
				<h2>เปลี่ยนรหัสผ่าน</h2>
					<div class="w3-panel">
					<label>รหัสเดิม</label> <input
						class="w3-input w3-border w3-margin-bottom" type="text"
						name="repassed">
						 <label>รหัสใหม่</label> <input
						class="w3-input w3-border w3-margin-bottom" type="text"
						name="newpass">
						 <label>รหัสใหม่-อีกครั้ง</label> <input
						class="w3-input w3-border w3-margin-bottom" type="text"
						name="newpass2">

					<div class="w3-section">
						 <input type="submit"
							class="w3-btn w3-green w3-deep-blue w3-border w3-right"
							value="เปลี่ยนรหัส">
					</div>
				</div>
				
				
				
				</form>
					

</div>

<!-- end class -->
	</div>

<script type="text/javascript">
	function fncregister() {
		if (document.refass.repassed.value == "") {
			alert('กรุณา ใส่รหัสเดิม');
			document.refass.repassed.focus();
			return false;
		}

		if (document.refass.newpass.value == "") {
			alert('กรุณา ใส่รหัสผ่านใหม่');
			document.refass.newpass.focus();
			return false;
		}
		if (document.refass.newpass2.value == "") {
			alert('กรุณา ใส่รหัสผ่านใหม่อีกครั้ง');
			document.refass.newpass2.focus();
			return false;
		}
		if (document.refass.newpass.value != document.refass.newpass2.value) {
			alert('กรุณารหัสผ่านไม่ตรงกัน');
			document.refass.newpass.focus();
			return false;
		}
	}
</script>
	
	<jsp:include page="../../Template/Footer.jsp"></jsp:include>
</body>
</html>