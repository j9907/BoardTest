<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<button id="btn1">버튼</button><div id="msg"></div>

<script>
	
	const clickHandler = function() {
		
		const request = new XMLHttpRequest();
		
		request.open('GET', '${pageContext.request.contextPath}/ajax1');
		
		request.onreadystatechange = function() {
			if(request.readyState == 4 && request.status == 200) {
				
				const data = request.responseText;
				console.log(data);
				document.getElementById('msg').innerText = data;
			}
		}
		request.send();
	}
	document.getElementById('btn1').onclick = clickHandler;

</script>

</body>
</html>