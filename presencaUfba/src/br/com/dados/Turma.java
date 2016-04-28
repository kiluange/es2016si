package br.com.dados;

public class Turma {
	private int id;
	private int fkDisciplina;
	private String codigo;
	private String hora;
	private String pavilhao;
	private String sala;

	public Turma(int id, int fkDisciplina, String codigo, String hora, String pavilhao ,String sala) {
		// TODO Auto-generated constructor stub
		setId(id);
		setFkDisciplina(fkDisciplina);
		setCodigo(codigo);
		setHora(hora);
		setPavilhao(pavilhao);
		setSala(sala);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public int getFkDisciplina() {
		return fkDisciplina;
	}

	private void setFkDisciplina(int fkDisciplina) {
		this.fkDisciplina = fkDisciplina;
	}

	public String getCodigo() {
		return codigo;
	}

	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getHora() {
		return hora;
	}

	private void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getPavilhao() {
		return pavilhao;
	}

	public void setPavilhao(String pavilhao) {
		this.pavilhao = pavilhao;
	}

}
