<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="modelo.DepartamentoHibernate" %>
<%@ page import="dao.DaoDepartamentoHibernate" %>
<%@ page import="modelo.CargoHibernate" %>
<%@ page import="dao.DaoCargoHibernate" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Tela Cadastro</title>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="css/navbar.css">
    
    <link rel="stylesheet" type="text/css" href="css/menu1.css">
    <link rel="stylesheet" type="text/css" href="css/menu2.css">
    <link href="css/index/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<% 
	DaoDepartamentoHibernate daodepartamentohibernate = new DaoDepartamentoHibernate();
	ArrayList<DepartamentoHibernate> departamentos = (ArrayList) daodepartamentohibernate.listar();
	DaoCargoHibernate daocargohibernate = new DaoCargoHibernate();
	ArrayList<CargoHibernate> cargos = (ArrayList) daocargohibernate.listar();
%>
<% session = null; %>

 <!-- Menu do site -->
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
            <a class="nav-link" href="#">Edições Antigas</a>
          </li>
		  <li class="nav-item">
            <a class="nav-link" href="TelaLogin.jsp">Login</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
    
<form name="frmFuncionario" action="ControleFuncionarioServletAction" method="post">   
	<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-26">
						Bem-vindo, Administrador!
					</span>
					<span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>
					<div class="wrap-input100 validate-input" data-validate = "#">
						<input class="input100" type="text" name="txtIdAdm" id="txtIdAdm">
						<span class="focus-input100" data-placeholder="Id ADM"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "#">
						<input class="input100" type="text" name="txtNome" id="txtNome">
						<span class="focus-input100" data-placeholder="Nome"></span>
					</div>
					
					
					<div class="inputBox">
				  
                    <label for="cargo" class="labelInput">Cargo</label>
                    <select name="selCargo">
						<% for(CargoHibernate cargo : cargos){ %>
						<option value="<%= cargo.getCodCargo() %>"><%= cargo.getCargo() %></option>
						<% } // fim do for %> 
						<option value="" selected>Selecionar...</option>
						</select> <br>
                </div>

				 <br><br>
				 
				 <div class="inputBox">
				  
                    <label for="departamento" class="labelInput">Departamento</label>
                   <select name="selDepartamento">
					<% for(DepartamentoHibernate departamento : departamentos){ %>
					<option value="<%= departamento.getIdCodDepto() %>"><%= departamento.getDescricao() %></option>
					<% } // fim do for %>  	
					<option value="" selected>Selecionar...</option>
					</select> <br>
                </div>
			

					
					<div class="wrap-input100 validate-input" data-validate = "#">
						<input class="input100" type="text" name="txtSexo" id="txtSexo">
						<span class="focus-input100" data-placeholder="sexo"></span>
					</div>
					
				
					
					<div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
						<input class="input100" type="text" name="txtEmail" id="">
						<span class="focus-input100" data-placeholder="Email"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="txtSenha" id="txtSenha">
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					
					<div><input type="submit" name="btnOpcao" value="Cadastrar" id="submit"></div>

				</form>
			</div>
		</div>
</form>

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="js/main.js"></script>
    <script src="js/navbar.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>