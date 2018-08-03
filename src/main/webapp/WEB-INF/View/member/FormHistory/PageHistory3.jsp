<%@page import="com.test.Bean.SaveTable1Bean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<form action="" OnSubmit="return  fncSubmit4();" name="gotopage4">
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
								class="form-control fontSize-s fontFamily-thonburi boxShadow-none ng-pristine ng-untouched ng-valid ng-not-empty"
								name="propertyProjectName">
						</div>
					</div>
				</div>
				<div class="col-md-5 col-sm-5 col-xs-12">
					<div class="form-group">
						<label>จังหวัด</label><span class="require-red">*</span>
						<div class="select select-center paddingTop-1 select-diasbled">
							<select
								class="fontSize-s fontFamily-thonburi form-control"
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
							<select
								class="fontSize-s fontFamily-thonburi form-control"
								name="amphur" id="amphur">
							
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-5 col-sm-5 col-xs-12">
					<div class="form-group">
						<label>ตำบล</label><span class="require-red">*</span>
						<div class="select select-center paddingTop-1 select-diasbled">
							<select
								class="fontSize-s fontFamily-thonburi form-control"
								name="district" id="district">
								
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-1 col-sm-5 col-xs-10"></div>
				<div class="col-md-2 col-sm-5 col-xs-10">
				
				</div>
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
								name="radio2" value="2"
								class="ng-pristine ng-untouched ng-valid ng-not-empty">
								<span class="checkmark">ไม่มี</span>
							</label>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-md-8 col-sm-3 form-control-field">
					<div class="form-group">
						<label class="containerRadio"> <input type="radio"
							name="radio2" value="1"
							class="ng-pristine ng-untouched ng-valid ng-not-empty">
							<span class="checkmark">มีผู้กู้ร่วม</span>
							
						</label>
					</div>
				</div>
			
			</div>
			<div class="row">
						
						
						<div class="col-md-12 ">
				<input  type="submit" value="หน้าต่อไป"
					class="btn btn-success btn-lg btn-block" >
				
			</div>
						</div>
		</div>
	</div>
</form>
<script type="text/javascript" src="access/jQuery/province.js">

</script>
<script type="text/javascript">
	function fncSubmit4() {
		if (document.gotopage4.propertyProjectName.value == "") {
			alert('กรุณาใส่ชื่อบ้าน');
			document.gotopage4.propertyProjectName.focus();
			return false;
		}
		
	}
	
</script>