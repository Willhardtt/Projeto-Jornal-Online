package modelo;

public class Curso {
	
    private String nomeCurso;
	

    public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	

	@Override
	public String toString() {
		return "Nome do curso: " + getNomeCurso();
	}

}
