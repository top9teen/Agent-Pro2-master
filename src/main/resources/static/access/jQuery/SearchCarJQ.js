		$(document).ready(function() {
			
			
// 			$('.groupType').select2();
			anElement = new AutoNumeric("#monney");
			
			
			$.ajax({
				type : "GET",
				url : "/year",
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(msg) {
					console.log('Success')
					for(var i=0; i<msg.length; i++) {
						$('#groupType').append('<option value="' + msg[i].yeYear+ '">' + msg[i].yeYear + '</option>');
					}
					
				}
			});
			
			$('#groupType').change(function () {
				$('#brand').empty();
				$('#carmodel').empty();
			
				var criteriaBean = { "year" :  $('#groupType').val()};
				
				$.ajax({
					type : "POST",
					url : "/brand",
					data: JSON.stringify(criteriaBean) ,
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					success : function(msg) {
						console.log('Success')
						$('#brand').append('<option value="'+'">' + "กรุณาเลือก" + '</option>');
						$('#carmodel').append('<option value="'+'">' + "กรุณาเลือก" + '</option>');
						for(var i=0; i<msg.length; i++) {
							$('#brand').append('<option value="' + msg[i].carName+ '">' + msg[i].carName + '</option>');
						}
						
					}
				});
			});

			$('#brand').change(function(){
				$('#carmodel').empty();
				var criteriaBean = {"year" : $('#groupType').val() 
									, "brand" : $('#brand').val() };
				$.ajax({
					type : "POST",
					url : "/carmodel",
					data: JSON.stringify(criteriaBean) ,
					contentType : "application/json; charset=utf-8",
					dataType : "json",

				success : function(msg) {
						console.log('Success')
						$('#carmodel').append('<option value="'+'">' + "กรุณาเลือก" + '</option>');
						for(var i=0; i<msg.length; i++) {
							$('#carmodel').append('<option value="' + msg[i].brName+ '">' + msg[i].brName + '</option>');
						}
						
					}
				});
		});	
			
	});