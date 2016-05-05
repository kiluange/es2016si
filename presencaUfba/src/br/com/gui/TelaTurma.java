package br.com.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class TelaTurma extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7867583403619156890L;
	private final JPanel panel = new JPanel();
	private JTable table;

	/**
	 * Create the dialog.
	 * @param choraria 
	 * @param codigo 
	 * @param string 
	 */
	public TelaTurma(String disciplina, String codigo, String choraria) {
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1012, 568);
		setModal(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{986, 0};
		gridBagLayout.rowHeights = new int[]{56, 462, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, gbc_panel);
		panel.setBorder(null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 116, 129, 428, 63, 0};
		gbl_panel.rowHeights = new int[]{25, 24, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		{
			JLabel label = new JLabel(disciplina);
			label.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.HORIZONTAL;
			gbc_label.anchor = GridBagConstraints.NORTH;
			gbc_label.gridwidth = 4;
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 1;
			gbc_label.gridy = 0;
			panel.add(label, gbc_label);
		}
		{
			JLabel label = new JLabel("Turma: "+codigo);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.SOUTHWEST;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 1;
			panel.add(label, gbc_label);
		}
		{
			JLabel label = new JLabel("Carga Horaria: "+choraria);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.SOUTHWEST;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 2;
			gbc_label.gridy = 1;
			panel.add(label, gbc_label);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBorder(null);
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 1;
			getContentPane().add(panel_1, gbc_panel_1);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{976, 0};
			gbl_panel_1.rowHeights = new int[]{429, 0};
			gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, "", null},
					},
					new String[] {
						"Matr\u00EDcula", "Nome", "Aula 44"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, Boolean.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						false, false, true
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(0).setPreferredWidth(156);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(258);
				table.getColumnModel().getColumn(2).setResizable(false);
				GridBagConstraints gbc_table = new GridBagConstraints();
				gbc_table.fill = GridBagConstraints.BOTH;
				gbc_table.gridx = 0;
				gbc_table.gridy = 0;
				panel_1.add(table, gbc_table);
			}
		}
	}

}
