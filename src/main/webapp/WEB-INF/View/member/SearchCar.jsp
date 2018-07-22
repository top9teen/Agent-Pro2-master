<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>



<form name="gotobank" action="gotobank" method="post"
	OnSubmit="return fncSubmit2();">
	<div class="panel panel-primary " style="margin-top: 15%">
		<div class="panel-heading" align="center">กรุณาเลือกรถยนต์รุ่นของท่าน</div>
		<div class="panel-body">
			<div class="form-group">
				<label for="registration_year">ปีที่จดทะเบียน (ค.ศ.)<span
					style="color: red;">* </span>:
				</label> <select class="form-control" name="groupType" id="groupType"
					list="groupTypeDropdown" listKey="value" listValue="name">
					<option value="">กรุณาเลือก</option>

				</select>
			</div>
			<div class="form-group">
				<label for="brand">ยี่ห้อ<span style="color: red;">*</span>:
				</label> <select name="carMake" id="brand" class="form-control">
					<option value="">กรุณาเลือก</option>

					<optgroup label="รถยนต์">
					</optgroup>
				</select>
			</div>
			<div class="form-group">
				<label for="brand">รุ่น<span style="color: red;">*</span>:
				</label> <select name="carMake2" id="carmodel" class="form-control">
					<option value="">กรุณาเลือก</option>
					<optgroup label="รุ่น">

					</optgroup>
				</select>
			</div>
			<div class="form-group">
				<label for="brand">วงเงินที่ท่านต้องการ<span
					style="color: red;">*</span>:
				</label> <input type="text" name="lessmoney" placeholder="ใส่จำนวนเงิน" id="monney" value="" class="form-control">
			</div>
			<div class="form-group">
				<label for="brand">ระยะเวลาที่ต้องการขอกู้<span
					style="color: red;">*</span>
				</label> <select name="lessyear" id="" class="form-control">
					<option value="">กรุณาเลือก</option>
					<optgroup label="ปี">
						<option value="1">1 ปี</option>
						<option value="2">2 ปี</option>
						<option value="3">3 ปี</option>
						<option value="4">4 ปี</option>
						<option value="5">5 ปี</option>
						<option value="6">6 ปี</option>
						
					</optgroup>
				</select>
			</div>
		</div>
		<div class="panel-footer" align="center"
			style="background: transparent;">
			<input type="submit" class="btn btn-success" value="ยืนยัน">&nbsp;
		</div>

	</div>
</form>

