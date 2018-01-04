/**
 * 
 */
var res;
function setmyfile(){
	    xmlhttp=ajax();
	    getUserIDAndPwd();
    	json=JSON.parse(res);
	    var userID = json.userID;
	    var uname = document.getElementById("uname").value;
	    var sexy = document.getElementById("sexy").value;
	    var address = document.getElementById("useraddress").value;
	    var tele = document.getElementById("usertele").value;
	    var uri ="user/set.do?uname=" + uname + "&sexy=" + sexy + "&address=" + address
	                                          + "&tele=" + tele
	                                          + "&userID=" + userID	    
	    xmlhttp.open("get",uri,false);
	    xmlhttp.onreadystatechange=function(){
	     if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
	    	window.location.href="success.html";
	    }else {
			document.getElementById("set").innerHTML = "正在处理......";
		}
	     
	 } 
	    xmlhttp.send();
}

function getUserIDAndPwd()
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