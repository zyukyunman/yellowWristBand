/**
 * 
 */
function getAll() {
	xmlhttp = ajax();
	xmlhttp.open("get", "user/session.do", false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			res = xmlhttp.responseText;
			json =JSON.parse(res);
			document.getElementById("userfile").innerHTML = display2(json);
		}
	}
	xmlhttp.send();
}

function display2(json) {
	var content = "<table class="
			+ "table table-striped table-hover"
			+ " border=1> <thead><tr><th>姓名</th><th>性别</th><th>电话</th><th>地址</th></tr></thead>";
	content += "<tbody><tr><td>" + json.uname + "</td><td>" + json.sexy
			+ "</td><td>" + json.tele + "</td><td>" + json.address + "</td></tr></tbody>";
	content += "</table>";
	return content;
}
