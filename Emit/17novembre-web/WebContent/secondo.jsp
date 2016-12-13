<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
h2 {
	width: 400px;
	background-color: yellow;
	font-size: 36px;
	height: 100px;
	border: 3px dotted red;
}
</style>
</head>
<body>
<% for(int i = 0; i < 100; i++) { %>
<h2>Testo testo testo <%= i %></h2>
<h3><% if (i%2==0)  {%> PARI <%} else { %> DISPARI <% } %></h3>
<% } %>
<button onmouseover="faiClick();" id="ilBottone">Cliccami!!</button>
<script>
	function faiClick() {
		alert('Mi hai cliccato! Bravo!!!');
		var btn = document.getElementById('ilBottone');
		btn.innerHTML = 'Mi hai cliccato!!!';
	}
</script>
</body>
</html>