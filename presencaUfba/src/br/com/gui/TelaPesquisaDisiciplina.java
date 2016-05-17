package br.com.gui;

import java.awt.Choice;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.dados.Disciplina;
import br.com.dados.Turma;
import br.com.negocio.Fachada;

public class TelaPesquisaDisiciplina extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2900530534283095506L;
	private JTextField textField;

	Choice choice = new Choice();
	List list = new List();
	JLabel lblTurma = new JLabel("Turma");
	JButton btnAbrir = new JButton("Abrir");

	Fachada fachada = new Fachada();

	/**
	 * Create the dialog.
	 */
	public TelaPesquisaDisiciplina() {
		setTitle("Pesquisa Disciplina");
		setBounds(100, 100, 540, 531);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(rootPane);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Pesquisa");
			lblNewLabel.setBounds(10, 12, 42, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(57, 10, 128, 20);
			getContentPane().add(textField);
			textField.setColumns(30);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(190, 9, 47, 23);
			getContentPane().add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					fachada.pesquisaDisciplina(textField.getText());
					choice.removeAll();
					for (Disciplina disciplina : fachada.getFazPesquisa().getDb().getAllDisciplinas()) {
						choice.add(disciplina.getCodigo() + " - " + disciplina.getNome());
					}
					lblTurma.setEnabled(true);
					choice.setEnabled(true);
					btnAbrir.setEnabled(true);
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			choice.setBounds(286, 10, 175, 20);
			getContentPane().add(choice);
			choice.setEnabled(false);
		}
		lblTurma.setBounds(249, 13, 30, 14);
		getContentPane().add(lblTurma);
		lblTurma.setEnabled(false);
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(459, 468, 65, 23);
			getContentPane().add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		btnAbrir.setBounds(467, 9, 55, 23);
		getContentPane().add(btnAbrir);
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list.removeAll();
				for (Disciplina disciplina : fachada.getFazPesquisa().getDb().getAllDisciplinas()) {
					if (choice.getSelectedItem().equals(disciplina.getCodigo() + " - " + disciplina.getNome())) {
						fachada.pequisaTurma(disciplina.getId());
					}
				}
				for (Turma turma : fachada.getFazPesquisa().getQtBd().getAllTurmas()) {
					list.add("Turma: " + turma.getCodigo() + " Hora: " + turma.getHora() + " Sala: "
							+ turma.getPavilhao() + " - " + turma.getSala());
				}

			}
		});
		btnAbrir.setEnabled(false);
		
		list = new List();
		list.setFont(new Font("Dialog", Font.PLAIN, 14));
		list.setBounds(10, 53, 514, 343);
		list.setMultipleMode(false);
		getContentPane().add(list);
		{
			JButton btnAbrir_1 = new JButton("Abrir");
			btnAbrir_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					for (Turma turma : fachada.getFazPesquisa().getQtBd().getAllTurmas()) {
						// get com -1 porque o campo list começa em 0 e a lista
						// de turmas começa em 1
						if (turma.getId() - 1 == list.getSelectedIndex()) {
							new TelaTurma(turma.getNomeDisciplina(), turma.getCodigo(), turma.getcHoraria(), turma.getAlunos()).setVisible(true);
						}
					}
				}
			});
			btnAbrir_1.setBounds(435, 402, 89, 23);
			getContentPane().add(btnAbrir_1);
		}
	}
}
