<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/estilo.css" />
<script type="text/javascript" src="jquery/jquery-1.11.1.min.js"></script>
<script language="javascript">
$(document).ready(function(){
   $("#cadastrar").mouseenter(function(evento) {
     $("#mensagem").css("display", "");
   });
   $("#cadastrar").mouseleave(function(evento){
     $("#mensagem").css("display", "none");
   });
   
   $("#alterar").mouseenter(function(evento) {
     $("#mensagem2").css("display", "");
   });  
   $("#alterar").mouseleave(function(evento){
     $("#mensagem2").css("display", "none");
   });

   $("#excluir").mouseenter(function(evento) {
	 $("#mensagem3").css("display", "");
	});  
	$("#excluir").mouseleave(function(evento){
	 $("#mensagem3").css("display", "none");
	});
	
	$("#consultar").mouseenter(function(evento) {
	 $("#mensagem4").css("display", "");
	});  
	$("#consultar").mouseleave(function(evento){
	 $("#mensagem4").css("display", "none");
	});
	
	$("#relatorio").mouseenter(function(evento) {
	 $("#mensagem5").css("display", "");
	});  
	$("#relatorio").mouseleave(function(evento){
	 $("#mensagem5").css("display", "none");
	});
	
	$("#retornar").mouseenter(function(evento) {
	 $("#mensagem6").css("display", "");
	 });  
	 $("#retornar").mouseleave(function(evento){
	  $("#mensagem6").css("display", "none");
	 });
		var alturaTela = $(document).height();
		var larguraTela = $(window).width();
	
		//colocando o fundo preto
		$('#mascara').css({'width':larguraTela,'height':alturaTela});
		$('#mascara').fadeIn(1000);	
		$('#mascara').fadeTo("slow",0.8);

		var left = ($(window).width() /2) - ( $("#janela1").width() / 2 );
		var top = ($(window).height() / 2) - ( $("#janela1").height() / 2 );
	
		$("#janela1").css({'top':top,'left':left});
		$("#janela1").show();	
		$("img").css("Heigth","100");
});
</script>

<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/navbar.css">
	<link rel="stylesheet" type="text/css" href="css/menu1.css">
	<link rel="stylesheet" type="text/css" href="css/menu2.css">

<title>Tela Controle de Administrador</title>
</head>
<body>

	<div class="window" id="janela1" rel="modal" >
		<h1 style="text-align: center;">Administrador</h1>
		<table>
			<caption
				style="font-size: 200%; padding-top: 10px; padding-bottom: 10px;">Menu Administrador</caption>
			<tr>
				<td class="op1" id="cadastrar" style="font-size: 100%;">
				<a href="TelaCadastroAdm.jsp" />Cadastrar</a></td>
			</tr>
			<tr>
			<td class="op1" id="cadastrar" style="font-size: 100%;">
				<a href="CursoCadastrar.jsp" />Cadastrar Cursos</a>
			</td>
			</tr>
			<tr>
			<td class="op1" id="consultar" style="font-size: 100%;">
				<a href="CursoConsultar.jsp" />Consultar Cursos</a>
			</td>
			</tr>
			<tr>
			<td class="op1" id="excluir" style="font-size: 100%;">
				<a href="CursoExcluir.jsp" />Excluir Cursos</a>
			</td>
			</tr>
			<tr>
				<td class="op1" id="alterar" style="font-size: 100%;">
				<a href="AdministradorAlterar.jsp" />Alterar</a></td>
			</tr>
			<tr>
				<td class="op1" id="excluir" style="font-size: 100%;">
				<a href="AdministradorExcluir.jsp" />Excluir</a></td>
			</tr>
			<tr>
				<td class="op1" id="consultar" style="font-size: 100%;">
				<a href="AdministradorConsultar.jsp" />Consultar</a></td>
			</tr>
			<tr>
				<td class="op1" id="consultar" style="font-size: 100%;">
				<a href="AlunoConsultar.jsp" />Consultar Alunos</a></td>
			</tr>
			<tr>
				<td class="op1" id="excluir" style="font-size: 100%;">
				<a href="AlunoExcluir.jsp" />Excluir Alunos</a></td>
			</tr>
			<tr>
				<td class="op1" id="excluir" style="font-size: 100%;">
				<a href="EscreverNoticias.jsp" />Escrever Notícias</a></td>
			</tr>
			<tr>
				<td class="op1" id="retornar" style="font-size: 100%;"><a
					href="index1.jsp" />HOME</a></td>
			</tr>
		</table>
		<div style="padding: 15px;">
			<span id="mensagem"
				style="display: none; width: 550px; font-weight: bold; margin: auto;">
				Cadastrar Administrador</span> <span id="mensagem2"
				style="display: none; width: 550px; font-weight: bold; margin: auto;">
				Alterar Administrador</span> <span id="mensagem3"
				style="display: none; width: 550px; font-weight: bold; margin: auto;">
				Excluir Administrador</span> <span id="mensagem4"
				style="display: none; width: 550px; font-weight: bold; margin: auto;">
				Consultar Administrador</span> <span id="mensagem5"
				style="display: none; width: 550px; font-weight: bold; margin: auto;">
				Relatório dos Administradores</span> <span id="mensagem6"
				style="display: none; width: 550px; font-weight: bold; margin: auto;">
				Retornar a Tela de Controle</span>
		</div>
	</div>
	<div id="mascara"></div>
	
	<script src="js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>