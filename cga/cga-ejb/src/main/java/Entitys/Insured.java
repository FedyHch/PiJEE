package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Insured
 *
 */
@Entity

public class Insured  implements Serializable {

	
	@Id
	

	private String Cin;
	
	private String Last_name;
	private String First_name;
	private Date Birth_date;
	private String Address;
	private String E_mail;

	
	private String driving_licence_id;
	
	@ManyToMany
	private List<Event> listEvent;
	
	@OneToMany(mappedBy="insured")
	private List<Subject> listSubject;
	@OneToMany(mappedBy="insuredComplaint")
	private List<Complaint> listComplaint;

	
	@OneToMany(mappedBy="insuredClaim")
	private List<Claim> listClaim;
	
	@OneToMany(mappedBy="insured")
	private List<Tow> listTow;
	
	private static final long serialVersionUID = 1L;

	
	
	public String getCin() {
		return Cin;
	}
	public void setCin(String cin) {
		Cin = cin;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public Date getBirth_date() {
		return Birth_date;
	}
	public void setBirth_date(Date birth_date) {
		Birth_date = birth_date;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getE_mail() {
		return E_mail;
	}
	public void setE_mail(String e_mail) {
		E_mail = e_mail;
	}
	public Insured() {
		super();
	}   
	public String getDriving_licence_id() {
		return this.driving_licence_id;
	}

	public void setDriving_licence_id(String driving_licence_id) {
		this.driving_licence_id = driving_licence_id;
	}
	public List<Event> getListEvent() {
		return listEvent;
	}
	public void setListEvent(List<Event> listEvent) {
		this.listEvent = listEvent;
	}
	public List<Subject> getListSubject() {
		return listSubject;
	}
	public void setListSubject(List<Subject> listSubject) {
		this.listSubject = listSubject;
	}
	public List<Complaint> getListComplaint() {
		return listComplaint;
	}
	public void setListComplaint(List<Complaint> listComplaint) {
		this.listComplaint = listComplaint;
	}

	public List<Claim> getListClaim() {
		return listClaim;
	}
	public void setListClaim(List<Claim> listClaim) {
		this.listClaim = listClaim;
	}
	public List<Tow> getListTow() {
		return listTow;
	}
	public void setListTow(List<Tow> listTow) {
		this.listTow = listTow;
	}
   
}
