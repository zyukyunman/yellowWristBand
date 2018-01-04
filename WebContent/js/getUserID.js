/**
 * 
 */
var res;
function getUserID()
{
	    xmlhttp=ajax();
	    xmlhttp.open("get","user/session.do",false);
	    xmlhttp.onreadystatechange=function(){
	     if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
	    	res=xmlhttp.responseText;
	    }
	 } 
	    xmlhttp.send();
}