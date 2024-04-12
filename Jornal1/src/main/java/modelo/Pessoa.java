package modelo;

import java.util.Date;

public class Pessoa {
	private int Idmatricula;
	private String filiacaoPai;
	private String filiacaoMae;
	private int cpf;
	private int rg;
	private String orgaoEmissor;
	private Date dataValidade;
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
	//private Date dataAdmissao;
	private String senha;
	
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
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
	
	public int getIdmatricula() {
		return Idmatricula;
	}
	public void setIdmatricula(int idmatricula) {
		Idmatricula = idmatricula;
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
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override 
	public String toString() { 
	  	return 	"\nFuncionário(a): " + getNome() + 
	  			"\nNascimento: " + getNascimento() + 
	  			"\nSexo: " + getSexo() + 
	  			
	  			"\nFiliação Mãe: " + getFiliacaoMae() +
	  			"\nFiliação Mãe: " + getFiliacaoPai() +
	  			"\nCPF: " + getCpf() +
	  			"\nRG: " + getRg() +
	  			"\nÓrgão Emissor: " + getOrgaoEmissor() +
	  			"\nData de Validade: " + getDataValidade() +
	  			"\nNaturalidade: " + getNaturalidade() +
	  			"\nNacionalidade: " + getNacionalidade() +
	  			"\nÓrgão Emissor: " + getOrgaoEmissor() +
	  			"\nEstado Civil: " + getEstadoCivil() +
	  			"\nLogradouro: " + getLogradouro() +
	  			"\nNúmero: " + getNumero() +
	  			"\nComplemento: " + getComplemento() +
	  			"\nCEP: " + getCep() + 
	  			"\nBairro: " + getBairro() +
	  			"\nMunicípio: " + getMunicipio() + 
	  			"\nEstado: " + getEstado() + 
	  			"\nTelefone: " + getTelefone();
	  			
	  			
	}    
} // fim  da class Funcionario