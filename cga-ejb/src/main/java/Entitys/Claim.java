package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claim
 *
 */
@Entity

public class Claim implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ClaimId;
	private String Picture;
	private String Description;
	private Date IncidentDate;
	private String IncidentPlace;
	@ManyToOne
	private Insured insuredClaim;
	@ManyToOne
	private Expert expertClaim;
	@ManyToOne
	private InsuranceAgent insuranceAgent;
	@ManyToMany(mappedBy="listClaim")
	private List<Vehicule> listVehicule;
	@OneToOne(mappedBy="claim")
	private Complaint complaint;
	
	private static final long serialVersionUID = 1L;

	public Claim() {
		super();
	}   
	public int getClaimId() {
		return this.ClaimId;
	}

	public void setClaimId(int ClaimId) {
		this.ClaimId = ClaimId;
	}   
	public String getPicture() {
		return this.Picture;
	}

	public void setPicture(String Picture) {
		this.Picture = Picture;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}   
	public Date getIncidentDate() {
		return this.IncidentDate;
	}

	public void setIncidentDate(Date IncidentDate) {
		this.IncidentDate = IncidentDate;
	}   
	public String getIncidentPlace() {
		return this.IncidentPlace;
	}

	public void setIncidentPlace(String IncidentPlace) {
		this.IncidentPlace = IncidentPlace;
	}
	public Insured getInsuredClaim() {
		return insuredClaim;
	}
	public void setInsuredClaim(Insured insuredClaim) {
		this.insuredClaim = insuredClaim;
	}
	public Expert getExpertClaim() {
		return expertClaim;
	}
	public void setExpertClaim(Expert expertClaim) {
		this.expertClaim = expertClaim;
	}
	public InsuranceAgent getInsuranceAgent() {
		return insuranceAgent;
	}
	public void setInsuranceAgent(InsuranceAgent insuranceAgent) {
		this.insuranceAgent = insuranceAgent;
	}
	public List<Vehicule> getListVehicule() {
		return listVehicule;
	}
	public void setListVehicule(List<Vehicule> listVehicule) {
		this.listVehicule = listVehicule;
	}
   
}
