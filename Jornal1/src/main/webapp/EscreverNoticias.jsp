<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/navbar.css">
	<link rel="stylesheet" type="text/css" href="css/textarea.css">

    
</head>
<body>

<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">ETER</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="index1.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="TelaSobre.jsp">Sobre</a>
          </li>
		  <li class="nav-item">
            <a class="nav-link" href="https://www.instagram.com/avoz_republica/">Edições Antigas</a>
          </li>
		  <li class="nav-item">
            <a class="nav-link" href="TelaLogin.jsp">Login</a>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>
</header>

<!-- Default unchecked -->
	<div class="custom-control custom-checkbox">
	    <input type="checkbox" class="custom-control-input" id="Informática">
	    <label class="custom-control-label" for="Informática">Informática</label>
	    <input type="checkbox" class="custom-control-input" id="Enfermagem">
	    <label class="custom-control-label" for="Enfermagem">Enfermagem</label>
	    <input type="checkbox" class="custom-control-input" id="Mecânica">
	    <label class="custom-control-label" for="Mecânica">Mecânica</label>
	    <input type="checkbox" class="custom-control-input" id="Telecomunicações">
	    <label class="custom-control-label" for="Telecomunicações">Telecomunicações</label>
	    <input type="checkbox" class="custom-control-input" id="Eletrônica">
	    <label class="custom-control-label" for="Eletrônica">Eletrônica</label>
	</div>
	


	<div class="form-group shadow-textarea">
	  	<label for="exampleFormControlTextarea6">Shadow and placeholder</label>
	  	<textarea class="form-control z-depth-1" id="exampleFormControlTextarea6" rows="3" placeholder="Escrever Notícia"></textarea>
	</div>
	



</body>
</html>