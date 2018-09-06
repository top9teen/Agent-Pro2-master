<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
 p{
 font: inherit;
 font-size: 16 px;
 }
</style>
<link rel="icon" type="image/png" href="access/img/logo/logo8.jpg" />
<link rel="stylesheet" href="access/css/pdf.css">
<div  class="page" style="width: 80%;">

	
	<div id="printableArea" style="padding: 10mm; ">
	
	<br>
	<br>
	<br>
	<div
		style="border: 3px; border-style: solid; border-color: black; "  >

<br>
		<p  id="idtran"  style="margin-left: 5mm;"></p>
		<h2 align="center">ใบเสร็จรับเงิน ระบบวิเคราะห์สินเชื่อรถยนต์</h2>
		<h2 align="center">OFFICIAL RECEIPT</h2>
		<p align="right" style="margin-right: 5mm;" id="day"></p>
		<hr>
		
			<div style="margin-left: 8mm" >
			<p id="nametran"></p>
			<p id="emailtran"></p>
			<p id="yearcartran"></p>
			<p id="cartran"></p>
			<p id="modeltran"></p>
			<p id="monnytran"></p>
			<p align="right" style="margin-right: 8mm;" id="admintran"></p>
		</div>
	



	</div><br>
	</div>
	<div align="center">
	<a  type="button" class="btn btn-info btn-lg"
		onclick="printDiv('printableArea')"><span class="glyphicon glyphicon-print"></span> ปริ้นใบเสร็จ</a>
	</div>

</div>