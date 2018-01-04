/**
 * 
 */
 function ajax()
   {
	     var xmlhttp; //定义一个AJAX对象
		 if (window.XMLHttpRequest) 
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		     xmlhttp=new XMLHttpRequest(); 
		  } 
		else {// code for IE6, IE5 
		   xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
		} 
	   return xmlhttp;
   }
  