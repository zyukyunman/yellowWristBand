/**
 * 
 */
function getUserOneDayPosition() {
	var json;
	xmlhttp = ajax();
	var YYYY = document.getElementById("YYYY").value;
	var MM = document.getElementById("MM").value;
	if(MM<10) MM = "0" + document.getElementById("MM").value;
	var DD = document.getElementById("DD").value;
	if(DD<10) DD = "0" + document.getElementById("DD").value;
	var uri = "band/getBandOneDayPosition.do?YYYY=" + YYYY + "&MM=" + MM
			+ "&DD=" + DD;
	xmlhttp.open("get", uri, false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			res = xmlhttp.responseText;
			json = JSON.parse(res);
		} else {
			document.getElementById("set").innerHTML = "正在处理......";
		}
	}
	xmlhttp.send();
	return json;
}
