package br.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.com.dados.Aluno;

public class QueryAlunoDB {
	
	private int id;
	private String matricula;
	private String nome;
	private List<Boolean> presenca;
	
	List<Aluno> alunos;
	
	public QueryAlunoDB(int id) {
		// TODO Auto-generated constructor stub
		Connection connection = null;
		Statement stmt = null;
		alunos = new LinkedList<Aluno>();
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:presenca.db");
			connection.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT TURMA_ALUNO.*, ALUNO.* FROM TURMA_ALUNO INNER JOIN ALUNO ON TURMA_ALUNO.FK_ALUNO = ALUNO.IDALUNO WHERE FK_TURMA = "+ id);
			while (rs.next()) {
				// turma
				setId(rs.getInt("IDALUNO"));
				setNome(rs.getString("NOMEALUNO"));
				setMatricula(rs.getString("MATRICULA"));
				Aluno aluno = new Aluno(getId(), getMatricula(), getNome(), getPresenca());
				alunos.add(aluno);
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
	
	public List<Aluno> getAllAlunos() {
		return alunos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Boolean> getPresenca() {
		return presenca;
	}

	public void setPresenca(List<Boolean> presenca) {
		this.presenca = presenca;
	}

}
