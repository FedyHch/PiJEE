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
	private int tow_id;
	private boolean status = true;
	private String zone;
	private Date date_tow;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private InsuranceAgent insuranceAgent;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Insured insured;
	
//	@OneToMany(mappedBy="tow")
//	private List<Insured> ListInsured;


	private static final long serialVersionUID = 1L;

	public Insured getInsured() {
		return insured;
	}
	public void setInsured(Insured insured) {
		this.insured = insured;
	}
	public Tow() {
		super();
	}   
	public int getTow_id() {
		return this.tow_id;
	}

	public void setTow_id(int tow_id) {
		this.tow_id = tow_id;
	}   
	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}   
	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}   
	public Date getDate_tow() {
		return this.date_tow;
	}

	public void setDate_tow(Date date_tow) {
		this.date_tow = date_tow;
	}
	

	public InsuranceAgent getInsuranceAgent() {
		return insuranceAgent;
	}
	public void setInsuranceAgent(InsuranceAgent insuranceAgent) {
		this.insuranceAgent = insuranceAgent;
	}
	@Override
	public String toString() {
		return "Tow [tow_id=" + tow_id + ", status=" + status + ", zone=" + zone + ", date_tow=" + date_tow + ", insuranceAgent="
				+ insuranceAgent + ", insured=" + insured + "]";
	}
	
	
   
}
