package br.com.negocio;

public class Fachada {

	private Logado logado;
	private FazPesquisa fazPesquisa;

	/*
	 * Metodos LOGIN
	 */
	public void login(String user, String senha) {
		setLogado(Login.getInstance().verificaLogin(user, senha));
	}

	public Logado getLogado() {
		return logado;
	}

	public void setLogado(Logado logado) {
		this.logado = logado;
	}

	/*
	 * Metodos pesquisa disciplina
	 */

	public void pesquisaDisciplina(String string) {
		PesquisaDisciplina disciplina = new PesquisaDisciplina();
		setFazPesquisa(disciplina.exibePesquisa(string));
	}

	public FazPesquisa getFazPesquisa() {
		return fazPesquisa;
	}

	public void setFazPesquisa(FazPesquisa fazPesquisa) {
		this.fazPesquisa = fazPesquisa;
	}

	/*
	 * Metodos pesquisa turma
	 */
	public void pequisaTurma(int disciplinaId) {
		PesquisaTurma turma = new PesquisaTurma();
		setFazPesquisa(turma.exibePesquisa(disciplinaId));
	}

}
