package Entitys;

import Entitys.User;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Insured
 *
 */
@Entity

public class Insured extends User implements Serializable {

	
	private String driving_licence_id;
	
	@ManyToMany
	private List<Event> listEvent;
	
	@OneToMany(mappedBy="insured")
	private List<Subject> listSubject;
	@OneToMany(mappedBy="insuredComplaint")
	private List<Complaint> listComplaint;
	@OneToMany(mappedBy="insuredContract")
	private List<Contract> contractInsured;
	
	@OneToMany(mappedBy="insuredClaim")
	private List<Claim> listClaim;
	
	@OneToMany(mappedBy="insured")
	private List<Tow> listTow;
	
	private static final long serialVersionUID = 1L;

	
	
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
	public List<Contract> getContractInsured() {
		return contractInsured;
	}
	public void setContractInsured(List<Contract> contractInsured) {
		this.contractInsured = contractInsured;
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
