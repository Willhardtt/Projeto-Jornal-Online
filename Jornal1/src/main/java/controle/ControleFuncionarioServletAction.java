package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.CargoHibernate;
import modelo.DepartamentoHibernate;
import dao.DaoCargoHibernate;
import dao.DaoDepartamentoHibernate;
import modelo.FuncionarioHibernate;
import dao.DaoFuncionarioHibernate;



/**
 * Servlet implementation class ControleAdministradorServletAction
 */
public class ControleFuncionarioServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ControleFuncionarioServletAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String nome = request.getParameter("txtNome");
 
		String Sexo = request.getParameter("txtSexo");
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		String botao = request.getParameter("btnOpcao");
		
		String idcargo = request.getParameter("selCargo");
		String iddepartamento = request.getParameter("selDepartamento");
		String selfuncionario = request.getParameter("selfuncionario");
		

		String verificarCodigo = request.getParameter("txtIdAdm");

		
		
		int idAdm;
		int codcargo;
		int coddepartamento;
		
		
		
		
		
		
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String resultado;
		String nomeretorno = "", retorno = "";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("0.00");		
		
		try {
			DaoDepartamentoHibernate daodepartamentohibernate = new DaoDepartamentoHibernate();
			ArrayList<DepartamentoHibernate> departamentos = (ArrayList) daodepartamentohibernate.listar();
			
			
			DaoCargoHibernate daocargohibernate = new DaoCargoHibernate();
			ArrayList<CargoHibernate> cargos = (ArrayList) daocargohibernate.listar();
			
			
			DaoFuncionarioHibernate daofuncionario = new DaoFuncionarioHibernate();
			
			if (botao.equals("Cadastrar")) {
				retorno = "TelaCadastroAdm.jsp";
				nomeretorno = "Administrador Cadastrar";
				if (nome.equals("") || idcargo.equals("") ||iddepartamento.equals("") ||
						 Sexo.equals("")|| email.equals("")) {
					throw new Exception("Favor preencher todas as caixas.");
				}
				DepartamentoHibernate departamentohibernate = new DepartamentoHibernate();
				departamentohibernate.setCodDepto(Integer.parseInt(iddepartamento));
				
				CargoHibernate cargohibernate = new CargoHibernate();
				cargohibernate.setCodCargo(Integer.parseInt(idcargo));
				
				FuncionarioHibernate adm = new FuncionarioHibernate();
				
				adm.setNome(nome);
				adm.setSexo(Sexo);
				adm.setEmail(email);
				adm.setSenha(senha);
				
				adm.setDepartamento(departamentohibernate);
				adm.setCargo(cargohibernate);
				
				
				
				daofuncionario.incluir(adm);
				departamentohibernate=daodepartamentohibernate.consultar(adm.getDepartamento().getIdCodDepto());
				String descricao= departamentohibernate.getDescricao();
				
				cargohibernate=daocargohibernate.consultar(adm.getCargo().getCodCargo());
				String cargo= cargohibernate.getCargo();
				
				
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Cadastro realizado com sucesso</h1>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Funcionário(a): </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>" + adm.getNome()
						+ "</label><br><br>");
			
						out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");
						out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
								+ adm.getSexo() + "</label><br><br>");
						out.println("<label style='font-size:110%;font-weight:bold;'>Email: </label>");
						out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
								+ adm.getEmail() + "</label><br><br>");
					
						
						out.println("<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Cadastro realizado com sucesso</h1>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Administrador: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ adm.getIdAdm() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Administrador: </label>");
				out.println(
						"<input style='font-size:110%;font-weight:bold;color: darkblue;' type='text' name='txtAdministrador'"
								+ " maxlength='45' size='60' value='" + idcargo + "'><br><br>");
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Departamento: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getDepartamento().getIdCodDepto()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Departamento: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selDepartamento'>");		
				for(DepartamentoHibernate departamento : departamentos){
					if (departamento.getIdCodDepto()==adm.getDepartamento().getIdCodDepto())
					{
						out.println("<option value="+departamento.getIdCodDepto()+">"+departamento.getDescricao()+"</option>");
					}
				}
				out.println("</select> <br><br>");
				
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'>"+adm.getCargo().getCodCargo()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'><select name='selCargo'>");
				for(CargoHibernate cargoo : cargos){
					if (cargoo.getCodCargo()==adm.getCargo().getCodCargo())
					{
						out.println("<option value="+cargoo.getCodCargo()+">"+cargoo.getCargo()+"</option>");
					}
				}
				
				
				out.println("<a href='" + retorno + "'" + "/>" + nomeretorno + "</a>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
			
			
			
			
			
			
			if (botao.equals("Consultar")) {
				retorno = "AdministradorConsultar.jsp";
				nomeretorno = "Administrador Consultar";
				if (selfuncionario == null || selfuncionario == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idAdm = Integer.parseInt(selfuncionario);
				FuncionarioHibernate funcionario = new FuncionarioHibernate();
				DepartamentoHibernate departamentohibernate = new DepartamentoHibernate();
				CargoHibernate cargohibernate = new CargoHibernate();	
				
				funcionario=daofuncionario.consultar(idAdm);
				
				departamentohibernate=daodepartamentohibernate.consultar(funcionario.getDepartamento().getIdCodDepto());
				cargohibernate=daocargohibernate.consultar(funcionario.getCargo().getCodCargo());
				
				String cargo = cargohibernate.getCargo();
				String descricao= departamentohibernate.getDescricao();
				// consultar pelo id do Administrador
				FuncionarioHibernate adm = daofuncionario.consultarPorAdministrador(String.valueOf(idAdm));

				if (adm == null) {
					throw new Exception("Administrador não está Cadastrado.");
				}
				daofuncionario.consultarPorAdministrador(String.valueOf(idAdm));
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='text-align: center;'>Sistema de Banco de dados</h1>");
				out.println("<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Consulta realizada com sucesso</h1>");		
				out.println("<label style='font-size:110%;font-weight:bold;'>Funcionário(a): </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getNome()+"</label><br><br>");		
	
				out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getSexo()+"</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Bairro: </label>");				
				out.println	("<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Consulta realizada com sucesso</h2>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Administrador: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ adm.getIdAdm() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Administrador: </label>");
				out.println("<a href='AdministradorConsultar.jsp'/>Retornar para Administrador Consultar</a>");
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Departamento: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getDepartamento().getIdCodDepto()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Departamento: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selDepartamento'>");		
				for(DepartamentoHibernate departamento : departamentos){
					if (departamento.getIdCodDepto()==adm.getDepartamento().getIdCodDepto())
					{
						out.println("<option value="+departamento.getIdCodDepto()+">"+departamento.getDescricao()+"</option>");
					}
				} 
				out.println("</select> <br><br>");
				
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getCargo().getCodCargo()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'><select name='selCargo'>");
				for(CargoHibernate cargoo : cargos){
					if (cargoo.getCodCargo()==adm.getCargo().getCodCargo())
					{
						out.println("<option value="+cargoo.getCodCargo()+">"+cargoo.getCargo()+"</option>");
					}
				}
				
				out.println("<a href='" + retorno + "'" + "/>" + nomeretorno + "</a>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (botao.equals("Excluir")) {
				retorno = "AdministradorExcluir.jsp";
				nomeretorno = "Administrador Excluir";
				if (selfuncionario == null || selfuncionario == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idAdm = Integer.parseInt(selfuncionario);
				// consultar pelo id do Administrador
				FuncionarioHibernate adm = daofuncionario.consultarPorAdministrador(String.valueOf(idAdm));

				if (adm == null) {
					throw new Exception("Administrador não está Cadastrado.");
				}
				daofuncionario.excluir(adm);
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='text-align: center;'>Sistema de Banco de dados</h1>");
				out.println("<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Consulta realizada com sucesso</h1>");		
				out.println("<label style='font-size:110%;font-weight:bold;'>Funcionário(a): </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getNome()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Email: </label>");	
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getEmail()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getSexo()+"</label><br><br>");
				
				out.println("<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Exclusão realizada com sucesso</h2>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Administrador: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ adm.getIdAdm() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Administrador: </label>");
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Departamento: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getDepartamento().getIdCodDepto()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Departamento: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selDepartamento'>");		
				for(DepartamentoHibernate departamento : departamentos){
					if (departamento.getIdCodDepto()==adm.getDepartamento().getIdCodDepto())
					{
						out.println("<option value="+departamento.getIdCodDepto()+">"+departamento.getDescricao()+"</option>");
					}
				} 
				out.println("</select> <br><br>");
				
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'>"+adm.getCargo().getCodCargo()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'><select name='selCargo'>");
				for(CargoHibernate cargoo : cargos){
					if (cargoo.getCodCargo()==adm.getCargo().getCodCargo())
					{
						out.println("<option value="+cargoo.getCodCargo()+">"+cargoo.getCargo()+"</option>");
					}
				}
				
				
				out.println("<a href='AdministradorExcluir.jsp'/>Retornar para Administrador Excluir</a>");
				out.println("<form name='frmAdm' action='ControleAdministradorServletAction' method='post'>");
				out.println("<input type='submit' name='btnOpcao' value='Confirmar Exclusão'>");
				out.println("<input type='submit' name='btnOpcao' value='Cancelar Exclusão'>");
				out.println("</form>");
				out.println("<a href='" + retorno + "'" + "/>" + nomeretorno + "</a>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
			
			
			
			
			
			if (botao.equals("Confirmar Exclusão")) {
				retorno = "FuncionarioExcluir.jsp";
				nomeretorno = "Funcionario Excluir";
				if (selfuncionario == null || selfuncionario == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idAdm = Integer.parseInt(verificarCodigo);
				// consultar pelo id do Funcionário
				FuncionarioHibernate adm = daofuncionario.consultarPorAdministrador(String.valueOf(idAdm));

				if (adm == null) {
					throw new Exception("Administrador não está cadastrado.");
				}
				DepartamentoHibernate departamentohibernate = new DepartamentoHibernate();
				daofuncionario.excluir(adm);
				
				String descricao= departamentohibernate.getDescricao();
				
				CargoHibernate cargohibernate = new CargoHibernate();
					
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='text-align: center;'>Sistema de Banco de dados</h1>");
				out.println("<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Consulta realizada com sucesso</h1>");		
				out.println("<label style='font-size:110%;font-weight:bold;'>Funcionário(a): </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getNome()+"</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Email: </label>");	
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getEmail()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getSexo()+"</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Bairro: </label>");				
				out.println("<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Exclusão realizada com sucesso</h2>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Administrador: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ adm.getIdAdm() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Administrador: </label>");
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Departamento: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getDepartamento().getIdCodDepto()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Departamento: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selDepartamento'>");		
				for(DepartamentoHibernate departamento : departamentos){
					if (departamento.getIdCodDepto()==adm.getDepartamento().getIdCodDepto())
					{
						out.println("<option value="+departamento.getIdCodDepto()+">"+departamento.getDescricao()+"</option>");
					}
				} 
				out.println("</select> <br><br>");
				
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'>"+adm.getCargo().getCodCargo()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'><select name='selCargo'>");
				for(CargoHibernate cargoo : cargos){
					if (cargoo.getCodCargo()==adm.getCargo().getCodCargo())
					{
						out.println("<option value="+cargoo.getCodCargo()+">"+cargoo.getCargo()+"</option>");
					}
				}
				
		
				out.println("<br><br>");
				out.println("<a href='" + retorno + "'" + "/>" + nomeretorno + "</a>");
				out.println("</body>");
				out.println("</html>");
			
			
			}
			if (botao.equals("Cancelar Exclusão")) {
				String redirectURL = "FuncionarioExcluir.jsp";
				response.sendRedirect(redirectURL);
			}
			
			
			
			
			
			
			if (botao.equals("Alterar")) {
				retorno = "AdministradorAlterar.jsp";
				nomeretorno = "Administrador Alterar";
				if (selfuncionario== null || selfuncionario == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idAdm = Integer.parseInt(selfuncionario);
				FuncionarioHibernate funcionario = new FuncionarioHibernate();
				CargoHibernate cargohibernate = new CargoHibernate();
				DepartamentoHibernate departamentohibernate = new DepartamentoHibernate();	
				
				funcionario=daofuncionario.consultar(idAdm);	
				
				departamentohibernate=daodepartamentohibernate.consultar(funcionario.getDepartamento().getIdCodDepto());
				String descricao= departamentohibernate.getDescricao();	
				
				cargohibernate=daocargohibernate.consultar(funcionario.getCargo().getCodCargo());
				String cargo= cargohibernate.getCargo();	
				// consultar pelo id do Administrador
				FuncionarioHibernate adm = daofuncionario.consultarPorAdministrador(String.valueOf(idAdm));
				if (adm == null) {
					throw new Exception("Administrador não está Cadastrado.");
				}
				idAdm = adm.getIdAdm();
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='text-align: center;'>Funcionário</h1>");
				out.println("<table>");
				out.println("<form name='frmFuncionario' action='ControleFuncionarioServletAction' method='post'>");
				out.println("<caption style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Dados do Funcionário - Alterar </caption>");
				
				out.println("<tr>");
				out.println("<th class='op2'>Cód. Funcionário: </th>");
				out.println("<td class='op2'><input type='text' readonly name='txtIdAdm' size='10' maxlength='10' value='"+adm.getIdAdm()+"'></td>");
				out.println("</tr>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Funcionário(a): </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getNome()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Email: </label>");	
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getEmail()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getSexo()+"</label><br><br>");
								out.println("<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Exclusão realizada com sucesso</h2>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Administrador: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ adm.getIdAdm() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Administrador: </label>");
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Departamento: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getDepartamento().getIdCodDepto()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Departamento: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selDepartamento'>");		
				for(DepartamentoHibernate departamento : departamentos){
					if (departamento.getIdCodDepto()==adm.getDepartamento().getIdCodDepto())
					{
						out.println("<option value="+departamento.getIdCodDepto()+">"+departamento.getDescricao()+"</option>");
					}
				} 
				out.println("</select> <br><br>");
				
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'>"+adm.getCargo().getCodCargo()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'><select name='selCargo'>");
				for(CargoHibernate cargoo : cargos){
					if (cargoo.getCodCargo()==adm.getCargo().getCodCargo())
					{
						out.println("<option value="+cargoo.getCodCargo()+">"+cargoo.getCargo()+"</option>");
					}
				}
				
				out.println("<p><a href='TelaAdministrador.jsp'/>Retornar a tela Administrador</a></p>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
			
			
			
			
			
			if (botao.equals("Confirmar Alteração")) {
				retorno = "AdministradorAlterar.jsp";
				nomeretorno = "Administrador Alterar";
				if (nome.equals("") || idcargo.equals("") ||iddepartamento.equals("") 
						||  Sexo.equals("")|| email.equals("")) {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idAdm=Integer.parseInt(verificarCodigo);
				FuncionarioHibernate adm = new FuncionarioHibernate();
				DepartamentoHibernate departamentohibernate = new DepartamentoHibernate();
				CargoHibernate cargohibernate = new CargoHibernate();
				
				departamentohibernate.setCodDepto(Integer.parseInt(iddepartamento));
				
				cargohibernate.setCodCargo(Integer.parseInt(idcargo));
				
			
				adm.setNome(nome);
		
				adm.setSexo(Sexo);
				
				adm.setEmail(email);
				adm.setSenha(senha);
				
				
				
				daofuncionario.alterar(adm);
				departamentohibernate=daodepartamentohibernate.consultar(adm.getDepartamento().getIdCodDepto());
				String descricao= departamentohibernate.getDescricao();
				
				cargohibernate=daocargohibernate.consultar(adm.getCargo().getCodCargo());
				String cargo= cargohibernate.getCargo();
				
				
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Cadastro realizado com sucesso</h1>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Funcionário(a): </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>" + adm.getNome()
						+ "</label><br><br>");
			

						out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");
						out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
								+ adm.getSexo() + "</label><br><br>");
						
						out.println("<label style='font-size:110%;font-weight:bold;'>Email: </label>");
						out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
								+ adm.getEmail() + "</label><br><br>");
					
						
						out.println("<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Cadastro realizado com sucesso</h1>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Administrador: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ adm.getIdAdm() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Administrador: </label>");
				out.println(
						"<input style='font-size:110%;font-weight:bold;color: darkblue;' type='text' name='txtAdministrador'"
								+ " maxlength='45' size='60' value='" + idcargo + "'><br><br>");
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Departamento: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+adm.getDepartamento().getIdCodDepto()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Departamento: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selDepartamento'>");		
				for(DepartamentoHibernate departamento : departamentos){
					if (departamento.getIdCodDepto()==adm.getDepartamento().getIdCodDepto())
					{
						out.println("<option value="+departamento.getIdCodDepto()+">"+departamento.getDescricao()+"</option>");
					}
				}
				out.println("</select> <br><br>");
				
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'>"+adm.getCargo().getCodCargo()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'><select name='selCargo'>");
				for(CargoHibernate cargoo : cargos){
					if (cargoo.getCodCargo()==adm.getCargo().getCodCargo())
					{
						out.println("<option value="+cargoo.getCodCargo()+">"+cargoo.getCargo()+"</option>");
					}
				}
				
				
				out.println("<a href='" + retorno + "'" + "/>" + nomeretorno + "</a>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
			
		} catch (Exception ex) {
			out.println("<!doctype html>");
			out.println("<html lang='pt-br'>");
			out.println("<head>");
			out.println("<meta charset='ISO-8859-1'>");
			out.println("<link rel='stylesheet' href='css/estilo.css' />");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1 style='text-align: center;'>Sistema de Banco de dados</h1>");
			out.println("<h2>Erro: " + ex.getMessage() + "</h2><br><br>");
			out.println("<a href='" + retorno + "'/>Retornar para o " + nomeretorno + "</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
