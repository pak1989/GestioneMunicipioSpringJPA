<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Abitante</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Ricerca Abitante</h3>
		</div>


		<form class="form-horizontal" action="ExecuteSearchAbitanteServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="municipioInputId">Seleziona Municipio:</label>
				<div class="col-sm-4">
					<select class="form-control" id="municipioInputId"
						name="municipioInput">
						<option value="0">Municipi</option>
						<c:forEach items="${listaMunicipiAttributeName}" var="municipio">
							<c:if test="${abitanteAttributeName.municipio.id != municipio.id}">
								<option value="<c:out value = "${municipio.id}"/>"><c:out value = "${municipio.descrizione}"/></option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta':</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="etaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenzaInput">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Effetua
						Ricerca</button>
					<a href="PrepareInsertMunicipioServlet"
						class="btn btn-primary btn-md">Inserisci Nuovo Abitante</a>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->



</body>
</html>