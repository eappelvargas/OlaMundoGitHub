package br.org.edu.model;

import java.io.Serializable;

public class Contato  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7011032902822689661L;

	private String login;
	private String senha;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contato [login=" + login + ", senha=" + senha + "]";
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
