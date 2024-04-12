package modelo;

import java.util.Date;

public class Aluno {
	
	
		private String email;
		private String matricula;
		private int turma;
		private String nome;
	
		private String sexo;
		private String senha;
		private int codCurso;
		

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

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public static CursoHibernate getCurso() {
			// TODO Auto-generated method stub
			return null;
		}

}
