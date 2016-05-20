package br.com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class MontaTela extends JFrame {

	/**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 5554725647535056603L;
	private static int identificacao;
	protected static JMenu mnBuscar;
	protected static JMenu mnRelatorio;
	protected static JMenuItem mntmSair;

	/**
	 * Create the frame.
	 */
	public MontaTela() {
		super("UNIVERSIDADE FEDERAL DA BAHIA - Sistema de chamadas");
		this.setBounds(100, 100, 800, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.setEnabled(false);
		mntmSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					menus(false);
					setContentPane(new TelaLogin());
					identificacao = 0;
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		mnOpes.add(mntmSair);
		
		JSeparator separator = new JSeparator();
		mnOpes.add(separator);

		JMenuItem mntmFechar = new JMenuItem("Fechar");
		mnOpes.add(mntmFechar);
		mntmFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		mnBuscar = new JMenu("Buscar");
		mnBuscar.setEnabled(false);
		menuBar.add(mnBuscar);
		
		JMenuItem mntmDisciplina = new JMenuItem("Nova busca");
		mntmDisciplina.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					TelaPesquisaDisiciplina dialog = new TelaPesquisaDisiciplina();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mnBuscar.add(mntmDisciplina);		
		mnRelatorio = new JMenu("Relat\u00F3rio");
		mnRelatorio.setEnabled(false);
		menuBar.add(mnRelatorio);
		
		JMenuItem mntmNovo = new JMenuItem("Novo");
		mnRelatorio.add(mntmNovo);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		mnAjuda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub				
				
			}
		});
		setContentPane(new TelaLogin());
	}
	
	public static void menus(boolean estado) {
		mnBuscar.setEnabled(estado);
		mnRelatorio.setEnabled(estado);
		mntmSair.setEnabled(estado);
		
	}

	public static int getIdentificacao() {
		return identificacao;
	}

	public static void setIdentificacao(int identificacao) {
		MontaTela.identificacao = identificacao;
	}
}
