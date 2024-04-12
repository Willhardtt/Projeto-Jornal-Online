package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial") //Este ignora um aviso
@Entity //@Entity diz que a classe vai virar tabela
public class AlunoHibernate {
	@Id //@Id diz que o atributo, que tem id, serï¿½ a chave primaria
	@GeneratedValue(strategy = GenerationType.AUTO) // @GeneratedValue diz que o valor serï¿½ auto incrementado
	@ManyToOne
	private int idAluno;
	
	@ManyToOne
	@JoinColumn(name = "cecodCurso") // nome da chave estrangeira na tabela Funcionário
	private CursoHibernate curso;
	
	
	private String email;
	private String matricula;
	private int turma;
	private String nome;
	private String sexo;
	private String senha;
	private int codCurso;
	

	

	public String getNome() {
		return nome;
	}






	public void setNome(String nome) {
		this.nome = nome;
	}






	public int getIdAluno() {
		return idAluno;
	}






	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}






	public CursoHibernate getCurso() {
		return curso;
	}






	public void setCurso(CursoHibernate curso) {
		this.curso = curso;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getMatricula() {
		return matricula;
	}






	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}






	public int getTurma() {
		return turma;
	}






	public void setTurma(int turma) {
		this.turma = turma;
	}






	






	public String getSexo() {
		return sexo;
	}






	public void setSexo(String sexo) {
		this.sexo = sexo;
	}






	public String getSenha() {
		return senha;
	}






	public void setSenha(String senha) {
		this.senha = senha;
	}






	public int getCodCurso() {
		return codCurso;
	}






	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}






	@Override
	public String toString() {
		return "Código do Aluno: " + getIdAluno();
	}	
	
	
}
