<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.test.BankBean.*"%>
<%@page import="com.test.Bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="access/img/logo/logo8.jpg" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
body {
	/* The image used */
	/*  background-image: url("access/img/bg/bg-index.jpg"); */
	background-color: #f6f6f6;
	/* Full height */
	height: 100%;
	margin: 0;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 20px 60px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
	margin: 4px 2px;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	cursor: pointer;
}

.button2 {
	background-color: white;
	color: black;
	border: 2px solid #008CBA;
}

.button2:hover {
	background-color: #008CBA;
	color: white;
}

.require-red {
	display: inline;
	color: red;
}

img {
	border: 1px solid #ddd;
	border-radius: 4px;
	padding: 5px;
	width: 150px;
}

label {
	font-size: 15px;
	font-style: oblique;
	color: blue;
}

p {
	color: #0080ff;
}

h3 {
	text-shadow: 2px 2px 5px yellow;
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

		<%
			/* 	KasikornPriceBean kabean = null;
				KrungsriPriceBean krbean = null;
				ScbeasyPriceBean scbean = null;
				ThanachartPriceBean thbean = null;
				*/
				YearCarBean yebean = null; 
			MiradoBean mibean = null;
		%>
		<%
			/* kabean = (KasikornPriceBean) request.getSession().getAttribute("kabean");
			krbean = (KrungsriPriceBean) request.getSession().getAttribute("krbean");
			scbean = (ScbeasyPriceBean) request.getSession().getAttribute("scbean");
			thbean = (ThanachartPriceBean) request.getSession().getAttribute("thbean");
			 */
			 yebean = (YearCarBean) request.getSession().getAttribute("yebean");
			mibean = (MiradoBean) request.getSession().getAttribute("mibean");
		%>

		<div class="w3-modal-content w3-animate-zoom w3-card "
			style="background-color: #0193d7">
			<h1 style="font-style: italic; color: white;" align="center">ธนาคารทั้งหมด</h1>
			<h2 align="center" style="color: red;">
				*<span style="color: white;">กรุณาเลือก ธนาคารที่ท่านสนใจ</span>
			</h2>

		</div>
		<div class="w3-modal-content w3-card w3-animate-bottom">


		<form action="gotoreg">
				<input type="hidden" value="<%=mibean.getGroupType()%>"
					id="groupType2" name="groupType2"> <input type="hidden"
					value="<%=mibean.getCarMake2()%>" id="carMakeed" name="carMakeed">
					<div id = "f1">
				
					</div>
			
			</form>
			
		</div>

		<br>
		<div class="w3-modal-content w3-card w3-animate-bottom" id="f2">
			

		</div>
		<br>
		<div class="w3-modal-content w3-card w3-animate-bottom" id="f3">
		

		</div>
		<br>
		<div class="w3-modal-content w3-card w3-animate-bottom" id="f4">
			

		</div>



		<!-- end class -->
	</div>



</body>
<script type="text/javascript">
	$(document).ready(
			function() {
				
				/* $('#kabant').text('วงเงินสูงสุด'); */
				var miradoBean = {
					"groupType" : $('#groupType2').val(),
					"carMake2" : $('#carMakeed').val()
				};

				$.ajax({
					type : "POST",
					url : "http://localhost:8090/kaprice",
					data : JSON.stringify(miradoBean),
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					success : function(msg) {
						console.log('Success')

					$('#f1').append('<h3 align="center">ธนาคาร กสิกร</h3><div class="row"><div class="col-sm-4"><img alt="" src="access/img/logo/kr2.jpg"style="border-radius: 50%;"><br> <br> <br></div><div class="col-sm-4"><p>อัตราดอกเบี้ยเริ่มต้นอายุสัญญา</p><h2 style="color: green;" id="g1"></h2><label id="kabant"> </label></div><div class="col-sm-4"><input type="hidden" name="typebank" value="ka1"><button type="submit" class="button button2">เลือก</button></div></div>');

						
						$('#kabant').text('วงเงินสูงสุด'+ msg.kaPrice +'บาท');
						$('#g1').text('<%=yebean.getYrPercent() %>'  +  ' %');
						$('#b1').append('<button type="submit" class="button button2">เลือก</button>');
						
					}
				});
				
				
				$.ajax({
					type : "POST",
					url : "http://localhost:8091/kr",
					data : JSON.stringify(miradoBean),
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					success : function(msg) {
						console.log('Success')

							$('#f2').append('<form action="gotoreg"><h3 align="center">ธนาคาร กรุงศรี</h3><div class="row"><div class="col-sm-4"><img alt="" src="access/img/logo/kr1.jpg"style="border-radius: 50%;"><br> <br> <br></div><div class="col-sm-4"><p>อัตราดอกเบี้ยเริ่มต้นอายุสัญญา</p><h2 style="color: green;" id="g2"></h2><label id="krabant"> </label></div><div class="col-sm-4" id="b2"><input type="hidden" name="typebank" value="kr1"></div></div></form>');
						
						$('#krabant').text('วงเงินสูงสุด'+ msg.krPrice +'บาท');
						$('#g2').text('<%=yebean.getYrPercent() %>'   + ' %');
						$('#b2').append('<button type="submit" class="button button2">เลือก</button>');

					}
				});
				
				
				
				$.ajax({
					type : "POST",
					url : "http://localhost:8092/sc",
					data : JSON.stringify(miradoBean),
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					success : function(msg) {
						console.log('Success')

						$('#f3').append('<form action="gotoreg"><h3 align="center">ธนาคาร ไทยพาณิชย์</h3><div class="row"><div class="col-sm-4"><img alt="" src="access/img/logo/kr3.jpg"style="border-radius: 50%;"><br> <br> <br></div><div class="col-sm-4"><p>อัตราดอกเบี้ยเริ่มต้นอายุสัญญา</p><h2 style="color: green;" id="g3"></h2><label id="scabant"> </label></div><div class="col-sm-4" id="b3"><input type="hidden" name="typebank" value="sc1"></div></div></form>');

						
						$('#scabant').text('วงเงินสูงสุด'+ msg.scPrice +'บาท');
						$('#g3').text('<%=yebean.getYrPercent() %>'   + ' %');
						$('#b3').append('<button type="submit" class="button button2">เลือก</button>');

					}
				});
				

				$.ajax({
					type : "POST",
					url : "http://localhost:8093/th",
					data : JSON.stringify(miradoBean),
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					success : function(msg) {
						console.log('Success')

						$('#f4').append('<form action="gotoreg"><h3 align="center">ธนาคาร ธนชาต</h3><div class="row"><div class="col-sm-4"><img alt="" src="access/img/logo/k4.jpg"style="border-radius: 50%;"><br> <br> <br></div><div class="col-sm-4"><p>อัตราดอกเบี้ยเริ่มต้นอายุสัญญา</p><h2 style="color: green;" id="g4"></h2><label id="thabant"> </label></div><div class="col-sm-4" id="b4"><input type="hidden" name="typebank" value="th1"></div></div></form>');
						
						$('#thabant').text('วงเงินสูงสุด'+ msg.thPrice +'บาท');
						$('#g4').text('<%=yebean.getYrPercent() %>'   + ' %');
						$('#b4').append('<button type="submit" class="button button2">เลือก</button>');

					}
				});
				
			});
</script>

</html>