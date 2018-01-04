/**
 * 
 */
function Verify() {
		var xmlhttp; //定义一个AJAX对象
		var res;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5 
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		var userID = document.getElementById("userID").value;
		var pwd = document.getElementById("pwd").value;
		var uri = "user/login.do?userID=" + userID + "&pwd=" + pwd;
		xmlhttp.open("get",uri,false);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				res = xmlhttp.responseText;
				if(res=="yes") window.location.href="success.html";
				else
				document.getElementById("login").innerHTML = "账号信息错误，请输入正确信息或注册！";				
			} else {
				document.getElementById("login").innerHTML = "正在处理......";
			}
		}		
		xmlhttp.send();
	}