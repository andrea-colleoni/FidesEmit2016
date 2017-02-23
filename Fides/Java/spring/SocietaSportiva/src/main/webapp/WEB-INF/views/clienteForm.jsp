<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Aggiungi/Modifica Cliente</title>
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
        <h1>Registrazione</h1>
        <form:form action="updateCliente" method="post" modelAttribute="cliente">
        <table>
            <form:hidden path="idCliente"/>
            <tr>
                <td>Nome:</td>
                <td><form:input path="nome" /></td>
            </tr>
            <tr>
                <td>Cognome:</td>
                <td><form:input path="cognome" /></td>
            </tr>
            <tr>
            	<td>Username:</td>
            	<td><form:input path="username" /></td>
            <tr>
             <tr>
            	<td>Password:</td>
            	<td><input type="password" name="psw" /></td>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>