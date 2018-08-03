$(document).ready(
		function() {

			
		
			$.ajax({
				type : "GET",
				url : "/province",
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(msg) {
					console.log('Success')
					$('#province').append(
							'<option value="' + '">' + "กรุณาเลือก" + '</option>');
					$('#amphur').append(
							'<option value="' + '">' + "กรุณาเลือก"
									+ '</option>');
					$('#district').append(
							'<option value="' + '">' + "กรุณาเลือก"
									+ '</option>');
					for (var i = 0; i < msg.length; i++) {
						$('#province').append(
								'<option value="' + msg[i].provinceId + '">'
										+ msg[i].provinceName + '</option>');
					}

				}
			});

			$('#province').change(
					function() {
						$('#amphur').empty();
						$('#district').empty();
						var criteriaBean = {
							"xxx" : $('#province').val()
						};

						$.ajax({
							type : "POST",
							url : "/amphur",
							data : JSON.stringify(criteriaBean),
							contentType : "application/json; charset=utf-8",
							dataType : "json",
							success : function(msg2) {
								console.log('Success')
								$('#amphur').append(
										'<option value="' + '">' + "กรุณาเลือก"
												+ '</option>');
								$('#district').append(
										'<option value="' + '">' + "กรุณาเลือก"
												+ '</option>');
								for (var i = 0; i < msg2.length; i++) {
									$('#amphur').append(
											'<option value="'
													+ msg2[i].amphurId + '">'
													+ msg2[i].amphurName
													+ '</option>');
								}

							}
						});
					});

			$('#amphur').change(
					function() {
						$('#district').empty();
						var criteriaBean = {
							"xxx" : $('#amphur').val()
						};
						$.ajax({
							type : "POST",
							url : "/district",
							data : JSON.stringify(criteriaBean),
							contentType : "application/json; charset=utf-8",
							dataType : "json",

							success : function(msg3) {
								console.log('Success')
								$('#district').append(
										'<option value="' + '">' + "กรุณาเลือก"
												+ '</option>');
								for (var i = 0; i < msg3.length; i++) {
									$('#district').append(
											'<option value="'
													+ msg3[i].districtId + '">'
													+ msg3[i].districtName
													+ '</option>');
								}

							}
						});
					});

		});