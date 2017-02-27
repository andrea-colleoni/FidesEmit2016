<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     	<title>Società Sportiva</title>
        <link href="<c:url value='/resources/style.css' />" rel="stylesheet"></link>
        <script src="resources/script.js"></script>
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
        <div>
	        <h1>Stadi</h1>
	        <security:authorize access="hasRole('ROLE_ADMIN')">
					<h3><a href="nuovoStadio" class="reglink">Nuovo Stadio</a></h3>
					<div id="incasso">
						<button type="button"  value="totali" onclick="incassi(this.value)">Incasso Totale</button>
						<!-- <button type="button" value="parziali" onclick="incassi(this.value)">Parziali</button> -->
					</div>	
			</security:authorize>
		</div>
	
	<div>
		<table class="data">
          	<tr class="descriptor">
          		<th>N</th>       
            	<th>Nome</th>
            	<th>ID</th>
            	<th>Indirizzo</th>
            	<th>Città</th>
            	<th>Capienza</th>
            	<security:authorize access="hasRole('ROLE_ADMIN')">
            		<th>Gestore</th>
	            	<th>Aggiorna</th>
	            	<th>Elimina</th>
	            	<th>Incasso</th>
	            </security:authorize>
            </tr>
            <c:forEach var="stadio" items="${listStadi}" varStatus="status" >
            <tr>
            	<td>${status.index + 1}</td>
                <td>${stadio.nome}</td>
                <td>${stadio.idStadio}</td>
                <td>${stadio.indirizzo}</td>
                <td>${stadio.citta}</td>
                <td>${stadio.capienza}</td>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                	<td>${stadio.idGestoreStadioFK}</td>
	                <td><a href="/SocietaSportiva/aggStadio?id_stadio=${stadio.idStadio}" class="reglink">Aggiorna</a></td>
	                <td><a href="/SocietaSportiva/deleteStadio?id_stadio=${stadio.idStadio}" class="reglink">Elimina</a></td>
	                <td><a href="/SocietaSportiva/showIncome?id=${stadio.idStadio}" class="buylink">Mostra</a>	             
	            </security:authorize>
            </tr>
            </c:forEach>          
        </table>
     </div>
     
     <div class="container" align="center">
		<c:choose>
			<c:when test="${!empty stadio}">
				<c:choose>
					<c:when test="${!empty incasso}">
						<h2>Incasso per Stadio: ${stadio.nome}</h2>
						<h3>${incasso} €</h3>
						</c:when>
					 	<c:otherwise>
						<h2>Incasso per ${stadio.nome}</h2>
						<h3>Non sono stati rilevati incassi per questo stadio</h3>
					</c:otherwise>
				</c:choose>
			</c:when>
		</c:choose>
	</div>
        
  </div>
</body>
</html>
