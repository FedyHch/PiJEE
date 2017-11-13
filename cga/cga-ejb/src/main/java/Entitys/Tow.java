package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tow
 *
 */
@Entity

public class Tow implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int TowId;
	private String state;
	private String zone;
	private Date date_tow;
	@ManyToOne
	private InsuranceAgent insuranceAgent;
	@ManyToOne
	private Insured insured; 
	
	private static final long serialVersionUID = 1L;

	public Tow() {
		super();
	}   
	public int getTowId() {
		return this.TowId;
	}

	public void setTowId(int TowId) {
		this.TowId = TowId;
	}   
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}   
	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	public InsuranceAgent getInsuranceAgent() {
		return insuranceAgent;
	}
	public void setInsuranceAgent(InsuranceAgent insuranceAgent) {
		this.insuranceAgent = insuranceAgent;
	}
	public Date getDate_tow() {
		return date_tow;
	}
	public void setDate_tow(Date date_tow) {
		this.date_tow = date_tow;
	}
   
}
