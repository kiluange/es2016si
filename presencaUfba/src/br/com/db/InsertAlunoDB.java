package br.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertAlunoDB {
	
	public static void main(String[] args) {
		new InsertAlunoDB();
	}
	
	public InsertAlunoDB() {
		// TODO Auto-generated constructor stub
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:presenca.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO ALUNO (NOMEALUNO, MATRICULA)" + "VALUES ('João das Neves','432156789')";
			if (sql != null) {
				String sql2 = "INSERT INTO TURMA_ALUNO (FK_TURMA, FK_ALUNO)" + "VALUES ('1','2')";
				stmt.executeUpdate(sql2);				
			}
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}

}
