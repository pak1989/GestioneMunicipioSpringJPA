<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio</title>
</head>
<body>
<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${abitanteSingolaAttributeName.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${abitanteSingolaAttributeName.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${abitanteSingolaAttributeName.cognome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">età</dt>
				<dd class="col-sm-9">${abitanteSingolaAttributeName.eta}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">residenza</dt>
				<dd class="col-sm-9">${abitanteSingolaAttributeName.residenza}</dd>
			</dl>
	 		<dl class="row">
				<dt class="col-sm-3 text-right">id Municipio</dt>
				<dd class="col-sm-9">${abitanteSingolaAttributeName.municipio.id}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice Municipio</dt>
				<dd class="col-sm-9">${abitanteSingolaAttributeName.municipio.codice}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione Municipio</dt>
				<dd class="col-sm-9">${abitanteSingolaAttributeName.municipio.descrizione}</dd>
			</dl>
			
		</div>

	</div>
</body>
</html>