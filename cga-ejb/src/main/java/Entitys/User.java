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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	   
	@Id
	private String Cin;
	private String Last_name;
	private String First_name;
	private Date Birth_date;
	private String Address;
	private String E_mail;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public String getCin() {
		return this.Cin;
	}

	public void setCin(String Cin) {
		this.Cin = Cin;
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
	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}   
	public String getE_mail() {
		return this.E_mail;
	}

	public void setE_mail(String E_mail) {
		this.E_mail = E_mail;
	}
   
}
