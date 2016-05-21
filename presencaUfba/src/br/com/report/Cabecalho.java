package br.com.report;

public class Cabecalho {
	
	public String departamento;
	public String disciplina;
	public String periodo_letivo;
	public String turma;
	public int carga_hoarria;
	
	//Métodos para o departamento
	public void setDepartamento(String departamento){
		this.departamento = departamento;
	}
	public String getDepartamento() {
		return this.departamento;
	}

	//Métodos para a disciplina
	public void setDisciplina(String disciplina){
		this.disciplina = disciplina;
	}
	public String getDisciplina() {
		return this.disciplina;
	}

	//Métodos para o periodoletivo
	public void setPeriodo_letivo(String periodo_letivo){
		this.periodo_letivo = periodo_letivo;
	}
	public String getPeriodo_letivo() {
		return this.periodo_letivo;
	}	
	
	//Métodos para a turma
	public void setTurma(String turma){
		this.turma = turma;
	}
	public String getTurma() {
		return this.turma;
	}	
	
	//Métodos para a carga horária
	public void setCarga_horaria(int i){
		this.carga_hoarria = i;
	}
	public int getCarga_horaria() {
		return this.carga_hoarria;
	}

}
