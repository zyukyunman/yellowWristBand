/**
 * 
 */
     function getName()
     {  
		
   	    xmlhttp=ajax();
   	    xmlhttp.open("get","user/session.do",false);
   	    xmlhttp.onreadystatechange=function(){
   	     if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
   	    	res=xmlhttp.responseText;
   	    	json=JSON.parse(res);
   	    	document.getElementById("hello").innerHTML="你好，"+json.uname
   	    }
   	 } 
   	    xmlhttp.send();
     }



	