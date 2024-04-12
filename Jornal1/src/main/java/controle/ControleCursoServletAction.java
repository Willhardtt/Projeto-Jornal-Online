package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoCursoHibernate;
import modelo.CursoHibernate;

/**
 * Servlet implementation class ControleCursoServletAction
 */
public class ControleCursoServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ControleCursoServletAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeCurso = request.getParameter("txtNomeCurso");
		int idCurso;
		String verificarCodigo = request.getParameter("txtIdCurso");
		String verificarCodigoConsulta = request.getParameter("selCurso");
		String botao = request.getParameter("btnOpcao");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String resultado;
		String nomeretorno = "", retorno = "";
		try {
			DaoCursoHibernate daocurso = new DaoCursoHibernate();
			if (botao.equals("Cadastrar")) {
				retorno = "CursoCadastrar.jsp";
				nomeretorno = "Curso Cadastrar";
				if (nomeCurso.equals("")) {
					throw new Exception("Favor preencher todas as caixas.");
				}
				CursoHibernate curso = new CursoHibernate();
				curso.setNomeCurso(nomeCurso);
				daocurso.incluir(curso);
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println(
						"<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Cadastro realizado com sucesso</h1>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Curso: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ curso.getIdCurso() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ curso.getNomeCurso() + "</label><br><br>");
				out.println("<a href='CursoCadastrar.jsp'/>Curso Cadastrar</a>");
				out.println("</body>");
				out.println("</html>");
			}
			if (botao.equals("Cancelar")) {
				String redirectURL = "TelaCurso.jsp";
				response.sendRedirect(redirectURL);
			}
			if (botao.equals("Consultar")) {
				retorno = "CursoConsultar.jsp";
				nomeretorno = "Curso Consultar";
				if (verificarCodigoConsulta == null || verificarCodigoConsulta == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idCurso = Integer.parseInt(verificarCodigoConsulta);
				// consultar pelo id do Curso
				CursoHibernate curso = daocurso.consultarPorCurso(String.valueOf(idCurso));

				if (curso == null) {
					throw new Exception("Curso não está Cadastrado.");
				}
				daocurso.consultarPorCurso(String.valueOf(idCurso));
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
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Curso: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ curso.getIdCurso() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
				out.println("<a href='CursoConsultar.jsp'/>Retornar para Curso Consultar</a>");
				out.println("</body>");
				out.println("</html>");
			}
			if (botao.equals("Excluir")) {
				retorno = "CursoExcluir.jsp";
				nomeretorno = "Curso Excluir";
				if (verificarCodigoConsulta == null || verificarCodigoConsulta == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idCurso = Integer.parseInt(verificarCodigoConsulta);
				// consultar pelo id do Curso
				CursoHibernate curso = daocurso.consultarPorCurso(String.valueOf(idCurso));

				if (curso == null) {
					throw new Exception("Curso não está Cadastrado.");
				}
				daocurso.excluir(curso);
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='text-align: center;'>Sistema de Banco de dados</h1>");
				out.println(
						"<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Exclusão realizada com sucesso</h2>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Curso: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ curso.getIdCurso() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
				out.println("<a href='CursoExcluir.jsp'/>Retornar para Curso Excluir</a>");
				out.println("</body>");
				out.println("</html>");
			}
			if (botao.equals("Alterar")) {
				retorno = "CursoAlterar.jsp";
				nomeretorno = "Curso Alterar";
				if (verificarCodigoConsulta == null || verificarCodigoConsulta == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idCurso = Integer.parseInt(verificarCodigoConsulta);
				// consultar pelo id do Curso
				CursoHibernate curso = daocurso.consultarPorCurso(String.valueOf(idCurso));
				if (curso == null) {
					throw new Exception("Curso não está Cadastrado.");
				}
				idCurso = curso.getIdCurso();
				nomeCurso = curso.getNomeCurso();
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
				out.println("<form name='frmCurso2' action='ControleCursoServletAction' method='post'>");
				out.println(
						"<label style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Altere os dados</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Curso: </label>");
				out.println(
						"<input style='font-weight:bold;color: darkblue;' type='text' name='txtCodDepto' maxlength='10'+"
								+ " readonly size='10' value='" + idCurso + "'><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
				out.println(
						"<input style='font-size:110%;font-weight:bold;color: darkblue;' type='text' name='txtCurso'"
								+ " maxlength='45' size='60' value='" + nomeCurso + "'><br><br>");
				out.println("<input type='submit' name='btnOpcao' value='Confirmar Alteração'>");
				out.println("<input type='submit' name='btnOpcao' value='Cancelar'>");
				out.println("</form>");
				out.println("<p><a href='CursoAlterar.jsp'/>Retornar para Curso Alterar</a></p>");
				out.println("</body>");
				out.println("</html>");
			}
			if (botao.equals("Confirmar Alteração")) {
				retorno = "CursoAlterar.jsp";
				nomeretorno = "Curso Alterar";
				if (verificarCodigo == null || verificarCodigo == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idCurso = Integer.parseInt(verificarCodigo);
				CursoHibernate curso = new CursoHibernate();
				curso.setIdCurso(idCurso);
				curso.setNomeCurso(nomeCurso);
				daocurso.alterar(curso);
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
				out.println("<form name='frmCurso2' action='CursoAlterar.jsp' method='post'>");
				out.println(
						"<label style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Curso</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Curso: </label>");
				out.println(
						"<input style='font-weight:bold;color: darkblue;' type='text' name='txtCodDepto' maxlength='10'+"
								+ " readonly size='10' value='" + idCurso + "'><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
				out.println(
						"<input style='font-size:110%;font-weight:bold;color: darkblue;' type='text' name='txtCurso'"
								+ " maxlength='45' readonly size='60' value='" + nomeCurso + "'><br><br>");
				out.println("<input style='font-size:110%;font-weight:bold;background:black;color: white;'"
						+ " type='submit' name='btnOpcao' value='Retornar Curso Alterar'>");
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
			out.println("<a href='" + retorno + "'/>Retornar para o " + nomeretorno + "</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
