<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
	<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
	  <%@page import="java.util.List"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Abitante</title>
</head>
<body>
	<div class="container">

		<%@ include file="/../header.jsp"%>

		<div class="page-header">
			<h3>Modifica una abitante</h3>
		</div>
		<%
			List<Municipio> municipi = (List<Municipio>) request.getAttribute("listaMunicipiAttributeName");
		%>
		<form class="form-horizontal" action="ExecuteUpdateAbitanteServlet" method="post">
			<div class="form-group">
			<label class="control-label col-sm-2" for="IdInputId"></label>
				<div class="col-sm-4">
					<input class="form-control" type="hidden" id="idInput"
						name="idInput" value="${abitanteAttributeName.id }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="${abitanteAttributeName.nome }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="${abitanteAttributeName.cognome }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenzaInput" value="${abitanteAttributeName.residenza }">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Età:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="etaInput" value="${abitanteAttributeName.eta }">
				</div>
			</div>
			<div class="form-group">
   		 	<label class="control-label col-sm-2" for="municipioIdInput">Seleziona Municipio:</label>
   		 	<div class="col-sm-4">
   		 	<select class="form-control" id="municipioIdInput" name="municipioIdInput" >
   		 		<option value="0"> -- Seleziona una voce -- </option>
   		 		<% for(Municipio municipioItem : municipi){ 
   		 			String selected = "";
   		 			if(((Abitante)request.getAttribute("abitanteAttributeName")).getMunicipio().getId()==municipioItem.getId()){
   		 				selected = "selected='selected'";
   		 			}
   		 		%>
   		 			
   		 			<option value="<%=municipioItem.getId()%>" <%=selected %>> <%=municipioItem.getDescrizione() %> </option>
   		 		<%}%>
   		 	</select>
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