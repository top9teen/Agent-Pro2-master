<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<body>

	<!-- Side Navigation -->
	<nav
		class="w3-sidebar w3-bar-block w3-collapse w3-white w3-animate-left w3-card"
		style="z-index: 3; width: 320px;" id="mySidebar"> <a
		href="javascript:void(0)"
		class="w3-bar-item w3-button w3-border-bottom w3-large"></a>  <a href="javascript:void(0)"
		class="w3-bar-item w3-button  w3-button w3-hover-black w3-left-align"
		onclick="document.getElementById('id01').style.display='block'" style="background-color: #0193d7 ">เข้าสู่ระบบ <i class="w3-padding fa fa-pencil"></i>
	</a> 

	<a href="#" class="w3-bar-item w3-button"><i
		class="fa fa-paper-plane w3-margin-right"></i>ติดต่อเรา/เเชทกับเรา</a> <a href="#"
		class="w3-bar-item w3-button"><i
		class="fa fa-hourglass-end w3-margin-right"></i>01-111-1111</a> 
		 </nav>
		
	<!-- Modal that pops up when you click on "New Message" -->
	<div id="id01" class="w3-modal" style="z-index: 4">
		<div class="w3-modal-content w3-animate-zoom w3-card">
			<div class="w3-container w3-padding w3-sand w3-flat-wisteria">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="w3-button w3-red w3-right w3-xxlarge"><i
					class="fa fa-remove"></i></span>
				<h2 align="center">เข้าสู่ระบบ</h2>
			</div>
			<form action="gotologin">
			<div class="w3-panel">
				<label>Email</label> <input class="w3-input w3-border w3-margin-bottom"
					type="email" name="email"> <label>Password</label> <input
					class="w3-input w3-border w3-margin-bottom" type="password" name="password"> 
				
				<div class="w3-section">
					 <input type="button" class="w3-btn w3-green w3-deep-orange w3-border w3-right" onclick=" document.getElementById('id01').style.display='none'" value="ยกเลิก">
				<input type="submit" class="w3-btn w3-green w3-deep-blue w3-border w3-right"  value="เข้าสู่ระบบ"> 
				</div>
			</div>
			</form>
		</div>
	</div>
	<div id="register" class="w3-modal" style="z-index: 4">
		<div class="w3-modal-content w3-animate-zoom">
			<div class="w3-container w3-padding w3-sand">
				<span onclick="document.getElementById('register').style.display='none'"
					class="w3-button w3-red w3-right w3-xxlarge"><i
					class="fa fa-remove"></i></span>
				<h2 align="center">สมัครสมาชิก</h2>
			</div>
			<form action="gotoregister">
			<div class="w3-panel">
			
				<label>Email</label> <input class="w3-input w3-border w3-margin-bottom"
					type="email" name="email"> <label>Password</label> <input
					class="w3-input w3-border w3-margin-bottom" type="text" name="password"> 
				<label>Re-Password</label> <input
					class="w3-input w3-border w3-margin-bottom" type="text" name = "repassword">
				<div class="w3-section">
					 <input type="button" class="w3-btn w3-green w3-deep-orange w3-border w3-right" onclick="document.getElementById('register').style.display='none'" value="ยกเลิก">
						<input type="submit" class="w3-btn w3-green w3-deep-blue w3-border w3-right"  value="สมัคร"> 
				</div>
			
			</div>
				</form>
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
			
			<h1 align="center"> Welcome To Project For Member</h1><br>
			
			<div  class="" style="z-index: 4">
		<div class="w3-modal-content w3-animate-zoom w3-card" style="width:50%"> 
			<div class="w3-container w3-padding" style="background-color: #0193d7">
				
				<h2 style="color: white;" align="center">เข้าสู่ระบบ</h2>
			</div>
			<form action="gotologin" name="login">
			<div class="w3-panel" >
				<label>Email</label> <input class="w3-input w3-border w3-animate-input"
					type="email" name="email" style="width:80%"> <label>Password</label> <input
					class="w3-input w3-border w3-animate-input" type="password" name="password" style="width:80%"> 
				
				<div class="w3-section">
				 <input type="button" class="w3-btn w3-green w3-deep-orange w3-border w3-right" onclick="document.getElementById('register').style.display='block'" value="สมัคร">
				<input type="submit" class="w3-btn w3-green w3-deep-blue w3-border w3-right"  value="เข้าสู่ระบบ"> 
				</div>
			</div>
			</form>
		</div>
	</div>
			</div>
</body>
