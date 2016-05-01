package br.com.dados;

public class Professor {
	private int id ;
	private String nome;
	private String usuario;
	private String senha;
	
	//Constructor
	public Professor(int id, String nome, String usuario, String senha) {
		// TODO Auto-generated constructor stub
		setId(id);
		setNome(nome);
		setUsuario(usuario);
		setSenha(senha);
	}
	
	//getter e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
