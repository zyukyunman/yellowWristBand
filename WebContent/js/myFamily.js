/**
 * 
 */
var res;
function myFamily() {
	var xmlhttp = ajax();
	getUserID();
	json = eval("(" + res + ")");
	var userID = json.userID;
	var uri = "user/familyDisplay.do?userID=" + userID;
	xmlhttp.open("get", uri, false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			res1 = xmlhttp.responseText;
			// alert(res1);
			json1 = eval("(" + res1 + ")");
			document.getElementById("Myfamily").innerHTML = display(json1);
		} else {
			document.getElementById("set").innerHTML = "正在处理......";
		}
	}
	xmlhttp.send();

}

function display(json) {
	var content = "<table class="
			+ "table table-striped"
			+ " border=1> <thead><tr><th>名字</th><th>关系</th><th>电话</th></tr></thead>";
	for (var i = 0; i < json.length; i++)
		content += "<tbody><tr><td>" + json[i].fname + "</td><td>"
				+ json[i].relationship + "</td><td>" + json[i].tele
				+ "</td></tr></tbody>";
	content += "</table>";
	return content;
}

function get() {
	xmlhttp = ajax();
	getUserID();
	json = JSON.parse(res);
	var userID = json.userID;
	var uri = "user/familyDisplay.do?userID=" + userID;
	xmlhttp.open("get", uri, false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			res = xmlhttp.responseText;
			json = JSON.parse(res);
			var family = document.getElementById("familyID");
			var relationship = document.getElementById("relationship");
			var fname = document.getElementById("fname");
			var tele = document.getElementById("tele");
			family.onchange = function(e) {
				let index = e.target.value;
				relationship.value = json[index].relationship;
				fname.value = json[index].fname;
				tele.value = json[index].tele;
			}
		}
	};
	xmlhttp.send();
}
