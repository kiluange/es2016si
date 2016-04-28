package br.com.negocio;

import java.util.List;

import br.com.dados.Disciplina;
import br.com.dados.Turma;

public interface Pesquisa {

	List<Disciplina> fazPesquisa(String string);
	List<Turma> fazPesquisa(int id);

}
