package br.com.dados;

import java.util.LinkedList;
import java.util.List;

public class Turma {
	private int id;
	private int fkDisciplina;
	private String codigo;
	private String hora;
	private String pavilhao;
	private String sala;
	private String nomeDisciplina;
	private int cHoraria;
	private LinkedList<Aluno> alunos;

	public Turma(int id, int fkDisciplina, String codigo, String hora, String pavilhao ,String sala, String nomeDisciplina, int cHoraria, List<Aluno> alunos) {
		// TODO Auto-generated constructor stub
		setId(id);
		setFkDisciplina(fkDisciplina);
		setCodigo(codigo);
		setHora(hora);
		setPavilhao(pavilhao);
		setSala(sala);
		setNomeDisciplina(nomeDisciplina);
		setcHoraria(cHoraria);
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

	private void setSala(String sala) {
		this.sala = sala;
	}

	public String getPavilhao() {
		return pavilhao;
	}

	private void setPavilhao(String pavilhao) {
		this.pavilhao = pavilhao;
	}

	public LinkedList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(LinkedList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	private void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getcHoraria() {
		return cHoraria;
	}

	private void setcHoraria(int cHoraria) {
		this.cHoraria = cHoraria;
	}

}
