/**
 * 
 */
function myInfo() {
	xmlhttp = ajax();
	xmlhttp.open("get", "user/session.do", false);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			res = xmlhttp.responseText;
			json = JSON.parse(res);
			document.getElementById("uname").value = json.uname;
			document.getElementById("sexy").value = json.sexy;
			document.getElementById("usertele").value = json.tele;
			document.getElementById("useraddress").value = json.address;
		}
	}
	xmlhttp.send();
}