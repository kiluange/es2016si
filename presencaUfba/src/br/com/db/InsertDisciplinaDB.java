package br.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDisciplinaDB {
	
	public static void main(String[] args) {
		new InsertDisciplinaDB();
	}

	public InsertDisciplinaDB() {
		// TODO Auto-generated constructor stub

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:presenca.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO DISCIPLINA (CODIGO,NOME,CARGAHORARIA)" + "VALUES ('MATA64', 'Software avançado III', '62' );";
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
