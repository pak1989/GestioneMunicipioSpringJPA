<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Municipio</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca Municipio</h3>
	  	  <%if(request.getAttribute("messaggioDiErrore") != null){ %>
		<h4 style="color:red;"> <%=  request.getAttribute("messaggioDiErrore") %> </h4>
	<% } %>
	</div>
	
	
		<%Municipio municipioInPagina = (Municipio) request.getAttribute("municipioAttributeName");%>

      	<form class="form-horizontal" action="ExecuteEliminaMunicipioServlet" method="post">
      	<button class="btn btn-danger btn-md">Sicuro di voler eliminare? Scrivi il suo codice per conferma</button>
      		
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="idInputId"></label>
	    		<div class="col-sm-4">
					<input class="form-control"  type="hidden" id="nomeInputId" name="idInput" value="<%=municipioInPagina.getId()%>">
			 	</div>
  			</div>
  			
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Conferma</button>
		      </div>
		    </div>
		</form>
		
    </div><!-- /.container -->



</body>
</html>