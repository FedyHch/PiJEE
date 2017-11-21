package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	private String Cin;
	public String getCin() {
		return Cin;
	}



	public void setCin(String cin) {
		Cin = cin;
	}
	private String Last_name;
	private String First_name;
	private String login;
	private String password;
	private Date Birth_date;
	private String Phone_number;
	private String E_mail;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	
	

	public String getLast_name() {
		return this.Last_name;
	}

	public void setLast_name(String Last_name) {
		this.Last_name = Last_name;
	}   
	public String getFirst_name() {
		return this.First_name;
	}

	public void setFirst_name(String First_name) {
		this.First_name = First_name;
	}   
	public Date getBirth_date() {
		return this.Birth_date;
	}

	public void setBirth_date(Date Birth_date) {
		this.Birth_date = Birth_date;
	}   
	
	public String getE_mail() {
		return this.E_mail;
	}

	public void setE_mail(String E_mail) {
		this.E_mail = E_mail;
	}
	public String getPhone_number() {
		return Phone_number;
	}
	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
   
}
