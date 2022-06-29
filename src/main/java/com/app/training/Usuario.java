package com.app.training;

public class Usuario {
	
	private String name;
	private String password;
	private Boolean autenticado;
	public Boolean getAutenticado() {
		return autenticado;
	}
	public void setAutenticado(Boolean autenticado) {
		this.autenticado = autenticado;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
