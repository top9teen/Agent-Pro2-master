<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<jsp:include page="../Template/Header.jsp"></jsp:include>
<style type="text/css">
body {
    /* The image used */

	
    /* Full height */
    height: 100%; 
     margin: 0;


    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}

</style>
<title>ReFinder</title>
</head>

<body>
<a href="javascript:genPDF()">PDF</a>
<h1 align="left">ใบเสร็จ1</h1>
<h2 align="center">ใบเสร็จ2</h2>
<h3 align="right">ใบเสร็จ3</h3>
<h4 align="center">ใบเสร็จ4</h4>


</body>

<script type="text/javascript">




/* 	function genPDF() {
		var doc = new jsPDF();
		 
		html2canvas(document.body,{
			
			onrendered: function (canvas) {
				
				
				doc.addHTML($('#te2'), 15, 15, function() {
					doc.save('ใบเสร็จ.pdf');
				});
				
				
			}
		});
		
	} */
	function genPDF() {
		html2canvas(document.body, {
			onrendered: function (canvas) {
				var img = canvas.toDataURL("image");
				var doc = new jsPDF();
				
				/* doc.addHTML($('#test'), 15, 15, function() {
					doc.save('ใบเสร็จ.pdf');;
				}); */
				doc.addImage(img,'JPEG',20,20);
			
				doc.save('ใบเสร็จ.pdf');
			}
		});
		
	}

	</script>
<jsp:include page="../Template/Footer.jsp"></jsp:include>
</html>