<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>risultati</title>
</head>
<body>

	<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Abitanti Risultato</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Eta'</th>
				<th>Residenza</th>
				<th>Municipio</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${listaAbitantiAttributeName}" var="abitante">
			<tr>
				<td>${abitante.nome}</td>
				<td>${abitante.cognome}</td>
				<td>${abitante.eta}</td>
				<td>${abitante.residenza}</td>
				<td>${abitante.municipio.descrizione}</td>
				<td>
					<a href="VisualizzaDettaglioAbitanteServlet?idAbitante=${abitante.id}" class="btn btn-info">Dettaglio</a>
					<a href="PrepareModificaAbitanteServlet?idAbitante=${abitante.id}" class="btn btn-info">Modifica</a>
					<a href="PrepareEliminaAbitanteServlet?idAbitante=${abitante.id}" class="btn btn-info">Elimina</a>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	<a href="PrepareInsertAbitanteServlet" class="btn btn-info">Inserisci Nuovo Abitante</a>

	</div>
</body>
</html>