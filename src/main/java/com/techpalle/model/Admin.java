package com.techpalle.model;

public class Admin 
{
	private int ano;
	private String name;
	private String email;
	private String pw;
	
	
	
	public Admin(String name,String email, String pw) {
		super();
		this.name = name;
		this.email = email;
		this.pw = pw;
	}
	public Admin() {
		super();
	}
	public Admin(int ano, String name,String email, String pw) {
		super();
		this.ano = ano;
		this.name = name;
		this.email = email;
		this.pw = pw;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}