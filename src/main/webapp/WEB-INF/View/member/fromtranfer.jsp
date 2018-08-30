<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="access/css/A4.css">
<link rel="stylesheet" href="access/css/bootstrap.min.css">
		<div id="HTMLtoPDF">

	<h2  align="center">ใบเสร็จ</h2>

	<!--บันทึกขออนุญาตไปราชการ -->
	<div class="page">
<div class="row">
<div align="center" class="col-md-4">asdasdasdasd</div>
<div class="col-md-4">dsadsadsad</div>
<div class="col-md-4">asdasdasd</div>
</div>	<a  onclick="HTMLtoPDF()">Download PDF</a>
<a  href="javascript:genpdf()">Download PDF</a>
	<input type="button" value="Print Div Contents" id="btnPrint" />
</div>
		
	</div>
		<script type="text/javascript">
	

	
		 function genpdf() {
			 html2canvas(document.getElementById("HTMLtoPDF"), {
					onrendered: function(canvas){
						var pdf = new jsPDF('p', 'pt', 'letter', 'mm', 'a4');
						
						var  img = canvas.toDataURL("image/png");
						
						   
						  		pdf.addImage(img, 'JPEG',20,20);
						  	      pdf.save('ใบเสร็จ.pdf');
						      }
							
					});
		}
		    
	


</script>
<script type="text/javascript" src="access/js/html2canvas.js"></script>
<script type="text/javascript" src="access/js/jspdf.js"></script>