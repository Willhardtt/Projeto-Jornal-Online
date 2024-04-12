<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	
<title>Tela Controle de Aluno</title>
</head>
<body>
	<div class="window" id="janela1" rel="modal">
		<h1 style="text-align: center;">Aluno</h1>
		<table>
			<caption
				style="font-size: 200%; padding-top: 10px; padding-bottom: 10px;">Menu Aluno</caption>
			<tr>
				<td class="op1" id="alterar" style="font-size: 150%;"><a
					href="AlunoAlterar.jsp" />Alterar</a></td>
			</tr>
			<tr>
				<td class="op1" id="excluir" style="font-size: 150%;"><a
					href="AlunoExcluir.jsp" />Cancelar Cadastro</a></td>
			</tr>
			<tr>
				<td class="op1" id="retornar" style="font-size: 150%;"><a
					href="index1.jsp" />HOME</a></td>
			</tr>
		</table>
		
	</div>
	<div id="mascara"></div>
</body>
</html>