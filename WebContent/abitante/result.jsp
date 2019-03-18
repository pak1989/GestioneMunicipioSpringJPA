<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dati Abitante</title>
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
				<th>nome</th>
				<th>cognome</th>
				<th>età</th>
				<th>residenza</th>
				<th>Action</th>
			</tr>
		</thead>
		<% List<Abitante> listaAbitanti = (List<Abitante>)request.getAttribute("listaMunicipi.attribute.name"); 
			for(Abitante abitanteItem:listaAbitanti){ %>
			<tr>
				<td><%=abitanteItem.getNome() %></td>
				<td><%=abitanteItem.getCognome() %></td>
				<td><%=abitanteItem.getEta() %></td>
				<td><%=abitanteItem.getResidenza() %></td>
				<td>
					<a href="VisualizzaDettaglioAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PrepareUpdateAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PrepareDeleteAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	<a href="PrepareNewInsertServlet" class="btn btn-info">Inserisci Nuovo Elemento</a>

	</div>

</body>
</html>