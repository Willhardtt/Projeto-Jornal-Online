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
public class FuncionarioHibernate {
	@Id //@Id diz que o atributo, que tem id, seria a chave primaria
	@GeneratedValue(strategy = GenerationType.AUTO) // @GeneratedValue diz que o valor serï¿½ auto incrementado
	@ManyToOne
	private int idAdm;
	
	@ManyToOne
	@JoinColumn(name = "cecodCargo") // nome da chave estrangeira na tabela Funcionário
	private CargoHibernate cargo;
	
	@ManyToOne
	@JoinColumn(name = "cecodDepartamento") // nome da chave estrangeira na tabela Funcionário
	private DepartamentoHibernate departamento;
	
	private String email;
	private String nome;
	private String sexo;
	private String senha;
	private int codCargo;
	private int codDepartamento;
	
	public int getIdAdm() {
		return idAdm;
	}
	public void setIdAdm(int idAdm) {
		this.idAdm = idAdm;
	}
	public CargoHibernate getCargo() {
		return cargo;
	}
	public void setCargo(CargoHibernate cargo) {
		this.cargo = cargo;
	}
	public DepartamentoHibernate getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoHibernate departamento) {
		this.departamento = departamento;
	}
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
	

}
