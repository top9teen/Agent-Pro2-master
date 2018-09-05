<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<style>
/* Shared */
.loginBtn {
  box-sizing: border-box;
  position: relative;
  /* width: 13em;  - apply for fixed size */
  margin: 0.2em;
  padding: 0 15px 0 46px;
  border: none;
  text-align: left;
  line-height: 34px;
  white-space: nowrap;
  border-radius: 0.2em;
  font-size: 16px;
  color: #FFF;
}
.loginBtn:before {
  content: "";
  box-sizing: border-box;
  position: absolute;
  top: 0;
  left: 0;
  width: 34px;
  height: 100%;
}
.loginBtn:focus {
  outline: none;
}
.loginBtn:active {
  box-shadow: inset 0 0 0 32px rgba(0,0,0,0.1);
}


/* Facebook */
.loginBtn--facebook {
  background-color: #4C69BA;
  background-image: linear-gradient(#4C69BA, #3B55A0);
  /*font-family: "Helvetica neue", Helvetica Neue, Helvetica, Arial, sans-serif;*/
  text-shadow: 0 -1px 0 #354C8C;
}
.loginBtn--facebook:before {
  border-right: #364e92 1px solid;
  background: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_facebook.png') 6px 6px no-repeat;
}
.loginBtn--facebook:hover,
.loginBtn--facebook:focus {
  background-color: #5B7BD5;
  background-image: linear-gradient(#5B7BD5, #4864B1);
}


/* Google */
.loginBtn--google {
  /*font-family: "Roboto", Roboto, arial, sans-serif;*/
  background: #DD4B39;
}
.loginBtn--google:before {
  border-right: #BB3F30 1px solid;
  background: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_google.png') 6px 6px no-repeat;
}
.loginBtn--google:hover,
.loginBtn--google:focus {
  background: #E74B37;
}
</style>
<body>

	<!-- Side Navigation -->
	<nav
		class="w3-sidebar w3-bar-block w3-collapse w3-white w3-animate-left w3-card"
		style="z-index: 3; width: 320px;" id="mySidebar">
		<a href="javascript:void(0)"
			class="w3-bar-item w3-button w3-border-bottom w3-large"></a> <a
			href="javascript:void(0)"
			class="w3-bar-item w3-button  w3-button w3-hover-black w3-left-align"
			onclick="document.getElementById('id01').style.display='block'"
			style="background-color: #0193d7">เข้าสู่ระบบ <i
			class="w3-padding fa fa-pencil"></i>
		</a> <a href="#" class="w3-bar-item w3-button"><i
			class="fa fa-paper-plane w3-margin-right"></i>ติดต่อเรา/เเชทกับเรา</a> <a
			href="#" class="w3-bar-item w3-button"><i
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
					<label>Email</label> <input
						class="w3-input w3-border w3-margin-bottom" type="email"
						name="email"> <label>Password</label> <input
						class="w3-input w3-border w3-margin-bottom" type="password"
						name="password">

					<div class="w3-section">
						 <input type="button"
							class="w3-btn w3-green w3-deep-orange w3-border w3-right"
							onclick=" document.getElementById('id01').style.display='none'"
							value="ยกเลิก"> <input type="submit"
							class="w3-btn w3-green w3-deep-blue w3-border w3-right"
							value="เข้าสู่ระบบ">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="register" class="w3-modal" style="z-index: 4">
		<div class="w3-modal-content w3-animate-zoom">
			<div class="w3-container w3-padding w3-sand">
				<span
					onclick="document.getElementById('register').style.display='none'"
					class="w3-button w3-red w3-right w3-xxlarge"><i
					class="fa fa-remove"></i></span>
				<h2 align="center">สมัครสมาชิก</h2>
			</div>
			<form action="gotoregister" OnSubmit="return fncregister();"
				name="register">
				<div class="w3-panel">

					<label>Email</label> <input
						class="w3-input w3-border w3-margin-bottom" type="text"
						name="email"> <label>Password</label> <input
						class="w3-input w3-border w3-margin-bottom" type="text"
						name="password"> <label>Re-Password</label> <input
						class="w3-input w3-border w3-margin-bottom" type="text"
						name="repassword">
					<div class="w3-section">
						 <input type="button"
							class="w3-btn w3-green w3-deep-orange w3-border w3-right"
							onclick="document.getElementById('register').style.display='none'"
							value="ยกเลิก"> <input type="submit"
							class="w3-btn w3-green w3-deep-blue w3-border w3-right"
							value="สมัคร">
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

		<h1 align="center">Welcome To Project For Member</h1>
		<br>

		<div class="" style="z-index: 4">
			<div class="w3-modal-content w3-animate-zoom w3-card"
				style="width: 50%">
				<div class="w3-container w3-padding"
					style="background-color: #0193d7">

					<h2 style="color: white;" align="center">เข้าสู่ระบบ</h2>
				</div>
				<form action="gotologin" name="login">
					<div class="w3-panel">
						<label>Email</label> <input
							class="w3-input w3-border w3-animate-input" type="email"
							name="email" style="width: 80%"> <label>Password</label>
						<input class="w3-input w3-border w3-animate-input" type="password"
							name="password" style="width: 80%">

						<div class="w3-section">
							 <input type="button"
								class="btn btn-primary w3-right btn-lg btn-block"
								onclick="document.getElementById('register').style.display='block'"
								value="สมัคร"> <input type="submit"
								class="btn btn-success w3-border w3-right btn-lg btn-block"
								value="เข้าสู่ระบบ">
							<div align="left" class="fb-like"
								data-href="https://developers.facebook.com/docs/plugins/"
								data-layout="standard" data-action="like" data-size="small"
								data-show-faces="true" data-share="true"></div>
						</div>

					</div>

				</form>
				<br>
				<div class="w3-panel">
					<form action="" name="welcome">


						<input type="hidden" name="regid" id="regid">
						<div id="fb-root">

							<div class="w3-section" align="center" >
								<a  class="btn btn-info btn-lg btn-block loginBtn loginBtn--facebook  w3-center "
									onclick="fbAuthUser();" id="fb"> Log in with Facebook</a>

							</div>


						</div>

					</form>
					<form action="" name="welcome22">
						<input type="hidden" name="regid2" id="regid2">
						<div align="center" data-onsuccess="onSignIn" data-theme="dark"
							class="btn btn-info btn-lg btn-block loginBtn loginBtn--google w3-center "> Log in with Google+</div>
					</form>
					<br>
				</div>
			</div>
		</div>
	</div>

	<script>
		function onSignIn(googleUser) {
			// Useful data for your client-side scripts:
			var profile = googleUser.getBasicProfile();
			console.log("ID: " + profile.getId()); // Don't send this directly to your server!
			console.log('Full Name: ' + profile.getName());
			console.log('Given Name: ' + profile.getGivenName());
			console.log('Family Name: ' + profile.getFamilyName());
			console.log("Image URL: " + profile.getImageUrl());
			console.log("Email: " + profile.getEmail());

			// The ID token you need to pass to your backend:
			var id_token = googleUser.getAuthResponse().id_token;
			console.log("ID Token: " + id_token);

			var r = confirm("เข้าสู่ระบบด้วย goole !");
			if (r == true) {
				document.getElementById("regid2").value = profile.getEmail();
				document.welcome22.action = "google";
				document.welcome22.submit();
			} else {
				var auth2 = gapi.auth2.getAuthInstance();
				auth2.signOut().then(function() {
					console.log('User signed out.');
					window.location.href = "/";
				});
			}

		};
	</script>

</body>

<script type="text/javascript">
	window.fbAsyncInit = function() {
		FB.init({
			appId : '259177254718154',
			status : true,
			cookie : true,
			xfbml : true
		});

		FB.getLoginStatus(function(response) {

			if (response != null) {
				fbAuthUser();

			} else if (response && response.status === 'connected') {
				FB.logout(function(response) {
					window.location.href = "/";
				});
			}

		});
	};
	(function() {
		var e = document.createElement('script');
		e.type = 'text/javascript';
		e.src = document.location.protocol
				+ '//connect.facebook.net/en_US/all.js';
		e.async = true;
		document.getElementById('fb-root').appendChild(e);
	}());

	function fbAuthUser() {

		FB.api('/me', {
			locale : 'en_US',
			fields : 'name, email'
		}, function(response) {
			var s = "";
			if (s == "") {
				var n = confirm("เข้าสู่ระบบด้วย Facebook !");
				if (n == true) {
					console.log(response);
					document.getElementById("regid").value = response.email;
					document.welcome.action = "facebook";
					document.welcome.submit();
					s = "";
				} else {

					FB.Event.subscribe('auth.logout', function(response) {
						FB.logout(function(response) {

							s = "F";
							window.location.href = "/";
						});
					});

				}
			}

		});
	};
</script>






<script type="text/javascript">
	function fncregister() {
		if (document.register.email.value == "") {
			alert('กรุณา ใส่อีเมลล์');
			document.register.email.focus();
			return false;
		}

		if (document.register.email.value.indexOf('@') == -1) {
			alert('ใส่ Gmail หรือ Hotmail เท่านั้น');
			document.register.email.focus();
			return false;
		}
		if (document.register.email.value.indexOf('.') == -1) {
			alert('ใส่ .com หรือ  .co.th เท่านั้น');
			document.register.email.focus();
			return false;
		}
		if (document.register.password.value == "") {
			alert('กรุณา ใส่รหัสผ่าน');
			document.register.password.focus();
			return false;
		}
		if (document.register.repassword.value == "") {
			alert('กรุณา ใส่รหัสผ่านอีกครั้ง');
			document.register.repassword.focus();
			return false;
		}
		if (document.register.password.value != document.register.repassword.value) {
			alert('กรุณา ใส่รหัสผ่านให้ถูกต้อง');
			document.register.repassword.focus();
			return false;
		}
	}
</script>