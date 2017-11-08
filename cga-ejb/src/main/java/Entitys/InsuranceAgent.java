package Entitys;

import Entitys.User;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: InsuranceAgent
 *
 */
@Entity

public class InsuranceAgent extends User implements Serializable {

	
	private String status;
	private float salary;
	
	@OneToMany(mappedBy="agentEvent", cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
	private List<Event> listEvent;
	
	@OneToMany(mappedBy="insuraceAgentContract")
	private List<Contract> listContract;
	
	@OneToMany(mappedBy="insuranceAgent")
	private List<Claim> listClaim;
	@OneToMany(mappedBy="insuranceAgent")
	private List<Tow> listTow;
	
	private static final long serialVersionUID = 1L;

	public InsuranceAgent() {
		super();
	}   
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}   
	public float getSalary() {
		return this.salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	public List<Event> getListEvent() {
		return listEvent;
	}
	public void setListEvent(List<Event> listEvent) {
		this.listEvent = listEvent;
	}
	public List<Contract> getListContract() {
		return listContract;
	}
	public void setListContract(List<Contract> listContract) {
		this.listContract = listContract;
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
