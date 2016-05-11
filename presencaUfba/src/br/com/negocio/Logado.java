package br.com.negocio;

import br.com.dados.Professor;
import br.com.db.QueryUsuarioDB;

public class Logado extends PesquisaUsuario {
	
	private boolean pass = false;
	private QueryUsuarioDB db;		
	
	@Override
	Professor Pesquisa(String user) {
		setDb(new QueryUsuarioDB(user));
		return db.getProfessor();
	}

	public QueryUsuarioDB getDb() {
		return db;
	}

	public void setDb(QueryUsuarioDB db) {
		this.db = db;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
