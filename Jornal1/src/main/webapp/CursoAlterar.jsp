<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.CursoHibernate" %>
<%@ page import="dao.DaoCursoHibernate" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/estilo.css" />
<script type="text/javascript" src="jquery/jquery-1.11.1.min.js"></script>
<script language="javascript">
$(document).ready(function(){
   //Quando o mouse entrar dentro do elemento de id="curso"
   $("#curso").mouseenter(function(evento) {
     //Faça o elemento de id="mensagem" ficar visivel
     $("#mensagem").css("display", "");
   });
   
   //Quando o mouse sair de dentro do elemento de id="curso"
   $("#curso").mouseleave(function(evento){
     //Faça o elemento de id="mensagem" ficar invisivel
     $("#mensagem").css("display", "none");
   });
   
   $("#funcionario").mouseenter(function(evento) {
     //Faça o elemento de id="mensagem" ficar visivel
     $("#mensagem2").css("display", "");
   });  
   $("#funcionario").mouseleave(function(evento){
     //Faça o elemento de id="mensagem" ficar invisivel
     $("#mensagem2").css("display", "none");
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
<title>Tela Curso</title>
</head>
<body>
<% DaoCursoHibernate daocursohibernate = new DaoCursoHibernate();
ArrayList<CursoHibernate> cursos = (ArrayList) daocursohibernate.listar();
%>
<div class="window" id="janela1" rel="modal">
<h1 style="text-align: center;">Curso</h1>
<table>
<form name="frmCurso" action="ControleCursoServletAction" method="post">
	<caption style="font-size:200%;padding-top:10px;padding-bottom:10px;">Consulta para Alteração</caption>
	<tr>
	<th class="op1" style="font-size:100%;">Curso</th>
	<td style='font-size:110%;font-weight:bold;color: darkblue;'>
	<select name="selCurso">	
	<% for(CursoHibernate curso : cursos){  %>
	   <option value="<%=curso.getIdCurso()%>"><%=curso.getNomeCurso()%></option>
	<% }  %>
	</select> <br><br></td>
	</tr>	
	<td><input type="hidden" name="txtIdCurso" maxlength="3" value=""></td>
	</tr>
	<tr>
	<td><input type="hidden" name="txtNomeCurso" maxlength="45" value=""></td>
	</tr>
	<tr>
	<td class="op1" style="font-size:100%;"><input type="submit" value="Alterar" name="btnOpcao"></td>
	<td class="op1" style="font-size:100%;"><input type="submit" value="Cancelar" name="btnOpcao"></td>
	</tr>
</form>
</table>
<h3>Retornar Tela Principal: <a href="TelaCurso.jsp" />Clicar</a></h3>
</div>
<div id="mascara"></div>
</body>
</html>