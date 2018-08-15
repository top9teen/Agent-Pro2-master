<%@page import="com.test.Bean.SaveTable1Bean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<form action="register" OnSubmit="return  fncSubmit4();"
	name="gotopage4">
	<div class="w3-modal-content w3-card w3-animate-bottom">
		<div class="form-section form-position">
			<h2 class="fs-title-sec2">4. ที่อยู่สำหรับที่จะนำมาขอสินเชื่อ</h2>
			<div class="row">
				<div
					class="col-md-5 col-md-offset-1 col-sm-5 col-sm-offset-1 col-xs-12">
					<div class="form-group">
						<label>ชื่อบ้าน</label><span class="require-red">*</span>
						<div
							class="input textAlign-left position-relative select-diasbled">
							<input type="text"
								class="form-control fontSize-s fontFamily-thonburi boxShadow-none"
								name="propertyProjectName" id="propertyProjectName">
						</div>
					</div>
				</div>
				<div class="col-md-5 col-sm-5 col-xs-12">
					<div class="form-group">
						<label>จังหวัด</label><span class="require-red">*</span>
						<div class="select select-center paddingTop-1 select-diasbled">
							<select class="fontSize-s fontFamily-thonburi form-control"
								name="province" id="province">

							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div
					class="col-md-5 col-md-offset-1 col-sm-5 col-sm-offset-1 col-xs-12">
					<div class="form-group">
						<label>อำเภอ</label><span class="require-red">*</span>
						<div class="input textAlign-left position-relative">
							<select class="fontSize-s fontFamily-thonburi form-control"
								name="amphur" id="amphur">

							</select>
						</div>
					</div>
				</div>
				<div class="col-md-5 col-sm-5 col-xs-12">
					<div class="form-group">
						<label>ตำบล</label><span class="require-red">*</span>
						<div class="select select-center paddingTop-1 select-diasbled">
							<select class="fontSize-s fontFamily-thonburi form-control"
								name="district" id="district">

							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-1 col-sm-5 col-xs-10"></div>
				<div class="col-md-2 col-sm-5 col-xs-10"></div>
			</div>
		</div>
		<!-- stap2 -->
		<div class="form-section form-position">
			<h2 class="fs-title-sec2">5. ผู้กู้ร่วม</h2>
			<div class="row">
				<div
					class="col-xs-12 col-md-2 col-md-offset-1 col-sm-2 col-sm-offset-1 form-control-field">
					<div class="form-group">
						<div>
							<label class="containerRadio"> <input type="radio"
								name="Radio" value="1" class="" id="Radio" required> <span
								class="checkmark">มีผู้กู้ร่วม</span>
							</label>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-md-8 col-sm-3 form-control-field">
					<div class="form-group">
						<label class="containerRadio"> <input type="radio"
							name="Radio" value="2" class="" id="Radio" required
							checked="checked"> <span class="checkmark">ไม่มี</span>

						</label>
					</div>
				</div>

			</div>
			<div class="box" style="display: none;">
				<%@include file="PageHistory4.jsp"%>
			</div>
			<div class="row">


				<div class="col-md-12 ">
					<input type="submit" value="ส่งข้อมูล"
						class="btn btn-success btn-lg btn-block">

				</div>
			</div>
		</div>
	</div>




</form>

<script type="text/javascript" src="access/jQuery/province.js">

</script>
<script type="text/javascript">
$(document).ready(function () {


	
    $('input[type="radio"]').click(function () {
        if ($(this).attr("value") == "2") {
            $(".box").hide('slow');
        }
        if ($(this).attr("value") == "1") {
            $(".box").show('slow');

        }
    });

 /*    $('input[type="radio"]').trigger('click');  // trigger the event */
	anElement = new AutoNumeric("#salary2");
});

	function fncSubmit4() {
		var propertyProjectName = document.getElementById('propertyProjectName').value;
		var fname2 = document.getElementById('fname2').value;
		var lname2 = document.getElementById('lname2').value;
		
		if (!propertyProjectName.match(/^([ก-๙])+$/i)) {
			alert('กรุณาใส่ชื่อบ้านภาษาไทยเท่านั้น');
			document.gotopage4.propertyProjectName.focus();
			return false;
		}
		
		if (document.gotopage4.province.value == "") {
			alert('กรุณาเลือกจังหวัด');
			document.gotopage4.province.focus();
			return false;
		}
		
		if (document.gotopage4.amphur.value == "") {
			alert('กรุณาเลือกอำเภอ');
			document.gotopage4.amphur.focus();
			return false;
		}
		if (document.gotopage4.district.value == "") {
			alert('กรุณาเลือกตำบล');
			document.gotopage4.district.focus();
			return false;
		}
		if(document.gotopage4.Radio.value == "1"){
			// ck ผู้ร่วมกู้
			if (document.gotopage4.prefix2.value == "") {
				alert('กรุณาเลือกคำนำหน้า');
				document.gotopage4.prefix2.focus();
				return false;
			}
			if (!fname2.match(/^([a-zA-Zก-๙])+$/i)) {
				alert('กรุณาใส่ชือ');
				document.gotopage4.fname2.focus();
				return false;
			}
			if (!lname2.match(/^([a-zA-Zก-๙])+$/i)) {
				alert('กรุณาใส่นามสกุล');
				document.gotopage4.lname2.focus();
				return false;
			}
			if (document.gotopage4.birthDay2.value == "") {
				alert('กรุณาเลือกวันเกิด');
				document.gotopage4.birthDay2.focus();
				return false;
			}
			if (document.gotopage4.birthMonth2.value == "") {
				alert('กรุณาเลือกเดือนเกิด');
				document.gotopage4.birthMonth2.focus();
				return false;
			}
			if (document.gotopage4.birthYear2.value == "") {
				alert('กรุณาเลือกปีเกิด');
				document.gotopage4.birthYear2.focus();
				return false;
			}
			if (isNaN(document.gotopage4.talaphone2.value)) {
				alert('กรุณาใส่เบอร์โทร');
				document.gotopage4.talaphone2.focus();
				return false;
			}
			
			if ((document.gotopage4.talaphone2.value.length < 10)  || (document.gotopage4.talaphone2.value.length > 10) ) {
				alert('กรุณา ใส่เบอร์โทรให้ครบ');
				document.gotopage4.talaphone2.focus();
				return false;
			}
			
			if (document.gotopage4.email2.value == "") {
				alert('กรุณาใส่ Email');
				document.gotopage4.email2.focus();
				return false;
			}
			if (document.gotopage4.job2.value == "") {
				alert('กรุณาใส่ อาชีพ');
				document.gotopage4.job2.focus();
				return false;
			}
			if (document.gotopage4.salary2.value == "") {
				alert('กรุณาใส่เงินเดือน');
				document.gotopage4.salary2.focus();
				return false;
			}
			if (document.gotopage4.yearOfService2.value == "") {
				alert('กรุณาใส่ปีที่ทำงาน');
				document.gotopage4.yearOfService2.focus();
				return false;
			}
			if (document.gotopage4.monthOfService2.value == "") {
				alert('กรุณาใส่เดือนที่ทำงาน');
				document.gotopage4.monthOfService2.focus();
				return false;
			}
			
			
			if (document.gotopage4.email2.value.indexOf('@')==-1) {
				alert('อีเมล์ของคุณไม่ถูกต้อง');
				document.gotopage4.email2.focus();
				return false;
			}
			if (document.gotopage4.email2.value.indexOf('.')==-1) {
				alert('อีเมล์ของคุณไม่ถูกต้อง');
				document.gotopage4.email2.focus();
				return false;
			}
		}
	}
	
</script>