package br.org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import br.org.edu.managedbean.ExcessoesMSG;

public class ConnDB {
	
	public static Connection abreConexao() throws ExcessoesMSG {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/agenda", "postgres","postgres");
		} catch (Exception e) {
			throw new ExcessoesMSG(e.getMessage()); 
		}
	}
	
	public static void fechaConexao(Connection conn, Statement stmt) throws ExcessoesMSG {
		fecha(conn, stmt, null);
	}
	
	public static void fechaConexao(Connection conn) throws ExcessoesMSG {
		fecha(conn, null, null);
	}
	
	public static void fechaConexao(Connection conn, Statement stmt, ResultSet rs) throws ExcessoesMSG {
		fecha(conn, stmt, rs);
	}
	
	private static void fecha(Connection conn, Statement stmt, ResultSet rs) throws ExcessoesMSG {  
        if (rs != null) {  
            try {  
                rs.close();  
            } catch (Exception e) {  
                throw new ExcessoesMSG(e.getMessage());  
            }  
        }  
        if (stmt != null) {  
            try {  
                stmt.close();  
            } catch (Exception e) {  
            	throw new ExcessoesMSG(e.getMessage()); 
            }  
        }  
        if (conn != null) {  
            try {  
                conn.close();  
            } catch (Exception e) {  
            	throw new ExcessoesMSG(e.getMessage()); 
            }  
        }  
}  
}
