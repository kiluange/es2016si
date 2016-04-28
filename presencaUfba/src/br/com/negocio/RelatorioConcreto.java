package br.com.negocio;

public class RelatorioConcreto extends CriaRelatorio {

	@Override
	Relatorio criaRelatorio() {
		// TODO Auto-generated method stub
		return new ExibeRelatorio();
	}	

}
