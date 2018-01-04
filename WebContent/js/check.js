/**
 * 
 */
function checkband() {
	var xmlhttp; // 定义一个AJAX对象
	var res;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var bandID = document.getElementById("bandID").value;
	var uri = "user/checkband.do?bandID=" + bandID
	xmlhttp.open("get", uri, false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			res = xmlhttp.responseText;
			if (res == "no")
				document.getElementById("check1").innerHTML = "查无此人，请填写正确信息";
			else {
				var json = eval("(" + res + ")");
	   	    	document.getElementById("All5").innerHTML=display(json);
	   	    	document.getElementById("All6").innerHTML='<button onclick="checkFamily()">查看家人信息</button>';
	   	    	
			}

		} else {
			document.getElementById("check1").innerHTML = "正在处理......";
		}
	}
	xmlhttp.send();
}

function checkFamily() {
	var xmlhttp; // 定义一个AJAX对象
	var res;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var bandID = document.getElementById("bandID").value;
	var uri = "user/check.do?bandID=" + bandID;
	xmlhttp.open("get", uri, false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			res = xmlhttp.responseText;
			
				var json1 = eval("(" + res + ")");
	   	    	document.getElementById("All6").innerHTML=displayFamily(json1);

		} else {
			document.getElementById("check1").innerHTML = "正在处理......";
		}
	}
	xmlhttp.send();
}

function display(json) {
	var content = "<table class="
			+ "table table-striped"
			+ " border=1> <thead><tr><th>致谢词</th><th>老人姓名</th><th>性别</th><th>年龄</th><th>地址</th></tr></thead>";
	content += "<tbody><tr><td>" + json.thanksgiving + "</td><td>" + json.bname
			+ "</td><td>" + json.sexy + "</td><td>" + json.age + "</td><td>"
			+ json.address+ "</td></tr></tbody>";
	content += "</table>";
	return content;

}
function displayFamily(json1)//列出所有管理员信息
{
	    var content="<table class="
			+ "table table-striped"
	    	+"border=1><thead> <th>家人姓名</th><th>性别</th><th>电话号码</th><th>地址</th><thead>";
		 for(var i=0;i<json1.length;i++)
	     {
			 content+="<tr><td>"+json1[i].uname+"</td><td>"+json1[i].sexy+"</td><td>"+json1[i].tele+"</td><td>"+json1[i].address+"</td><tr>";
	     }
		 content+="</table>";
		 return content;
} 