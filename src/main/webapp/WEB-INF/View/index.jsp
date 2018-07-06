<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="../Template/Header.jsp"></jsp:include>
<title>ReFinder</title>
</head>
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "RobotoDraft", "Roboto", sans-serif
}

.w3-bar-block .w3-bar-item {
	padding: 16px
}


body {
    /* The image used */
   background-image: url("access/img/bg/bg-index.jpg");
background-color : gray;
    /* Full height */
    height: 100%; 
     margin: 0;
 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}

</style>
<body>

	<!-- Side Navigation -->
	<nav
		class="w3-sidebar w3-bar-block w3-collapse w3-white w3-animate-left w3-card"
		style="z-index: 3; width: 320px;" id="mySidebar"> <a
		href="javascript:void(0)"
		class="w3-bar-item w3-button w3-border-bottom w3-large"></a>  <a href="javascript:void(0)"
		class="w3-bar-item w3-button w3-dark-grey w3-button w3-hover-black w3-left-align"
		onclick="document.getElementById('id01').style.display='block'">เข้าสู่ระบบ <i class="w3-padding fa fa-pencil"></i>
	</a> 

	<a href="#" class="w3-bar-item w3-button"><i
		class="fa fa-paper-plane w3-margin-right"></i>ติดต่อเรา/เเชทกับเรา</a> <a href="#"
		class="w3-bar-item w3-button"><i
		class="fa fa-hourglass-end w3-margin-right"></i>01-111-1111</a> 
		 </nav>
		
	<!-- Modal that pops up when you click on "New Message" -->
	<div id="id01" class="w3-modal" style="z-index: 4">
		<div class="w3-modal-content w3-animate-zoom">
			<div class="w3-container w3-padding w3-sand">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="w3-button w3-red w3-right w3-xxlarge"><i
					class="fa fa-remove"></i></span>
				<h2 align="center">เข้าสู่ระบบ</h2>
			</div>
			<div class="w3-panel">
				<label>Email</label> <input class="w3-input w3-border w3-margin-bottom"
					type="text"> <label>Password</label> <input
					class="w3-input w3-border w3-margin-bottom" type="text"> 
				
				<div class="w3-section">
					<a class="w3-button w3-red  w3-right"
						onclick="document.getElementById('id01').style.display='none'">Cancel
						 <i class="fa fa-remove"></i>
					</a> <a class="w3-button w3-light-grey w3-right"
						onclick="">เข้าสู่ระบบ
						 <i class="fa fa-paper-plane"></i>
					</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Overlay effect when opening the side navigation on small screens -->
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="Close Sidemenu"
		id="myOverlay"></div>

	<!-- Page content -->
	
	<div class="w3-main" style="margin-left: 400px;">
		
		<i
			class="fa fa-bars w3-button w3-white w3-hide-large w3-xlarge w3-margin-left w3-margin-top"
			onclick="w3_open()"></i> <a href="javascript:void(0)"
			class="w3-hide-large w3-light-green w3-button w3-right w3-margin-top w3-margin-right"
			onclick="document.getElementById('id01').style.display='block'"><i
			class="fa fa-pencil"></i></a> 
			
			<h1 align="center"> Welcome To Project</h1><br>
			
			<div  class="" style="z-index: 4">
		<div class="w3-modal-content w3-animate-zoom">
			<div class="w3-container w3-padding w3-dark-grey">
				
				<h2 align="center">เข้าสู่ระบบ</h2>
			</div>
			<div class="w3-panel">
				<label>Email</label> <input class="w3-input w3-border w3-margin-bottom"
					type="email"> <label>Password</label> <input
					class="w3-input w3-border w3-margin-bottom" type="password"> 
				
				<div class="w3-section">
				 
					 <a  class="w3-btn w3-green w3-deep-orange w3-border w3-right"
						onclick="" ><i class="fa fa-user-plus"></i>&nbsp; เข้าสู่ระบบ
						
					</a>
				</div>
			</div>
		</div>
	</div>
			</div>
			




	<jsp:include page="../Template/Footer.jsp"></jsp:include>
	
</body>
</html>