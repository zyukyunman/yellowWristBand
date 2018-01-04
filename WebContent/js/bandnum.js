	 function bandnum(){
        	var xmlhttp = ajax();
 			var res;
 			var uri = "user/bandnum.do"
 			xmlhttp.open("get", uri, false);
 			xmlhttp.onreadystatechange = function() {
 				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
 					res = xmlhttp.responseText;
 					json = JSON.parse(res);
 					document.getElementById("bandnum").innerHTML = json.length;
					 document.getElementById("band").innerHTML = display(json);
 				} else {
 					document.getElementById("bandnum").innerHTML = "正在处理......";
 				}
 			}
 			xmlhttp.send(); 
         }

		 function display(json) {
			 
	var content="";
	for (var i = 0; i < json.length; i++)
		content += "<label class='btn btn-default btn-lg'>"
                +  "<input type='radio' checked  >手环" + i+1
                +  "</label>";
	return content;
}