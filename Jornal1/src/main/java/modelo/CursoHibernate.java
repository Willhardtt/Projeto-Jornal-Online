package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial") //Este ignora um aviso
@Entity //@Entity diz que a classe vai virar tabela
public class CursoHibernate {
	@Id //@Id diz que o atributo, que tem id, serï¿½ a chave primaria
	@GeneratedValue(strategy = GenerationType.AUTO) // @GeneratedValue diz que o valor serï¿½ auto incrementado
	private int idCurso;
	private String nomeCurso;
	
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso (int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	

	@Override
	public String toString() {
		return "Código do Curso: " + getIdCurso();
	}	

}
