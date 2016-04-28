package br.com.negocio;

import br.com.dados.Professor;
import br.com.db.QueryUsuarioDB;

public class Logado extends PesquisaUsuario {
	
	private boolean pass;
	
	private String nome;
	private String user;
	private String senha;
	
	Professor professor = new Professor();
	private QueryUsuarioDB db;
	
	
	protected boolean retornaStatus() {
		return isPass();
		
	}

	public boolean isPass() {
		return pass;
	}
	
	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setPass(boolean pass) {
		this.pass = pass;
	}

	protected String getUser() {
		return user;
	}

	protected void setUser(String user) {
		this.user = user;
	}

	protected String getSenha() {
		return senha;
	}

	protected void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	Professor Pesquisa(String user) {
		setDb(new QueryUsuarioDB(user));
		professor.setNome(getDb().getName());
		professor.setUsuario(getDb().getLogin());
		professor.setSenha(getDb().getSenha());
		return professor;
	}

	public QueryUsuarioDB getDb() {
		return db;
	}

	public void setDb(QueryUsuarioDB db) {
		this.db = db;
	}	

}
