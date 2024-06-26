<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="modelo.FuncionarioHibernate" %>
<%@ page import="dao.DaoFuncionarioHibernate" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/estilo.css" />
<script type="text/javascript" src="jquery/jquery-1.11.1.min.js"></script>
<script language="javascript">
$(document).ready(function(){
   //Quando o mouse entrar dentro do elemento de id="departamento"
   $("#departamento").mouseenter(function(evento) {
     //Fa�a o elemento de id="mensagem" ficar visivel
     $("#mensagem").css("display", "");
   });
   
   //Quando o mouse sair de dentro do elemento de id="departamento"
   $("#departamento").mouseleave(function(evento){
     //Fa�a o elemento de id="mensagem" ficar invisivel
     $("#mensagem").css("display", "none");
   });
   
   $("#administrador").mouseenter(function(evento) {
     //Fa�a o elemento de id="mensagem" ficar visivel
     $("#mensagem2").css("display", "");
   });  
   $("#administrador").mouseleave(function(evento){
     //Fa�a o elemento de id="mensagem" ficar invisivel
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
<title>Tela Funcion�rio - Excluir</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	DaoFuncionarioHibernate daoadministradorhibernate = new DaoFuncionarioHibernate();	
	ArrayList<FuncionarioHibernate> administradors = (ArrayList) daoadministradorhibernate.listar();
%>
<div class="window2" id="janela1" rel="modal">
<h1 style="text-align: center;">Funcion�rio - Excluir</h1>
<table>
<form name="frmAdministrador" action="ControleAdministradorServletAction" method="post">
	<caption style="font-size:200%;padding-top:10px;padding-bottom:10px;">Consultar</caption>
	<tr>
	<th class="op2" style="font-size:100%;">Funcion�rio(a): </th>	
	<td style='font-size:110%;font-weight:bold;color: darkblue;'>
	<select class="op2" name="selAdministrador">	
	<%
			for(FuncionarioHibernate administrador : administradors){
		%>
	   <option value="<%=administrador.getIdAdm()%>"><%=administrador.getCargo()%></option>
	<% }  %>
	</select> <br><br></td>
	</tr>	
	<input type="hidden" name="txtNascimento" size="10" maxlength="10" value=""></td>
	<input type="hidden" name="txtSalario" size="10" maxlength="10" value=""></td>
	<input type="hidden" name="txtCargo" size="30" maxlength="30" value=""></td>
	<tr>		
	<input type="hidden" name="txtMatricula" maxlength="15" value="0">
	<td class="op1"><input type="submit" value="Excluir" name="btnOpcao"></td>
	<td class="op1"><input type="submit" value="Cancelar" name="btnOpcao"></td>
	</tr>
</form>
</table>
<h3>Retornar Tela Principal: <a href="TelaAdministrador.jsp" />Clicar</a></h3>
</div>
<div id="mascara"></div>
</body>
</html>