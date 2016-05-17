package br.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Time;

public class InsertTurmaDb {
	
	public static void main(String[] args) {
		new InsertTurmaDb();
	}
	
	public InsertTurmaDb() {
		// TODO Auto-generated constructor stub
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:presenca.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO TURMA (FK_DISCIPLINA,FK_PROFESSOR,CODIGO,HORA,PAVILHAO,SALA)" + "VALUES ('1','1','T0003','"+new Time(0)+"','PAF1','208')";
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
