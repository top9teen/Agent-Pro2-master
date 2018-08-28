<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@page import="java.util.List"%>
<%@page import="com.test.Bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="access/img/logo/logo8.png" />
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

<body>

	<jsp:include page="../../Template/manuadmin.jsp"></jsp:include>
	<!-- Modal that pops up when you click on "New Message" -->

	<div class="w3-main" style="margin-left: 400px;">

		<i
			class="fa fa-bars w3-button w3-white w3-hide-large w3-xlarge w3-margin-left w3-margin-top"
			onclick="w3_open()"></i>

<div class="w3-modal-content w3-animate-zoom w3-card" style="background-color: #0193d7" >
<h1 style="font-style: italic;" align="center">ยินดีตอนรับ ADMIN</h1>
	<%
		List<LoginBean> list = null;
		Integer a = 0;
	%>
	<%
		list = (List<LoginBean>) request.getSession().getAttribute("list");
	%>

</div>

<div class="w3-modal-content w3-card w3-animate-bottom" >
<div align="right">
				<form name="welcome2" action="/" method="post">
					<button class="w3-btn w3-green w3-deep-green w3-border "
						onclick="ddd">ประวัติการจ่ายเงิน</button>
				</form>
			</div>
			<form name="welcome" action=".">
			<input id="myInput" style="width: 30%" align="right" type="text"
				placeholder="ค้นหา...." class="w3-input w3-border w3-light-grey">
			<input type="hidden" id="regid" name="regid" id="regid">
			<table class="w3-table-all w3-card-4">
				<thead>
					<tr>
						<th class="text-center">ลำดับ</th>
						<th class="text-center">email</th>
						<th class="text-center">password</th>
							<th class="text-center">สถานะ</th>
						
					</tr>
				</thead>
				<tbody id="myTable">
					<%
						for (int i = 0; i < list.size(); i++) {
					%>
					<tr class="text-center">

						<td><%=a = a + 1%></td>
						<td><%=list.get(i).getLoEmail()%></td>
						<td><%=list.get(i).getLoPassword()%></td>
							<td>ลูกค้า</td>
						
								

					</tr>
					<%
						}
					%>
				</tbody>
			</table>
</form>

</div>

<!-- end class -->
	</div>
	<script type="text/javascript">
	

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
	<jsp:include page="../../Template/Footer.jsp"></jsp:include>
</html>