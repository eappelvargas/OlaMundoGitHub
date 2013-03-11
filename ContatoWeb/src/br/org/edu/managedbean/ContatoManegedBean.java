package br.org.edu.managedbean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.org.edu.model.Contato;
import br.org.util.ConnDB;

@ManagedBean(name="contatoBean")
@SessionScoped

public class ContatoManegedBean implements Serializable{

	private static final long serialVersionUID = 5155150338422516814L;
	private Connection conn;
	private Contato contato;
	private boolean logado;

	public ContatoManegedBean(){
		
		contato = new Contato();
	}
	
	public String efetuarLogin() throws ExcessoesMSG{
		System.out.println("Contato: "+contato);
	
		try{
			doLogin();
		}
		 catch(SQLException sqle){
			 return "ErroInterno";
		 }
				
		if(logado)
			return "sucesso";
		else
			return "falhou";	
	}
	
	public void doLogin() throws SQLException, ExcessoesMSG {
		System.out.println("doLogin...");
	try {
			this.conn = ConnDB.abreConexao();
	} catch (Exception e) {
			throw new ExcessoesMSG("Erro: "+e.getMessage());
	}
	  
	  try{
		PreparedStatement paswdQuery = conn.prepareStatement("SELECT passwd FROM credenciais WHERE username=?");
		paswdQuery.setString(1, contato.getLogin());
		
		System.out.println(paswdQuery);
		
		ResultSet rs = paswdQuery.executeQuery();
		if(!rs.next()) return;
		String armazenaSenha = rs.getString("passwd");
		logado = contato.getSenha().equals(armazenaSenha.trim()); 
		if(!logado) return;
	  } finally{
		  conn.close();
	  }
	}
	
	public void incluirContato(){
		System.out.println("Contato "+getContato());
	}
	
	public Contato getContato(){
		return contato;
	}
	
	public void setContato(Contato contato)	{
		this.contato = contato;
	}
	
	public String logout(){
		logado = false;
		return "login";
	}
	
}
