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
public class PessoaHibernate {
	@Id //@Id diz que o atributo, que tem id, ser� a chave primaria
	@GeneratedValue(strategy = GenerationType.AUTO) // @GeneratedValue diz que o valor ser� auto incrementado
	private int idPessoa;

	@ManyToOne
	@JoinColumn(name = "ceIdCodAluno") // nome da chave estrangeira na tabela Funcion�rio
	private AlunoHibernate aluno;

	private String filiacaoPai;
	private String filiacaoMae;
	private int cpf;
	private int rg;
	private String orgaoEmissor;
	private String nacionalidade;
	private String naturalidade;
	private String nome;
	private Date nascimento;
	private String sexo;
	private String estadoCivil;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String municipio;
	private String Estado;
	private String telefone;

	
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getFiliacaoPai() {
		return filiacaoPai;
	}
	public void setFiliacaoPai(String filiacaoPai) {
		this.filiacaoPai = filiacaoPai;
	}
	public String getFiliacaoMae() {
		return filiacaoMae;
	}
	public void setFiliacaoMae(String filiacaoMae) {
		this.filiacaoMae = filiacaoMae;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}
	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public AlunoHibernate getAluno() {
		return aluno;
	}
	public void setAluno(AlunoHibernate aluno) {
		this.aluno = aluno;
	}
	
	@Override 
	public String toString() { 
	  	return 	//"ID do Al: " + getIdmatricula() + 
	  			"\nAluno(a): " + getNome() + 
	  			"\nNascimento: " + getNascimento();
	  			
	}    
} // fim  da class FuncionarioHibernate
