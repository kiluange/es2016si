package br.com.dados;

public class Disciplina {
	private int id;
	private String codigo;
	private String nome;
	private int cargaHoraria;
	
	public Disciplina(int id, String codigo, String nome, int cargaHoraria) {
		// TODO Auto-generated constructor stub
		setId(id);
		setCodigo(codigo);
		setNome(nome);
		setCargaHoraria(cargaHoraria);
	}
	
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}	
	public String getCodigo() {
		return codigo;
	}
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	private void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	

}
