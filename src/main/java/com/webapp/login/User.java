package com.webapp.login;

public class User {
	public String fname,lname,mail,password;

	User(String a, String b, String c, String d){
		fname=a;
		lname=b;
		mail=c;
		password=d;
	}
	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}
	
}
