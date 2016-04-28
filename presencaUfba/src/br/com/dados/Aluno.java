package br.com.dados;

import java.util.List;

public class Aluno {
	private int id;
	private String matricula;
	private String nome;
	private List<Boolean> presenca;
	
	public Aluno(int id, String matricula,String nome, List<Boolean> presenca) {
		// TODO Auto-generated constructor stub
		setId(id);
		setMatricula(matricula);
		setNome(nome);
		setPresenca(presenca);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Boolean> getPresenca() {
		return presenca;
	}

	public void setPresenca(List<Boolean> presenca) {
		this.presenca = presenca;
	}

}
