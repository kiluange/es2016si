package br.com.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.dados.Professor;

public class QueryUsuarioDB{
	
	
	private int id;
	private String login;
	private String senha;
	private String name;
	
	private Professor professor;

	public QueryUsuarioDB(String usuario) {
		// TODO Auto-generated constructor stub
		Connection connection  = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      connection = DriverManager.getConnection("jdbc:sqlite:presenca.db");
	      connection.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = connection.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIO WHERE LOGIN = '"+ usuario +"'");
	      while ( rs.next() ) {
	         setId(rs.getInt("id"));
	         setName(rs.getString("nome"));
	         setLogin(rs.getString("login"));
	         setSenha(rs.getString("senha"));
	         setProfessor(new Professor(getId(), getName(), getLogin(), getSenha()));
	      }
	      rs.close();
	      stmt.close();
	      connection.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	

}
