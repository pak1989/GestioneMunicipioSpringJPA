<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci un automobile</title>
</head>
<body>
 <div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Inserisci una persona</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteNewInsertServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">DESCRIZIONE:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">CODICE:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="ubicazioneInputId">UBICAZIONE:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="ubicazioneInputId" name="ubicazioneInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Conferma Inserimento</button>
		      </div>
		    </div>
		</form>

    </div>

</body>
</html>