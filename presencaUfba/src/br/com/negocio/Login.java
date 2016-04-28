package br.com.negocio;

public class Login extends ControleLogin {
	
	private static Login instance;
	static{
		
	}
	private Login() {
		// TODO Auto-generated constructor stub
	}
	public static Login getInstance() {
		if (instance == null) {
			inicializaInstancia();			
		}
		return instance;		
	}
	
	private static synchronized void inicializaInstancia(){
		if (instance == null) {
			instance = new Login();			
		}
		
	}

	@Override
	Logado verificaLogin(String user, String senha) {
		// TODO Auto-generated method stub
		Logado logado = new Logado();
		logado.Pesquisa(user);
		if (user.equals(logado.professor.getUsuario()) && senha.equals(logado.professor.getSenha())) {
			System.out.println("senha ok");
			logado.setPass(true);
		}else {
			System.out.println("senha errada");
			logado.setPass(false);
		}
		return logado;
	}
}
