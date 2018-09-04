  window.fbAsyncInit = function () {
	  FB.init({ appId: '259177254718154', status: true, cookie: true,
	  xfbml: true
	});

	  FB.getLoginStatus(function (response) {
		
	    if (response != null) {
	      greet();
	      
	    }
	    else if (response && response.status === 'connected') {
            FB.logout(function(response) {
            	 window.location.href = "/";
            });
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
		  var n = confirm("เข้าสู่ระบบด้วย Facebook !");
	        if (n == true) {
	        	  document.getElementById("regid").value = response.email;
			     	document.welcome.action = "facebook"; 
			    	document.welcome.submit();  
	        } else {
	        	
	            FB.Event.subscribe('auth.logout', function(response) {                                              
		            FB.logout(function(response) {
		            	 window.location.href = "/";
		            });
		        });
	           
	              
	               
	                   

	}
	
});
	};
