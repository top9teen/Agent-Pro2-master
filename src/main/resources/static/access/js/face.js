  window.fbAsyncInit = function () {
	  FB.init({ appId: '259177254718154', status: true, cookie: true,
	  xfbml: true
	});

	  FB.getLoginStatus(function (response) {
	    if (response != null) {
	      greet();
	      
	    }
	
	    
	  });
	};
	(function () {
	  var e = document.createElement('script');
	  e.type = 'text/javascript';
	  e.src = document.location.protocol +
	  '//connect.facebook.net/en_US/all.js';
	  e.async = true;
	  document.getElementById('fb-root').appendChild(e);
	} ());

	function greet() {
	  FB.api('/me',{ locale: 'en_US', fields: 'name, email' }, function (response) {
		  if(response.email != null){
			   document.getElementById("regid").value = response.email;
		     	document.welcome.action = "facebook"; 
		     	
		    	document.welcome.submit();  
			
		    	
			 }
		
		
			
		    	
	/* 	   document.getElementById("regid").value = response.email;
	     	document.welcome.action = "facebook"; */
	       console.log(response.email);
	      console.log(response.name);
	     
	/* 	document.welcome.submit();  */
	});

	}
	
