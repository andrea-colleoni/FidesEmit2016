<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Area personale gestore</title>
		<link href="<c:url value='/resources/style.css' />" rel="stylesheet"></link>
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
		<h2>Area personale gestore</h2>
<c:choose>
	<c:when  test="${!empty listStadi}">
			<table border="1" class="data">
        	<tr class = "descriptor">
         	   <th>Id Stadio</th>
         	   <th>Nome</th>
        	   <th>Indirizzo</th>
        	   <th>Città</th>
        	   <th>Capienza</th>
            </tr> 
            <c:forEach var="stadio" items="${listStadi}">
            <tr>
                <td>${stadio.idStadio}</td>
                <td>${stadio.nome}</td>
                <td>${stadio.indirizzo}</td>
                <td>${stadio.citta}</td>
                <td>${stadio.capienza}</td>
                
                <td>
                	<a href="/SocietaSportiva/aggStadio?id_stadio=${stadio.idStadio}">Modifica</a>
                </td>     
            </tr>
            </c:forEach>             
        </table>
	</c:when>
	<c:otherwise>
		<p>Non hai ancora nessuno stadio.</p>
	</c:otherwise>
</c:choose>
		</div>
	</body>
</html>