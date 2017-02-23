<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Lista Partite</title>
		<link href="<c:url value='/resources/style.css'/>" rel="stylesheet"></link>
    </head>
	<body>
		<div class="menuWrap">
		<ul>
			<li><a class="active" href="/SocietaSportiva">Home</a></li>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="/SocietaSportiva/clienti">Clienti</a></li>
			</security:authorize>
			<li><a href="/SocietaSportiva/partite">Partite</a></li>
			<li><a href="/SocietaSportiva/stadi">Stadi</a></li>
			
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<li class="userAreaButton"><a href="/SocietaSportiva/login">Login</a></li>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<li class="userAreaButton"><a href="/SocietaSportiva/areapersonale?username=${pageContext.request.userPrincipal.name}">${pageContext.request.userPrincipal.name}</a>
					<ul>
						<li><a href="/SocietaSportiva/areapersonale?username=${pageContext.request.userPrincipal.name}">Area Personale</a></li>
						<li><a href="${pageContext.request.contextPath}/logout?${_csrf.parameterName}=${_csrf.token}">Logout</a></li>
					</ul>
				</li>
			</c:if>
		</ul>
	</div>
	
		<div class="container" align="center">
		<h1>Partite</h1>
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<h3><a href="/SocietaSportiva/newPartita" class="reglink">Nuova Partita</a></h3>
		</security:authorize>
		<c:if  test="${!empty ListPartite}">
			<table class="data">
				<tr class = "descriptor">
					<th>Id partita</th>
					<th>Id stadio</th>
					<th>Data</th>
					<th>Squadra</th>
					<th>Azioni</th>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<th>Sconto</th>
					</security:authorize>
				</tr>
				<c:forEach items="${ListPartite}" var="partite">
					<tr>
						<td>${partite.idPartita}</td>
						<td>${partite.idStadioPartitaFK}</td>
						<td>${partite.data}</td>
						<td>${partite.squadra}</td>
						<td>
							<security:authorize access="hasRole('ROLE_ADMIN')">
							<a href="/SocietaSportiva/editPartita?id=${partite.idPartita}" class="reglink">Modifica</a>
                   			&nbsp;&nbsp;&nbsp;&nbsp;
                   			<a href="/SocietaSportiva/deletePartita?id=${partite.idPartita}" class="reglink">Elimina</a>
                   			&nbsp;&nbsp;&nbsp;&nbsp;
                    		</security:authorize>
							<a href="/SocietaSportiva/compraBiglietto?id=${partite.idPartita}" class="buylink">Compra Biglietto</a>
						</td>
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<td>
						<form action="sconto" method="GET">
							<select name="sconto">
								<option value="NONE">Valore dello sconto</option>
								<option value="10">10%</option>
								<option value="15">15%</option>
								<option value="25">25%</option>
							</select>
							<input type='hidden' name='id' value='${partite.idPartita}'/>
							<input type="submit" value="Applica sconto" class="buylink"/>
						</form>
						</td>
						</security:authorize>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		</div>
	</body>
</html>