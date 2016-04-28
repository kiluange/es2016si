package br.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.com.dados.Turma;

public class QueryTurmaDB {

	private int id;
	private int fkDisciplina;
	private String codigo;
	private String hora;
	private String pavilhao;
	private String sala;
	
	List<Turma> turmas;
	
	public static void main(String[] args) {
		new QueryTurmaDB(1);
	}
	
	public QueryTurmaDB(int id) {
		// TODO Auto-generated constructor stub
		
		Connection connection = null;
		Statement stmt = null;
		turmas = new LinkedList<Turma>();
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:presenca.db");
			connection.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TURMA WHERE FK_DISCIPLINA = " + id);
			while (rs.next()) {				
				setId(rs.getInt("id"));
				setFkDisciplina(rs.getInt("FK_DISCIPLINA"));
				setCodigo(rs.getString("codigo"));
				setHora(rs.getString("hora"));
				setPavilhao(rs.getString("pavilhao"));
				setSala(rs.getString("sala"));
				//Adiciona resultado numa lista
				Turma turma = new Turma(getId(), getFkDisciplina(), getCodigo(), getHora(), getPavilhao(), getSala());
				turmas.add(turma);
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
	
	public List<Turma> getAllTurmas() {
		return turmas;		
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public int getFkDisciplina() {
		return fkDisciplina;
	}

	private void setFkDisciplina(int fkDisciplina) {
		this.fkDisciplina = fkDisciplina;
	}

	public String getCodigo() {
		return codigo;
	}

	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getPavilhao() {
		return pavilhao;
	}

	public void setPavilhao(String pavilhao) {
		this.pavilhao = pavilhao;
	}

}