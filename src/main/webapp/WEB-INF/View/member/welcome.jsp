<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="../../Template/Header.jsp"></jsp:include>
<title>ReFinder</title>
</head>

<body>

<jsp:include page="../../Template/manu.jsp"></jsp:include>
	<!-- Modal that pops up when you click on "New Message" -->
	<div id="id01" class="w3-modal" style="z-index: 4">
		<div class="w3-modal-content w3-animate-zoom">
			<div class="w3-container w3-padding w3-red">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="w3-button w3-red w3-right w3-xxlarge"><i
					class="fa fa-remove"></i></span>
				<h2>Send Mail</h2>
			</div>
			<div class="w3-panel">
				<label>To</label> <input class="w3-input w3-border w3-margin-bottom"
					type="text"> <label>From</label> <input
					class="w3-input w3-border w3-margin-bottom" type="text"> <label>Subject</label>
				<input class="w3-input w3-border w3-margin-bottom" type="text">
				<input class="w3-input w3-border w3-margin-bottom"
					style="height: 150px" placeholder="What's on your mind?">
				<div class="w3-section">
					<a class="w3-button w3-red"
						onclick="document.getElementById('id01').style.display='none'">Cancel
						 <i class="fa fa-remove"></i>
					</a> <a class="w3-button w3-light-grey w3-right"
						onclick="document.getElementById('id01').style.display='none'">Send
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
	<div class="w3-main" style="margin-left: 320px;">
		<i
			class="fa fa-bars w3-button w3-white w3-hide-large w3-xlarge w3-margin-left w3-margin-top"
			onclick="w3_open()"></i> <a href="javascript:void(0)"
			class="w3-hide-large w3-red w3-button w3-right w3-margin-top w3-margin-right"
			onclick="document.getElementById('id01').style.display='block'"><i
			class="fa fa-pencil"></i></a>

		<div id="Borge" class="w3-container person">
			<br> <img class="w3-round  w3-animate-top"
				src="/w3images/avatar3.png" style="width: 20%;">
			<h5 class="w3-opacity">Subject: Remember Me</h5>
			<h4>
				<i class="fa fa-clock-o"></i> From Borge Refsnes, Sep 27, 2015.
			</h4>
			<a class="w3-button w3-light-grey" href="#">Reply<i
				class="w3-margin-left fa fa-mail-reply"></i></a> <a
				class="w3-button w3-light-grey" href="#">Forward<i
				class="w3-margin-left fa fa-arrow-right"></i></a>
			<hr>
			<p>Hello, i just wanted to let you know that i'll be home at
				lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
				eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
				ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
				aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat
				non proident, sunt in culpa qui officia deserunt mollit anim id est
				laborum consectetur adipiscing elit, sed do eiusmod tempor
				incididunt ut labore et dolore magna aliqua. Ut enim ad minim
				veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex
				ea commodo consequat.</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Excepteur sint occaecat
				cupidatat non proident, sunt in culpa qui officia deserunt mollit
				anim id est laborum consectetur adipiscing elit, sed do eiusmod
				tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
				veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex
				ea commodo consequat.</p>
			<p>
				Best Regards, <br>Borge Refsnes
			</p>
		</div>

		<div id="Jane" class="w3-container person">
			<br> <img class="w3-round w3-animate-top"
				src="/w3images/avatar5.png" style="width: 20%;">
			<h5 class="w3-opacity">Subject: None</h5>
			<h4>
				<i class="fa fa-clock-o"></i> From Jane Doe, Sep 25, 2015.
			</h4>
			<a class="w3-button w3-light-grey">Reply<i
				class="w3-margin-left fa fa-mail-reply"></i></a> <a
				class="w3-button w3-light-grey">Forward<i
				class="w3-margin-left fa fa-arrow-right"></i></a>
			<hr>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo consequat. Excepteur sint occaecat
				cupidatat non proident, sunt in culpa qui officia deserunt mollit
				anim id est laborum consectetur adipiscing elit, sed do eiusmod
				tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
				veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex
				ea commodo consequat.</p>
			<p>
				Forever yours,<br>Jane
			</p>
		</div>

		<div id="John" class="w3-container person">
			<br> <img class="w3-round w3-animate-top"
				src="/w3images/avatar2.png" style="width: 20%;">
			<h5 class="w3-opacity">Subject: None</h5>
			<h4>
				<i class="fa fa-clock-o"></i> From John Doe, Sep 23, 2015.
			</h4>
			<a class="w3-button w3-light-grey">Reply<i
				class="w3-margin-left fa fa-mail-reply"></i></a> <a
				class="w3-button w3-light-grey">Forward<i
				class="w3-margin-left fa fa-arrow-right"></i></a>
			<hr>
			<p>Welcome.</p>
			<p>That's it!</p>
		</div>

	</div>
	<jsp:include page="../../Template/Footer.jsp"></jsp:include>
</body>
</html>