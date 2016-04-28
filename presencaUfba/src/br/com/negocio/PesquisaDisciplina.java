package br.com.negocio;

public class PesquisaDisciplina implements Pesquisar {

	@Override
	public FazPesquisa exibePesquisa(String string) {
		FazPesquisa fazPesquisa = new FazPesquisa();
		fazPesquisa.fazPesquisa(string);		
		// TODO Auto-generated method stub
		return fazPesquisa;
	}

	@Override
	public FazPesquisa exibePesquisa(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
