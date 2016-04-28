package br.com.negocio;

public class PesquisaTurma implements Pesquisar {

	@Override
	public FazPesquisa exibePesquisa(int id) {
		// TODO Auto-generated method stub
		FazPesquisa fazPesquisa = new FazPesquisa();
		fazPesquisa.fazPesquisa(id);
		return fazPesquisa;
	}

	@Override
	public Pesquisa exibePesquisa(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
