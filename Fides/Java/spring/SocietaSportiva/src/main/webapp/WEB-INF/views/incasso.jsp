<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Partite per Stadio</title>
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
		<div align="center">
			<c:choose>
				<c:when test="${!empty stadio}">
					<c:choose>
						<c:when test="${!empty incasso}">
							<h2>Incasso per Stadio: ${stadio.nome}</h2>
							<p>${incasso} €</p>
						</c:when>
						<c:otherwise>
							<h2>Incasso per ${stadio.nome}</h2>
							<p>Non sono stati rilevati incassi per questo stadio</p>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<h3 class="incassi">Incasso Totale: </h3>
					<h3 class="incassi">${incasso} €</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>