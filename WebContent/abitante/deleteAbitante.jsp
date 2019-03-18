<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confermi Eliminazione Abitante</title>
</head>
<body>

	<%
		Abitante abitanteInPagina = (Abitante) request.getAttribute("abitanteAttributeName");
	%>

	<div class="container">

		<%@ include file="/../header.jsp"%>

		<div class="page-header">
			<h3>Elimina Abitante</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getCognome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Eta</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getEta()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getResidenza()%></dd>
			</dl>
			<dl class="row">
			<dt class="col-sm-3 text-right">
				<form name="elimina" action="ExecuteDeleteAbitanteServlet"
					method="POST">
					<input type="submit" class="btn btn-primary btn-md" value="Elimina">
					<input type="hidden" name="idAbitante"
						value="<%=abitanteInPagina.getId()%>">
						
				</form>
				</dt><dd class="col-sm-9"></dd>
			</dl>

		</div>

	</div>

</body>
</html>