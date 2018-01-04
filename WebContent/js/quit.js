/**
 * 
 */
     function quit()
     {
   	    xmlhttp=ajax();
   	    xmlhttp.open("post","user/quit.do",true);		
   	    xmlhttp.send();
   	 xmlhttp.onreadystatechange = function() {
 		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
 			res = xmlhttp.responseText;
 			if(res=="ok") window.location.href="login.html";				
 		}
 	}		
     }