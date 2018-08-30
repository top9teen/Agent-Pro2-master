	function HTMLtoPDF() {
		html2canvasdocument.getElementById('HTMLtoPDF'), {
			onrendered: function(canvas){
				var pdf = new jsPDF('p', 'pt', 'letter', 'mm', 'a4');
				
				var  img = canvas.toDataURL("image/png");
				

				/*source = $('#HTMLtoPDF')[0];
				 specialElementHandlers = {
				 	'#bypassme': function(element, renderer){
				 		return true
				 	}
				}
				margins = {
				    top: 50,
				    left: 60,
				    width: 545
				  };
			
				pdf.fromHTML(
				  	source // HTML string or DOM elem ref.
				  	, margins.left // x coord
				  	, margins.top // y coord
				  	, {
				  		'width': margins.width // max width of content on PDF
				  		// , 'elementHandlers': specialElementHandlers
				  	},
				  	
				  	function (dispose) {
				  	  // dispose: object with X, Y of the last line add to the PDF
				  	  //          this allow the insertion of new lines after html
*/				   
				  		pdf.addImage(img, 'JPEG',20,20);
				  	  pdf.save('ใบเสร็จ.pdf');
				      }
				  )		
			}
			
		});
		
		
		}
