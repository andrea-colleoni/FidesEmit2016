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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="resources/script.js"></script>
        <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
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
	<img class="container" id="logo" src="<c:url value='/resources/images/fides.digital.png'/>" alt="Fides Digital">
		
		<!-- Partita by WEEK e per STADIO-->
		
		<div>
			<form:form method="get" modelAttribute="partitaByWeek">
				<input id="settimana" type="week" name="week" required 
				oninvalid="this.setCustomValidity('Inserisci una Settimana')"
	    		oninput="setCustomValidity('')" onchange="byWeek()" />
	        	<input type="submit" value="Partite per Settimana">
	       	</form:form>
		</div>
		
		<div>
			<form:form method="get" modelAttribute="partitaByStadio">
				<input id="number" min="1" max="100" type="number" name="id" required 
					oninvalid="this.setCustomValidity('Inserisci uno Stadio valido')"
	    			oninput="setCustomValidity('')" onclick="perStadio()"/>
	        	<input type="submit" value="Partite per Stadio">
	       	</form:form>
		</div>
	
		<div id="settimanali"></div>
					
		<!-- "PROSSIMI EVENTI" -->
		
		<div class="events" id="eventAjax">
			<h1>Prossimi Eventi</h1>
			<p>Scegli un ordine:</p>
			<button type="button" id="crono" value="crono" onclick="tab(this.value)">Cronologico</button>
			<button type="button" id="cresc" value="cresc" onclick="tab(this.value)">Alfabetico</button>
			<button type="button" id="id" value="id"  onclick="tab(this.value)">Stadio</button>
		</div>
		
		<div id="tabelle"></div>
		
	</body>
</html>