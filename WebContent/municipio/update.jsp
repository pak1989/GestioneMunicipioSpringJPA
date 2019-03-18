<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Municipio</title>
</head>
<body>
	<div class="container">

		<%@ include file="/../header.jsp"%>

		<div class="page-header">
			<h3>Modifica una municipio</h3>
		</div>
		<%
			Municipio municipioUp = (Municipio) request.getAttribute("municipioAttributeName");
		%>
		<form class="form-horizontal" action="ExecuteUpdateServlet" method="post">
			<div class="form-group">
			<label class="control-label col-sm-2" for="IdInputId"></label>
				<div class="col-sm-4">
					<input class="form-control" type="hidden" id="idInput"
						name="idInput" value="<%=municipioUp.getId()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId"
						name="descrizioneInput" value="<%=municipioUp.getDescrizione()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId"
						name="codiceInput" value="<%=municipioUp.getCodice()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="ubicazioneInputId">Ubicazione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="ubicazioneInputId"
						name="ubicazioneInput" value="<%=municipioUp.getUbicazione()%>">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Conferma
						modifica</button>
				</div>
			</div>
		</form>

	</div>

</body>
</html>