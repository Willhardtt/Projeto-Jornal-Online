<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="modelo.AlunoHibernate" %>
<%@ page import="dao.DaoAlunoHibernate" %>
<%@ page import="modelo.FuncionarioHibernate" %>
<%@ page import="dao.DaoFuncionarioHibernate" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/estilo.css" />


<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/JORNAL_LOGO  SEM_FD.png"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">

<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	

	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->

	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/menu2.css">
	<link rel="stylesheet" type="text/css" href="css/menu1.css">
<title>Login</title>
</head>
<body>




    <script>


        function logar(){

            var login = document.getElementById('login').value;
            var senha = document.getElementById('senha').value;

            if(login == "admin" && senha == "admin" ){
                alert('Sucesso');
                location.href = "TelaAdministrador.jsp";
            }else if( login == "a@b.c" && senha == "123"){
            	alert('Sucesso');
                location.href = "index1.jsp";
            }else{
                alert('Usuario ou senha incorretos');
            }

        }

    </script>
    
	

  
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-26">
						Bem-Vindo!
					</span>
					<span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

					<div class="wrap-input100 validate-input" data-validate = "#">
						 <input type="text" placeholder="Login" id="login">
						
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input type="password" placeholder="Senha" id="senha">
						
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button type="submit" class="login100-form-btn" onclick="logar(); return false">
								Login
							</button>
						</div>
					</div>

					<div class="text-center p-t-115">
						<span class="txt1">
							Não tem uma conta? Registre-se como aluno ou administrador.
						</span>

						<a class="txt2" href="TelaCadastroAluno.jsp">
							Sou aluno <br>
						</a>
						<a class="txt2" href="TelaCadastroAdm.jsp">
							Sou administrador
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
  
  

</body>
</html>