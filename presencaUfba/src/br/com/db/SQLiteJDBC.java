package br.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteJDBC {

	private static Connection connection;

	public static void main(String[] args) {

		setConnection(null);
		try {
			Class.forName("org.sqlite.JDBC");
			setConnection(DriverManager.getConnection("jdbc:sqlite:presenca.db"));
			criaTabelaProfessor();
			criaTabelaAluno();
			criaTabelaTurma();
			criaTabelaDisciplina();
			criaTabelaTurma_Aluno();
			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		SQLiteJDBC.connection = connection;
	}

	private static void criaTabelaProfessor() {
		try {

			Statement stmt = connection.createStatement();
			String sql = "CREATE TABLE USUARIO "
					+ "(IDUSUARIO 			INTEGER		PRIMARY KEY     AUTOINCREMENT	NOT NULL,"
					+ " NOMEUSUARIO           TEXT    	NOT NULL, " + " LOGIN          CHAR(30)    NOT NULL, "
					+ " SENHA        	CHAR(50) 	NOT NULL)";
			stmt.executeUpdate(sql);
			stmt.close();
			// connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Tabela USUARIO criada com sucesso");

	}

	private static void criaTabelaAluno() {
		try {

			Statement stmt = connection.createStatement();
			String sql = "CREATE TABLE ALUNO " + "(IDALUNO 			INTEGER		PRIMARY KEY    AUTOINCREMENT 	NOT NULL,"
					+ " NOMEALUNO           TEXT    	NOT NULL, " + " MATRICULA    	CHAR(9)    	NOT NULL)";
			stmt.executeUpdate(sql);
			stmt.close();
			// connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Tabela ALUNO criada com sucesso");

	}

	private static void criaTabelaTurma() {
		try {

			Statement stmt = connection.createStatement();
			String sql = "CREATE TABLE TURMA " + "(IDTURMA 			INTEGER		PRIMARY KEY     AUTOINCREMENT	NOT NULL,"
					+ " FK_DISCIPLINA 	INT 		NOT NULL," + " CODIGO         CHAR(8)    	NOT NULL,"
					+ " FK_PROFESSOR	INT			NOT NULL," + " HORA			TIME		NOT NULL,"
					+ " PAVILHAO 		CHAR(10)	NOT NULL," + " SALA 			CHAR(10),"
					+ " CONSTRAINT turma_professor FOREIGN KEY(FK_PROFESSOR) REFERENCES  USUARIO(ID),"
					+ " CONSTRAINT turma_disciplina FOREIGN KEY(FK_DISCIPLINA) REFERENCES  DISCIPLINA(ID))";
			stmt.executeUpdate(sql);
			stmt.close();
			// connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Tabela TURMA criada com sucesso");

	}

	private static void criaTabelaDisciplina() {
		try {

			Statement stmt = connection.createStatement();
			String sql = "CREATE TABLE DISCIPLINA "
					+ "(IDDISCIPLINA 			INTEGER 	PRIMARY KEY    AUTOINCREMENT 	NOT NULL,"
					+ " NOMEDISCIPLINA           TEXT    	NOT NULL, " + " CODIGO    		CHAR(8)    	NOT NULL,"
					+ " CARGAHORARIA	INT			NOT NULL)";
			stmt.executeUpdate(sql);
			stmt.close();
			// connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Tabela DISCIPLINA criada com sucesso");

	}

	private static void criaTabelaTurma_Aluno() {
		try {

			Statement stmt = connection.createStatement();
			String sql = "CREATE TABLE TURMA_ALUNO " + "("
					+ "IDTALUNO			INTEGER 	PRIMARY KEY    AUTOINCREMENT 	NOT NULL,"
					+ "FK_TURMA	INTEGER		NOT NULL,"
					+ " FK_ALUNO	INTEGER		NOT NULL," + " CONSTRAINT tAluno_turma FOREIGN KEY (FK_TURMA) REFERENCES TURMA(ID),"
					+ " CONSTRAINT tAluno_aluno FOREIGN KEY (FK_ALUNO) REFERENCES ALUNO(ID))";
			stmt.executeUpdate(sql);
			stmt.close();
			// connection.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Tabela TURMA_ALUNO criada com sucesso");

	}

}
