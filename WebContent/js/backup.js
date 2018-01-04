/**
 * 
 */
function backup(){
	var xmlhttp; // 定义一个AJAX对象
	var res;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var uri = "user/backup.do"
	xmlhttp.open("get", uri, false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			res = xmlhttp.responseText;
			if (res == "no")
				document.getElementById("backup").innerHTML = "对不起，无此权限";
			else {
				document.getElementById("backup").innerHTML = "数据备份成功";
			}

		} else {
			document.getElementById("backup").innerHTML = "正在处理......";
		}
	}
	xmlhttp.send();
}