<%@page import="com.test.Bean.SaveTable1Bean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<form action="gotopage4">
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
								class="fontSize-s fontFamily-thonburi ng-pristine ng-untouched ng-valid ng-not-empty"
								name="properyType">
								<option value="">โปรดเลือก</option>
								<option value="1">บ้านเดี่ยว</option>
								<option value="2">บ้านแฝด</option>
								<option value="3">ทาวน์เฮ้าส์/ทาวน์โฮม</option>
								<option value="6">ห้องชุดพักอาศัย(คอนโดมิเนียม)</option>
								<option value="4">อาคารพาณิชย์/ตึกแถว(ใช้ประกอบธุรกิจ)</option>
								<option value="5">อาคารพาณิชย์/ตึกแถว(ใช้เป็นที่อยู่อาศัย)</option>
								<option value="7">อาคารพาณิชย์/ตึกแถว(ใช้ประกอบธุรกิจ+ใช้เป็นที่อยู่อาศัยเอง)</option>
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
								class="fontSize-s fontFamily-thonburi ng-pristine ng-untouched ng-valid ng-not-empty"
								name="properyType">
								<option value="">โปรดเลือก</option>
								<option value="1">บ้านเดี่ยว</option>
								<option value="2">บ้านแฝด</option>
								<option value="3">ทาวน์เฮ้าส์/ทาวน์โฮม</option>
								<option value="6">ห้องชุดพักอาศัย(คอนโดมิเนียม)</option>
								<option value="4">อาคารพาณิชย์/ตึกแถว(ใช้ประกอบธุรกิจ)</option>
								<option value="5">อาคารพาณิชย์/ตึกแถว(ใช้เป็นที่อยู่อาศัย)</option>
								<option value="7">อาคารพาณิชย์/ตึกแถว(ใช้ประกอบธุรกิจ+ใช้เป็นที่อยู่อาศัยเอง)</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-5 col-sm-5 col-xs-12">
					<div class="form-group">
						<label>ตำบล</label><span class="require-red">*</span>
						<div class="select select-center paddingTop-1 select-diasbled">
							<select
								class="fontSize-s fontFamily-thonburi ng-pristine ng-untouched ng-valid ng-not-empty"
								name="properyType">
								<option value="">โปรดเลือก</option>
								<option value="1">บ้านเดี่ยว</option>
								<option value="2">บ้านแฝด</option>
								<option value="3">ทาวน์เฮ้าส์/ทาวน์โฮม</option>
								<option value="6">ห้องชุดพักอาศัย(คอนโดมิเนียม)</option>
								<option value="4">อาคารพาณิชย์/ตึกแถว(ใช้ประกอบธุรกิจ)</option>
								<option value="5">อาคารพาณิชย์/ตึกแถว(ใช้เป็นที่อยู่อาศัย)</option>
								<option value="7">อาคารพาณิชย์/ตึกแถว(ใช้ประกอบธุรกิจ+ใช้เป็นที่อยู่อาศัยเอง)</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-1 col-sm-5 col-xs-10"></div>
				<div class="col-md-2 col-sm-5 col-xs-10">
					<div class="form-group">
						<label>รหัสไปรษณีย์</label><span class="require-red">*</span>
						<div class="input textAlign-left position-relative">
							<input type="text"
								class="form-control fontSize-s fontFamily-thonburi boxShadow-none ng-pristine ng-untouched ng-valid ng-isolate-scope ng-not-empty"
								name="deedAddressZipCode">
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- stap2 -->
		<div class="form-section form-position">
			<h2 class="fs-title-sec2">6. ผู้กู้ร่วม</h2>
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