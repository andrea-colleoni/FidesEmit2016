/* Variabile globale e funzione per creare oggetto XMLHttpRequest */
var xmlHttp;
function createXMLHttpRequest() {
	xmlHttp = new XMLHttpRequest();
}

/* "PROSSIMI EVENTI" con AJAX */
function tab(value) {	
	createXMLHttpRequest();
	this.value=value;
	var queryString = "handlerTabelle?";
	queryString = queryString + "value=" + value;
	xmlHttp.onreadystatechange = callback;
	xmlHttp.open("GET", queryString, true);
	xmlHttp.send(null);
}

function callback() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
		document.getElementById("tabelle").innerHTML = xmlHttp.responseText;
	}
}

/* Partita by WEEK e per STADIO */
function perStadio() {
	createXMLHttpRequest();
	var id = document.getElementById("number").value;
	var queryString = "perstadio?";
	queryString = queryString + "id=" + id;
	xmlHttp.onreadystatechange = callback1;
	xmlHttp.open("GET", queryString, true);
	xmlHttp.send(null);
	
}

function callback1() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
		document.getElementById("settimanali").innerHTML = xmlHttp.responseText;
	}
}

function byWeek() {
	createXMLHttpRequest();
	var sett = document.getElementById("settimana").value;
	var queryString = "settimanali?";
	queryString = queryString + "week=" + sett;
	xmlHttp.onreadystatechange = callback2;
	xmlHttp.open("GET", queryString, true);
	xmlHttp.send(null);
}

function callback2() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
		document.getElementById("settimanali").innerHTML = xmlHttp.responseText;
	}
}