package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoCargoHibernate;
import modelo.CargoHibernate;

/**
 * Servlet implementation class ControleCargoServletAction
 */
public class ControleCargoServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ControleCargoServletAction() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String nomecargo = request.getParameter("txtCargo");
		int codigo;	
		String verificarCodigo=request.getParameter("txtCodCargo");
		String verificarCodigoConsulta=request.getParameter("selCargo");
		String botao = request.getParameter("btnOpcao");
		PrintWriter out = response.getWriter();
		HttpSession session =  request.getSession();
		String resultado;
		String nomeretorno="",retorno="";		
		DecimalFormat df = new DecimalFormat("#0.0");
		try {
			DaoCargoHibernate daocargo = new DaoCargoHibernate();	
		
			if (botao.equals("Cadastrar")) {
				retorno="CargoCadastrar.jsp";
				nomeretorno="Cargo Cadastrar";
				if (nomecargo.equals("")) {
					throw new Exception("Favor preencher todas as caixas.");
				}
				
				
				
				CargoHibernate cargo = new CargoHibernate();
				
				cargo.setCargo(nomecargo);
				
				daocargo.incluir(cargo);
				
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Cadastro realizado com sucesso</h1>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+cargo.getCodCargo()+"</label><br><br>");				
				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+cargo.getCargo()+"</label><br><br>");		
				out.println("<a href='CargoCadastrar.jsp'/>Cargo Cadastrar</a>");
				out.println("</body>");
				out.println("</html>");
			}
			if (botao.equals("Cancelar")) {
				String redirectURL = "TelaCargo.jsp";
				response.sendRedirect(redirectURL);
			}
			if (botao.equals("Consultar")) {
				retorno="ClienteConsultar.jsp";
				nomeretorno="Cliente Consultar";
				if (verificarCodigoConsulta==null || verificarCodigoConsulta=="") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				codigo=Integer.parseInt(verificarCodigoConsulta);
				// consultar pelo id do Cargo
				CargoHibernate cargo = daocargo.consultar(codigo);
				
				if (cargo == null){
					throw new Exception ("Cargo não está Cadastrado.");
				}
				daocargo.consultar(codigo);
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");				
				out.println("<h1 style='text-align: center;'>Sistema de Banco de dados</h1>");				
				out.println("<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Consulta realizada com sucesso</h2>");		
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+cargo.getCodCargo()+"</label><br><br>");				
				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+cargo.getCargo()+"</label><br><br>");
				
				out.println("<a href='CargoConsultar.jsp'/>Retornar para Cliente Consultar</a>");
				out.println("</body>");
				out.println("</html>");
			}
			if (botao.equals("Excluir")) {
				retorno="CargoExcluir.jsp";
				nomeretorno="Cargo Excluir";
				if (verificarCodigoConsulta==null || verificarCodigoConsulta=="") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				codigo=Integer.parseInt(verificarCodigoConsulta);
				// consultar pelo id do Cargo
				CargoHibernate cargo = daocargo.consultar(codigo);
				
				if (cargo == null){
					throw new Exception ("Cargo não está Cadastrado.");
				}				
				daocargo.excluir(cargo);
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");					
				out.println("<h1 style='text-align: center;'>Sistema de Banco de dados</h1>");				
				out.println("<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Exclusão realizada com sucesso</h2>");		
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+cargo.getCodCargo()+"</label><br><br>");				
				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+cargo.getCargo()+"</label><br><br>");
				
				out.println("<a href='CargoExcluir.jsp'/>Retornar para Cargo Excluir</a>");
				out.println("</body>");
				out.println("</html>");
			}						
			if (botao.equals("Alterar")) {
				retorno = "CargoAlterar.jsp";
				nomeretorno = "Cargo Alterar";
				if (verificarCodigoConsulta == null || verificarCodigoConsulta == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				codigo = Integer.parseInt(verificarCodigoConsulta);
				// consultar pelo id do Cargo
				CargoHibernate cargo = daocargo.consultar(codigo);
				if (cargo == null) {
					throw new Exception("Cargo não está Cadastrado.");
				}
				codigo = cargo.getCodCargo();
				nomecargo = cargo.getCargo();
				
				
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='text-align: center;'>Sistema de Banco de dados</h1>");
				out.println(
						"<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Consulta realizada com sucesso</h2>");
				out.println("<form name='frmCargo2' action='ControleCargoServletAction' method='post'>");
				out.println(
						"<label style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Altere os dados</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Cargo: </label>");
				out.println(
						"<input style='font-weight:bold;color: darkblue;' type='text' name='txtCodCargo' maxlength='10'+"
								+ " readonly size='10' value='" + codigo + "'><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");
				out.println(
						"<input style='font-size:110%;font-weight:bold;color: darkblue;' type='text' name='txtCargo'"
								+ " maxlength='45' size='60' value='" + nomecargo + "'><br><br>");
				out.println("<input type='submit' name='btnOpcao' value='Confirmar Alteração'>");
				out.println("<input type='submit' name='btnOpcao' value='Cancelar'>");
				out.println("</form>");
				out.println("<p><a href='CargoAlterar.jsp'/>Retornar para Cargo Alterar</a></p>");
				out.println("</body>");
				out.println("</html>");
			}
			if (botao.equals("Confirmar Alteração")) {
				retorno = "CargoAlterar.jsp";
				nomeretorno = "Cargo Alterar";
				if (verificarCodigo == null || verificarCodigo == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				codigo = Integer.parseInt(verificarCodigo);
				CargoHibernate cargo = new CargoHibernate();
				
				cargo.setCodCargo(codigo);
				cargo.setCargo(nomecargo);
				daocargo.alterar(cargo);
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='text-align: center;'>Sistema de Banco de dados</h1>");
				out.println(
						"<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Dados alterados com sucesso</h2>");
				out.println("<form name='frmCargo2' action='CargoAlterar.jsp' method='post'>");
				
				out.println("<label style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Cargo</label><br><br>");

				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Cargo: </label>");
				out.println("<input style='font-weight:bold;color: darkblue;' type='text' name='txtCodCargo' maxlength='10'+"+ " readonly size='10' value='" + codigo + "'><br><br>");

				out.println("<label style='font-size:110%;font-weight:bold;'>Cargo: </label>");
				out.println("<input style='font-size:110%;font-weight:bold;color: darkblue;' type='text' name='txtCargo'"
								+ " maxlength='45' readonly size='60' value='" + nomecargo + "'><br><br>");

				
				out.println("<input style='font-size:110%;font-weight:bold;background:black;color: white;'"+ " type='submit' name='btnOpcao' value='Retornar Cargo Alterar'>");
				out.println("</form>");
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
			out.println("<a href='"+retorno+"'/>Retornar para o "+nomeretorno+"</a>");
			out.println("</body>");
			out.println("</html>");
			
		}
	}

}
