<%@page import="com.test.Bean.SaveTable1Bean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	SaveTable1Bean bean = null;
	bean = (SaveTable1Bean) request.getSession().getAttribute("bean");
%>
<form action="gotopage2">
	<div class="form-section form-position " id="test">
		<h2 class="fs-title">รายละเอียดการขอกู้</h2>
		<!-- stap1 -->
		<div class="row">
			<div
				class="col-md-2 col-md-offset-1 col-sm-3 col-xs-12 col-sm-offset-1">
				<div class="form-group">
					<label>ปีรถ</label><span class="require-red">*</span> <input
						type="text" class="form-control" value="<%=bean.getGroupType()%>"
						disabled="disabled">
				</div>
			</div>
			<div
				class="col-md-3 col-md-offset-1 col-sm-3 col-xs-12 col-sm-offset-1">
				<div class="form-group">
					<label>ยี่ห่อ</label><span class="require-red">*</span> <input
						type="text" class="form-control" value="<%=bean.getCarMake()%>"
						disabled="disabled">
				</div>
			</div>
			<div
				class="col-md-3 col-md-offset-1 col-sm-3 col-xs-12 col-sm-offset-1">
				<div class="form-group">
					<label>รุ่น</label><span class="require-red">*</span> <input
						type="text" class="form-control" value="<%=bean.getCarMake2()%>"
						disabled="disabled">
				</div>
			</div>
		</div>
		<!-- stap2 -->
		<div class="row">
			<div
				class="col-md-5 col-md-offset-1 col-sm-5 col-xs-12 col-sm-offset-1">
				<div class="form-group">
					<label>วงเงินที่ต้องการกู้</label><span class="require-red">*</span>
					<input type="text" class="form-control"
						value="<%=bean.getLessmoney()%>" disabled="disabled">
				</div>
			</div>
			<div class="col-md-5 col-sm-5 col-xs-12">
				<div class="form-group">
					<label>ระยะเวลากู้</label><span class="require-red">*</span> <input
						type="text" class="form-control" value="<%=bean.getLessyear()%>"
						disabled="disabled">
				</div>
			</div>
		</div>
		<!-- stap3 -->
		<div class="row">
			<div
				class="col-md-11 col-md-offset-1 col-sm-11 col-xs-12 col-sm-offset-1">
				<div style="margin: 15px 0px 0px 0px;">
					<label>วัตถุประสงค์การขอสินเชื่อ<span class="require-red">*</span>
						(เลือกได้มากกว่า 1 ข้อ)
					</label>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="form-group">
					&nbsp;&nbsp; <input type="checkbox" value="" class="w3-check">
					<label>ปิดสินเชื่อสถาบันการเงินอื่น (เช่น บัตรเครดิต
						สินเชื่อบุคคล รถยนต์ บ้าน)</label>

				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="form-group">
					&nbsp;&nbsp; <input type="checkbox" value="" class="w3-check">
					<label>ปิดหนี้สินเชื่ออื่นๆที่ไม่ใช่สถาบันการเงิน (เช่น
						ขายฝาก / จำนองกับบุคคลภายนอก)</label>

				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="form-group">
					&nbsp;&nbsp; <input type="checkbox" value="" class="w3-check">
					<label>ปิดหนี้ธุรกิจ / SME / กิจการ / OD</label>

				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-group">
					&nbsp;&nbsp; <input type="checkbox" value="" class="w3-check">
					<label>จับจ่ายใช้สอยทั่วไป</label>
				</div>
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12 ">
				<div class="form-group other-field" style="margin-bottom: 15px;">
					<label>โปรดระบุ</label><span class="require-red">*</span> <input
						type="text" class="form-control-static textAlign-left"
						disabled="disabled">
				</div>
			</div>
		</div>
		<!-- stap4 -->
		<br>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<input  type="submit" value="หน้าต่อไป"
					class="btn btn-success btn-lg btn-block" >
				
					
			</div>
		</div>
	</div>

</form>

