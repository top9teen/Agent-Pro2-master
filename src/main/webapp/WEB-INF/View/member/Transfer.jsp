<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="com.test.Bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="access/img/logo/logo8.png" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="access/css/A4.css">
<link rel="stylesheet" href="access/css/bootstrap.min.css">
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
</style>
<jsp:include page="../../Template/Header.jsp"></jsp:include>
<title>ReFinder</title>
</head>
<%
	List<ReceiptBean> list = null;
	Integer a = 0;
%>
<%
	list = (List<ReceiptBean>) request.getSession().getAttribute("list");
%>

<body>

	<jsp:include page="../../Template/manu.jsp"></jsp:include>
	<!-- Modal that pops up when you click on "New Message" -->

	<div class="w3-main" style="margin-left: 400px;">

		<i
			class="fa fa-bars w3-button w3-white w3-hide-large w3-xlarge w3-margin-left w3-margin-top"
			onclick="w3_open()"></i>

		<div class="w3-modal-content w3-animate-zoom w3-card"
			style="background-color: #0193d7">
			<h1 style="font-style: italic;" align="center">ระบบวิเคราะห์สินเชื่อรถยนต์</h1>


		</div>

		<div class="w3-modal-content w3-card w3-animate-bottom">

			<div align="right"></div>
			<form name="welcome" action=".">
				<input id="myInput" style="width: 30%" align="right" type="text"
					placeholder="ค้นหา...." class="w3-input w3-border w3-light-grey">
				<input type="hidden" id="regid" name="regid" id="regid">
				<table class="w3-table-all w3-card-4">
					<thead>
						<tr>
							<th class="text-center">ลำดับ</th>
							<th class="text-center">ชื่อ</th>
							<th class="text-center">อีเมลล์</th>
							<th class="text-center">ปีรถ</th>
							<th class="text-center">ยี่ห่อรถ</th>
							<th class="text-center">รุ่นรถ</th>
							<th class="text-center">แบงค์</th>
							<th class="text-center">จำนวนเงิน</th>
							<th class="text-center">วันเดือนปีที่จ่าย</th>
							<th class="text-center">ปริ้นใบเสร็จ</th>

						</tr>
					</thead>
					<tbody id="myTable">
						<%
							for (int i = 0; i < list.size(); i++) {
						%>
						<tr class="text-center">

							<td><%=a = a + 1%></td>
							<td><%=list.get(i).getReName()%></td>
							<td><%=list.get(i).getReEmail()%></td>
							<td><%=list.get(i).getReCaryear()%></td>
							<td><%=list.get(i).getReCar()%></td>
							<td><%=list.get(i).getReCarmodel()%></td>
							<td><%=list.get(i).getReBank()%></td>
							<td><%=list.get(i).getReMonny()%></td>
							<td><%=list.get(i).getReDay()%> / <%=list.get(i).getReMont()%>
								/ <%=list.get(i).getReYrar()%></td>
							<td align="center"><a
								onclick="gotoUpdateggggg('<%=list.get(i).getReId()%>')"><span
									class="glyphicon glyphicon-search"> </span></a></td>




						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</form>


		</div>
		<div class="w3-modal " id="Forms25" style="display: none;">
			<div class="w3-modal-content w3-animate-zoom">
				<div class="w3-container w3-padding w3-sand">
					<span
						onclick="document.getElementById('Forms25').style.display='none'"
						class="w3-button w3-red w3-right w3-xxlarge"><i
						class="fa fa-remove"></i></span>
				</div>

				<jsp:include page="fromtranfer.jsp"></jsp:include>
				 <input type="button"
					class="w3-btn w3-green w3-deep-orange w3-border w3-right"
					onclick="document.getElementById('Forms25').style.display='none'"
					value="ยกเลิก">
			</div>
		</div>
		<!-- end class -->
	</div>
	<jsp:include page="../../Template/Footer.jsp"></jsp:include>
	<script type="text/javascript">
	

	
	function gotoUpdateggggg(filter) {
		 document.getElementById("regid").value = filter;
		var simpleTestBean = { "xxx" :  $('#regid').val()};
		$("#Forms25").show('slow');

		
	}
	$(document).ready(
			function() {
				$("#myInput").on(
						"keyup",
						function() {
							var value = $(this).val().toLowerCase();
							$("#myTable tr").filter(
									function() {
										$(this).toggle(
												$(this).text().toLowerCase()
														.indexOf(value) > -1)
									});
						});
			});
	


</script>

</body>
</html>