package br.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.com.dados.Disciplina;

public class QueryDisciplinaDB {

	private int id;
	private String nome;
	private String cod;
	private int cargaHoraria;

	List<Disciplina> disciplinas;

	public static void main(String[] args) {
		new QueryDisciplinaDB("so");
	}

	public QueryDisciplinaDB(String pesquisa) {
		// TODO Auto-generated constructor stub

		Connection connection = null;
		Statement stmt = null;
		disciplinas = new LinkedList<Disciplina>();
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:presenca.db");
			connection.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DISCIPLINA WHERE CODIGO LIKE '%" + pesquisa + "%' OR NOMEDISCIPLINA LIKE '%" + pesquisa + "%'");
			while (rs.next()) {				
				setId(rs.getInt("iddisciplina"));
				setCod(rs.getString("codigo"));
				setNome(rs.getString("nomedisciplina"));
				setCargaHoraria(rs.getInt("cargahoraria"));
				//Adiciona resultado numa lista
				Disciplina disciplina = new Disciplina(getId(), getCod(), getNome(), getCargaHoraria());
				disciplinas.add(disciplina);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");

	}
	
	public List<Disciplina> getAllDisciplinas() {
		return disciplinas;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

}
