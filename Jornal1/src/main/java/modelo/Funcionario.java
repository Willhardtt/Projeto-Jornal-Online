package modelo;

import java.util.Date;

public class Funcionario {

	private String email;
	private String nome;

	private String sexo;
	private String senha;
	private int codCargo;
	private int codDepartamento;



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getCodCargo() {
		return codCargo;
	}

	public void setCodCargo(int codCargo) {
		this.codCargo = codCargo;
	}

	public int getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public static DepartamentoHibernate getDepartamento() {
		// TODO Auto-generated method stub
		return null;
	}

	public static FuncionarioHibernate getCargo() {
		// TODO Auto-generated method stub
		return null;
	}


}
