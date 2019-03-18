<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dati municipio</title>
</head>
<body>
<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pagina dei Risultati</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>descrizione</th>
				<th>codice</th>
				<th>ubicazione</th>
				<th>Action</th>
			</tr>
		</thead>
		<% List<Municipio> listaMunicipi = (List<Municipio>)request.getAttribute("listaMunicipi.attribute.name"); 
			for(Municipio municipioItem:listaMunicipi){ %>
			<tr>
				<td><%=municipioItem.getDescrizione() %></td>
				<td><%=municipioItem.getCodice() %></td>
				<td><%=municipioItem.getUbicazione() %></td>
				<td>
					<a href="VisualizzaDettaglioMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PrepareUpdateServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PrepareDeleteMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	<a href="PrepareNewInsertServlet" class="btn btn-info">Inserisci Nuovo Elemento</a>

	</div>

</body>
</html>