<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
	<body>
		<div align="center">
		<table class="data">
			<tr class="descriptor">
				<th>Partita</th>
				<th>Stadio</th>
				<th>Data</th>
				<th>Squadra</th>
			</tr>
						
			<c:forEach items="${ListCrono}" var="partite">
				<tr>
					<td>${partite.idPartita}</td>
					<td>${partite.idStadioPartitaFK}</td>
					<td>${partite.data}</td>
					<td>${partite.squadra}</td>
				</tr>
			</c:forEach>
			
			<c:forEach items="${ListCresc}" var="partite">
				<tr>
					<td>${partite.idPartita}</td>
					<td>${partite.idStadioPartitaFK}</td>
					<td>${partite.data}</td>
					<td>${partite.squadra}</td>
				</tr>
			</c:forEach>
			
			<c:forEach items="${ListIdStadio}" var="partite">
				<tr>
					<td>${partite.idPartita}</td>
					<td>${partite.idStadioPartitaFK}</td>
					<td>${partite.data}</td>
					<td>${partite.squadra}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</body>
</html>