<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sport Home</title>
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
        <h1>Clienti</h1>
        <h3><a href="nuovoCliente" class="reglink">Nuovo Cliente</a></h3>
        <table class="data">
        	<tr class = "descriptor">
	            <th>ID</th>
	            <th>Nome</th>
	            <th>Cognome</th>
	            <th>Azioni</th>
	            <th>Area Personale</th>
            </tr>
            <c:forEach var="cliente" items="${listClienti}">
            <tr>
                <td>${cliente.idCliente}</td>
                <td>${cliente.nome}</td>
                <td>${cliente.cognome}</td>
                <td>
                    <a href="/SocietaSportiva/editCliente?id=${cliente.idCliente}" class="reglink">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/SocietaSportiva/deleteCliente?id=${cliente.idCliente}" class="reglink">Delete</a>
                </td>
                <td>
                	<a href="/SocietaSportiva/areapersonale?id=${cliente.idCliente}" class="buylink">Vai</a>
                </td> 
            </tr>
            </c:forEach>             
        </table>
    </div>
</body>
</html>
