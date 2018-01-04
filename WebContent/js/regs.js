/**
 * 
 */
var duplication = true;
var connect = false;
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

function reg() {
	var res;
	var xmlhttp = ajax();
	var userID = document.getElementById("userID").value;
	var pwd = document.getElementById("pwd").value;
	var uname = document.getElementById("uname").value;
	var tele = document.getElementById("tele").value;
	var sexy = document.getElementById("sexy").value;
	var address = document.getElementById("address").value;
	var uri = "user/reg.do?userID=" + userID + "&pwd=" + pwd + "&uname=" + uname
			+ "&tele=" + tele + "&sexy=" + sexy + "&address=" + address;
	xmlhttp.open("get", uri, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			res = xmlhttp.responseText;
			if (res == "yes")
				window.location.href = "success.html";
		} else {
			document.getElementById("MyDuplicate").innerHTML = "正在处理......";
		}
	}
	xmlhttp.send();
}

function duplicate() {
	var res;
	var xmlhttp = ajax();
	var userID = document.getElementById("userID").value;
	var uri = "user/duplicate.do?userID="+userID;
	xmlhttp.open("get", uri, false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			res = xmlhttp.responseText;
			if (res == "ok") {
				duplication = false;
				connect = true;
				document.getElementById("MyDuplicate").innerHTML = "恭喜你！可使用此帐号";
			}
			else
				document.getElementById("MyDuplicate").innerHTML = "已存在此账号，请更换账号";
		} else {
			document.getElementById("MyDuplicate").innerHTML = "正在处理......";
		}
	}
	xmlhttp.send();
}

function test() {
	duplicate();
	if (duplication&&connect) {
		alert("已存在此账号，请更换账号")
		document.getElementById("MyDuplicate").innerHTML = "已存在此账号，请更换账号";
	} else
		reg();
}