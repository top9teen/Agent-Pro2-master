<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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
								class="w3-btn w3-green w3-deep-orange w3-border w3-right"
								onclick="document.getElementById('register').style.display='block'"
								value="สมัคร"> <input type="submit"
								class="w3-btn w3-green w3-deep-blue w3-border w3-right"
								value="เข้าสู่ระบบ">
							<div align="left" class="fb-like"
								data-href="https://developers.facebook.com/docs/plugins/"
								data-layout="standard" data-action="like" data-size="small"
								data-show-faces="true" data-share="true"></div>
						</div>
					</div>

				</form>
				<div id="status"></div>
				
				<input type="hidden" id="regid" name="regid" id="regid">


			<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
  </fb:login-button>

			</div>
		</div>
</body>


<div id="fb-root"></div>



   <script>
      // This is called with the results from from FB.getLoginStatus().
      function statusChangeCallback(response) {
        console.log(response);
        // The response object is returned with a status field that lets the
        // app know the current login status of the person.
        // Full docs on the response object can be found in the documentation
        // for FB.getLoginStatus().
        if (response.status === 'connected') {
          // Logged into your app and Facebook.
          testAPI();
      	document.welcome.action = "facebook";
		document.welcome.submit(); 
			/* window.location.href = 'facebook';  */

        } else if (response.status === 'not_authorized') {
          // The person is logged into Facebook, but not your app.
          console.log("The person is logged into Facebook, but not your app.");
        } else {
          // The person is not logged into Facebook, so we're not sure if
          // they are logged into this app or not.
        }
      }

      // This function is called when someone finishes with the Login
      // Button.  See the onlogin handler attached to it in the sample
      // code below.
      function checkLoginState() {
        FB.getLoginStatus(function(response) {
          statusChangeCallback(response);
        });
      }

      window.fbAsyncInit = function() {
        FB.init({
          appId: '259177254718154',
          cookie: true, // enable cookies to allow the server to access 
          // the session
          xfbml: true, // parse social plugins on this page
          version: 'v3.1' // use version 2.2
        });

        // Now that we've initialized the JavaScript SDK, we call 
        // FB.getLoginStatus().  This function gets the state of the
        // person visiting this page and can return one of three states to
        // the callback you provide.  They can be:
        //
        // 1. Logged into your app ('connected')
        // 2. Logged into Facebook, but not your app ('not_authorized')
        // 3. Not logged into Facebook and can't tell if they are logged into
        //    your app or not.
        //
        // These three cases are handled in the callback function.

        FB.getLoginStatus(function(response) {
          statusChangeCallback(response);
        });

      };

      // Load the SDK asynchronously
      (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s);
        js.id = id;
        js.src = "//connect.facebook.net/th_TH/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
      }(document, 'script', 'facebook-jssdk'));

      // Here we run a very simple test of the Graph API after login is
      // successful.  See statusChangeCallback() for when this call is made.
      function testAPI() {
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me' , {
			locale : 'th_TH',
			fields : 'name, email'
		}, function(response) {
          console.log("Fb response");
          console.log(response);
          console.log('Successful login for: ' + response.name);
          document.getElementById("regid").value = response.email;
          
          document.getElementById('status').innerHTML =
            'Thanks for logging in, ' + response.name + '!';
        });
      }
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