package br.com.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.negocio.Fachada;

public class TelaLogin extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5051831552131906791L;
	private JTextField textField;
	private JTextField pwdPassword;
	private static JLabel lblUsurioOuSenha;

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 69, 36, 211, 59, 0 };
		gridBagLayout.rowHeights = new int[] { 4, 20, 20, 23, -28, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblUsurio = new GridBagConstraints();
		gbc_lblUsurio.anchor = GridBagConstraints.WEST;
		gbc_lblUsurio.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsurio.gridx = 1;
		gbc_lblUsurio.gridy = 1;
		add(lblUsurio, gbc_lblUsurio);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(25);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 2;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 1;
		gbc_lblSenha.gridy = 2;
		add(lblSenha, gbc_lblSenha);

		pwdPassword = new JPasswordField();
		pwdPassword.setColumns(25);
		pwdPassword.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.anchor = GridBagConstraints.NORTHWEST;
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 0);
		gbc_pwdPassword.gridwidth = 2;
		gbc_pwdPassword.gridx = 2;
		gbc_pwdPassword.gridy = 2;
		add(pwdPassword, gbc_pwdPassword);

		lblUsurioOuSenha = new JLabel("Usu\u00E1rio ou senha inv\u00E1lidos");
		lblUsurioOuSenha.setForeground(Color.RED);
		lblUsurioOuSenha.setVisible(false);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fachada = new Fachada();
				fachada.login(textField.getText(), pwdPassword.getText());
				// verifica se o retorno e verdadeiro caso não seja ativa msg de
				// erro;
				if (fachada.getLogado().isPass() == false) {
					lblUsurioOuSenha.setVisible(true);
				} else {
					setEnabled(false);
					setVisible(false);
				}
			}
		});
		GridBagConstraints gbc_btnLogar = new GridBagConstraints();
		gbc_btnLogar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnLogar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogar.gridx = 2;
		gbc_btnLogar.gridy = 3;
		add(btnLogar, gbc_btnLogar);
		GridBagConstraints gbc_lblUsurioOuSenha = new GridBagConstraints();
		gbc_lblUsurioOuSenha.anchor = GridBagConstraints.NORTH;
		gbc_lblUsurioOuSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsurioOuSenha.gridx = 2;
		gbc_lblUsurioOuSenha.gridy = 4;
		add(lblUsurioOuSenha, gbc_lblUsurioOuSenha);

	}
}
