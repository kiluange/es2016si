package br.com.negocio;

import java.util.List;

import br.com.dados.Disciplina;
import br.com.dados.Turma;
import br.com.db.QueryDisciplinaDB;
import br.com.db.QueryTurmaDB;


public class FazPesquisa implements Pesquisa {
	
		
	private QueryDisciplinaDB db;
	private QueryTurmaDB QtBd;
	
	//pesquisa disciplina no bd
	@Override
	public List<Disciplina> fazPesquisa(String string){
		// TODO Auto-generated method stub
		setDb(new QueryDisciplinaDB(string));
		return getDb().getAllDisciplinas();
	}

	public QueryDisciplinaDB getDb() {
		return db;
	}

	public void setDb(QueryDisciplinaDB db) {
		this.db = db;
	}
	//pesquisa turma no bd
	@Override
	public List<Turma> fazPesquisa(int id) {
		// TODO Auto-generated method stub
		setQtBd(new QueryTurmaDB(id));
		return getQtBd().getAllTurmas();
	}

	public QueryTurmaDB getQtBd() {
		return QtBd;
	}

	public void setQtBd(QueryTurmaDB qtBd) {
		this.QtBd = qtBd;
	}
	
}
