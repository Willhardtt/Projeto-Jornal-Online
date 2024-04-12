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

import dao.DaoAlunoHibernate;
import dao.DaoCursoHibernate;
import modelo.AlunoHibernate;

import modelo.CursoHibernate;

import modelo.Aluno;


/**
 * Servlet implementation class ControleAlunoServletAction
 */
public class ControleAlunoServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleAlunoServletAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String verificarCodigo = request.getParameter("txtIdAluno");
		String verificarCodigoConsulta=request.getParameter("selAluno");
		String nome = request.getParameter("txtNome");
		String matricula = request.getParameter("txtMatricula");
      
		String turma = request.getParameter("txtTurma");
	
		String Sexo = request.getParameter("txtSexo");
		
		String email = request.getParameter("txtEmail");
	
		String senha = request.getParameter("txtSenha");
		String botao = request.getParameter("btnOpcao");
		
		String idcurso = request.getParameter("selCurso");
		String selaluno = request.getParameter("selaluno");
		
		
		
		int idAluno;
		int codcurso;
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String resultado;
		String nomeretorno = "", retorno = "";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("0.00");		
		
		
		
		
		
		
		
		
		
		
		try {
			DaoCursoHibernate daocursohibernate = new DaoCursoHibernate();
			ArrayList<CursoHibernate> cursos = (ArrayList) daocursohibernate.listar();
			DaoAlunoHibernate daoaluno = new DaoAlunoHibernate();
			if (botao.equals("Cadastrar")) {
				retorno = "TelaCadastroAluno.jsp";
				nomeretorno = "Aluno Cadastrar";
				if (nome.equals("") ||  Sexo.equals("")|| email.equals("") || matricula.equals("") || idcurso.equals("") ) {
					throw new Exception("Favor preencher todas as caixas.");
				}
				
				CursoHibernate cursohibernate = new CursoHibernate();
				cursohibernate.setIdCurso(Integer.parseInt(idcurso));
				
				
				AlunoHibernate aluno = new AlunoHibernate();
			
			
			
				aluno.setMatricula(matricula);
			
				aluno.setSexo(Sexo);
				aluno.setTurma(Integer.parseInt(turma));
				
				aluno.setEmail(email);
				aluno.setSenha(senha);
				
				aluno.setCurso(cursohibernate);
				
				
				
				daoaluno.incluir(aluno);
				cursohibernate=daocursohibernate.consultar(aluno.getCurso().getIdCurso());
				String nomeCurso= cursohibernate.getNomeCurso();
				
				
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println(
						"<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Cadastro realizado com sucesso</h1>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Aluno: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getIdAluno() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Turma: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getTurma() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Aluno: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>" + aluno.getNome()
						+ "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Matricula: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>" + aluno.getMatricula()
						+ "</label><br><br>");
			
						out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");
						out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
								+ aluno.getSexo() + "</label><br><br>");
						
						out.println("<label style='font-size:110%;font-weight:bold;'>Email: </label>");
						out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
								+ aluno.getEmail() + "</label><br><br>");
						
						out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Curso: </label>");				
						out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getCurso().getIdCurso()+"</label><br><br>");
						
						out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
						out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selCurso'>");		
						for(CursoHibernate curso : cursos){
							if (curso.getIdCurso()==aluno.getCurso().getIdCurso())
							{
								out.println("<option value="+curso.getIdCurso()+">"+curso.getNomeCurso()+"</option>");
							}
						}
				
				
				
				
				out.println("<a href='" + retorno + "'" + "/>" + nomeretorno + "</a>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			if (botao.equals("Consultar")) {
				retorno = "AlunoConsultar.jsp";
				nomeretorno = "Aluno Consultar";
				if (selaluno == null || selaluno == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idAluno = Integer.parseInt(selaluno);
				// consultar pelo id do Aluno
				AlunoHibernate aluno = new AlunoHibernate();
				CursoHibernate cursohibernate = new CursoHibernate();
				
				aluno=daoaluno.consultar(idAluno);
				
				cursohibernate=daocursohibernate.consultar(aluno.getCurso().getIdCurso());
				
				String nomeCurso= cursohibernate.getNomeCurso();
				
				AlunoHibernate al = daoaluno.consultarPorAluno(String.valueOf(idAluno));
				
				if (al == null) {
					throw new Exception("Aluno não está Cadastrado.");
				}
				
				daoaluno.consultarPorAluno(String.valueOf(idAluno));
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
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Aluno: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getIdAluno() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Aluno: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getNome()+"</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getTurma() + "</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Matrícula: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getMatricula()+"</label><br><br>");
			
				out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getSexo()+"</label><br><br>");
								
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Curso: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getCurso().getIdCurso()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selCurso'>");		
				for(CursoHibernate curso : cursos){
					if (curso.getIdCurso()==aluno.getCurso().getIdCurso())
					{
						out.println("<option value="+curso.getIdCurso()+">"+curso.getNomeCurso()+"</option>");
					}
				}
		
		
		
		
				out.println("<a href='" + retorno + "'" + "/>" + nomeretorno + "</a>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			if (botao.equals("Excluir")) {
				retorno = "AlunoExcluir.jsp";
				nomeretorno = "Aluno Excluir";
				if (selaluno == null || selaluno == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idAluno = Integer.parseInt(selaluno);
				// consultar pelo id do Aluno
				AlunoHibernate aluno = daoaluno.consultarPorAluno(String.valueOf(idAluno));

				if (aluno == null) {
					throw new Exception("Aluno não está Cadastrado.");
				}
				daoaluno.excluir(aluno);
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1 style='text-align: center;'>Sistema de Banco de dados</h1>");
				out.println(
						"<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Exclusï¿½o realizada com sucesso</h2>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Cï¿½digo do Aluno: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getIdAluno() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Aluno: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getNome()+"</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getTurma() + "</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Matrícula: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getMatricula()+"</label><br><br>");
			
				out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getSexo()+"</label><br><br>");
				
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Curso: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getCurso().getIdCurso()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selCurso'>");		
				for(CursoHibernate curso : cursos){
					if (curso.getIdCurso()==aluno.getCurso().getIdCurso())
					{
						out.println("<option value="+curso.getIdCurso()+">"+curso.getNomeCurso()+"</option>");
					}
				}
				
				
				out.println("<a href='AlunoExcluir.jsp'/>Retornar para Aluno Excluir</a>");
				out.println("<form name='frmAluno' action='ControleAlunoinistradorServletAction' method='post'>");
				out.println("<input type='submit' name='btnOpcao' value='Confirmar Exclusão'>");
				out.println("<input type='submit' name='btnOpcao' value='Cancelar Exclusão'>");
				out.println("</form>");
				out.println("<a href='" + retorno + "'" + "/>" + nomeretorno + "</a>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
			if (botao.equals("Confirmar Exclusão")) {
				retorno = "AlunoExcluir.jsp";
				nomeretorno = "Aluno Excluir";
				if (selaluno == null || selaluno == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idAluno = Integer.parseInt(verificarCodigo);
				// consultar pelo id do Aluno
				AlunoHibernate aluno = daoaluno.consultarPorAluno(String.valueOf(idAluno));

				if (aluno == null) {
					throw new Exception("Alunoinistrador não está cadastrado.");
				}
				CursoHibernate cursohibernate = new CursoHibernate();
				daoaluno.excluir(aluno);
				
				String nomeCurso= cursohibernate.getNomeCurso();
				
					
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
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getNome()+"</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Matricula: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getMatricula()+"</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Email: </label>");	
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getEmail()+"</label><br><br>");
			
				out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getSexo()+"</label><br><br>");
				out.println("<h2 style='font-size:200%;padding-top:10px;padding-bottom:10px;'>Exclusão realizada com sucesso</h2>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Alunoinistrador: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getIdAluno() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Alunoinistrador: </label>");
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Curso: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getCurso().getIdCurso()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selCurso'>");		
				for(CursoHibernate curso : cursos){
					if (curso.getIdCurso()==aluno.getCurso().getIdCurso())
					{
						out.println("<option value="+curso.getIdCurso()+">"+curso.getNomeCurso()+"</option>");
					}
				} 
				
		
				out.println("<br><br>");
				out.println("<a href='" + retorno + "'" + "/>" + nomeretorno + "</a>");
				out.println("</body>");
				out.println("</html>");
			
			
			}
			if (botao.equals("Cancelar Exclusão")) {
				String redirectURL = "AlunoExcluir.jsp";
				response.sendRedirect(redirectURL);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (botao.equals("Alterar")) {
				retorno = "AlunoAlterar.jsp";
				nomeretorno = "Aluno Alterar";
				if (selaluno == null || selaluno == "") {
					throw new Exception("Favor preencher todas as caixas.");
				}
				idAluno = Integer.parseInt(selaluno);
				// consultar pelo id do Aluno
				AlunoHibernate aluno = new AlunoHibernate();
				CursoHibernate cursohibernate = new CursoHibernate();
				
				aluno=daoaluno.consultar(idAluno);
				
				cursohibernate=daocursohibernate.consultar(aluno.getCurso().getIdCurso());
				
				String nomeCurso= cursohibernate.getNomeCurso();
				
				AlunoHibernate al = daoaluno.consultarPorAluno(String.valueOf(idAluno));
				
				if (al == null) {
					throw new Exception("Aluno não está Cadastrado.");
				}
				idAluno = aluno.getIdAluno();
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
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Aluno: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getIdAluno() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Aluno: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getNome()+"</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getTurma() + "</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Matrícula: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getMatricula()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getSexo()+"</label><br><br>");
				
				out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Curso: </label>");				
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getCurso().getIdCurso()+"</label><br><br>");
				
				out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selCurso'>");		
				for(CursoHibernate curso : cursos){
					if (curso.getIdCurso()==aluno.getCurso().getIdCurso())
					{
						out.println("<option value="+curso.getIdCurso()+">"+curso.getNomeCurso()+"</option>");
					}
				}
		
		
		
		
				out.println("<p><a href='TelaAluno.jsp'/>Retornar a tela Aluno</a></p>");
				out.println("</body>");
				out.println("</html>");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (botao.equals("Confirmar Alteração")) {
				retorno = "AlunoAlterar.jsp";
				nomeretorno = "Aluno Alterar";
				if (nome.equals("") ||  Sexo.equals("")|| email.equals("") || matricula.equals("") || idcurso.equals("") ) {
					throw new Exception("Favor preencher todas as caixas.");
				}
				
				idAluno = Integer.parseInt(verificarCodigo);
				AlunoHibernate aluno = new AlunoHibernate();
				CursoHibernate cursohibernate = new CursoHibernate();
				cursohibernate.setIdCurso(Integer.parseInt(idcurso));
				
				
			
				aluno.setNome(nome);
				aluno.setMatricula(matricula);
				aluno.setSexo(Sexo);
				aluno.setTurma(Integer.parseInt(turma));
			
				aluno.setEmail(email);
				aluno.setSenha(senha);
				
				
				daoaluno.alterar(aluno);
				cursohibernate=daocursohibernate.consultar(aluno.getCurso().getIdCurso());
				String nomeCurso= cursohibernate.getNomeCurso();
					
				
				
				out.println("<!doctype html>");
				out.println("<html lang='pt-br'>");
				out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
				out.println("<link rel='stylesheet' href='css/estilo.css' />");
				out.println("</head>");
				out.println("<body>");
				out.println(
						"<h1 style='font-size:150%;padding-top:10px;padding-bottom:10px;'>Cadastro realizado com sucesso</h1>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Código do Aluno: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getIdAluno() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Turma: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
						+ aluno.getTurma() + "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Aluno: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>" + aluno.getNome()
						+ "</label><br><br>");
				out.println("<label style='font-size:110%;font-weight:bold;'>Matricula: </label>");
				out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>" + aluno.getMatricula()
						+ "</label><br><br>");
				
						out.println("<label style='font-size:110%;font-weight:bold;'>Sexo: </label>");
						out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
								+ aluno.getSexo() + "</label><br><br>");
						
					

					
						out.println("<label style='font-size:110%;font-weight:bold;'>Email: </label>");
						out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"
								+ aluno.getEmail() + "</label><br><br>");
						
						out.println("<br><br><label style='font-size:110%;font-weight:bold;'>Cód. Curso: </label>");				
						out.println("<label style='font-size:110%;font-weight:bold;color: darkblue;'>"+aluno.getCurso().getIdCurso()+"</label><br><br>");
						
						out.println("<label style='font-size:110%;font-weight:bold;'>Curso: </label>");
						out.println("<label style='font-size:110%;font-weight:bold;color: black;'><select name='selCurso'>");		
						for(CursoHibernate curso : cursos){
							if (curso.getIdCurso()==aluno.getCurso().getIdCurso())
							{
								out.println("<option value="+curso.getIdCurso()+">"+curso.getNomeCurso()+"</option>");
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
