package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehicule
 *
 */
@Entity

public class Vehicule implements Serializable {

	@Id
	private String chasisNumber;
	private String registrationNumber;
	private int power;
	private String model;
	private String Marque;
	
	@ManyToOne
	private Contract contractVehicule;
	@ManyToMany
	private List<Claim> listClaim;
	
	private static final long serialVersionUID = 1L;

	public Vehicule() {
		super();
	}   
	public String getChasisNumber() {
		return this.chasisNumber;
	}

	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}   
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}   
	public int getPower() {
		return this.power;
	}

	public void setPower(int power) {
		this.power = power;
	}   
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}   
	public String getMarque() {
		return this.Marque;
	}

	public void setMarque(String Marque) {
		this.Marque = Marque;
	}
	public Contract getContractVehicule() {
		return contractVehicule;
	}
	public void setContractVehicule(Contract contractVehicule) {
		this.contractVehicule = contractVehicule;
	}
	public List<Claim> getListClaim() {
		return listClaim;
	}
	public void setListClaim(List<Claim> listClaim) {
		this.listClaim = listClaim;
	}
   
}
