package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public Connection getConnection() {
	    // strings de conexão
	    String databaseURL = "jdbc:postgresql://localhost/clinica2";
	    String usuario = "postgres";
	    String senha = "admin";
	    String driverName = "org.postgresql.Driver";
	    
	    try {
	      Class.forName(driverName).newInstance();
	      Connection conn = DriverManager.getConnection(databaseURL, usuario, senha);
	      return conn;
	    }
	    catch (SQLException ex) {
	      System.out.println("SQLException: " + ex.getMessage());
	      System.out.println("SQLState: " + ex.getSQLState());
	      System.out.println("VendorError: " + ex.getErrorCode());
		  return null;
	    }
	    catch (Exception e) {
	      System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
		  return null;
	    }  
	  }
}
