package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Contract
 *
 */
@Entity

public class Contract implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ContractId;
	private String Type;
	private Date StartDate;
	private Date EndDate;
	
	@ManyToOne
	private Insured insuredContract;
	
	@ManyToOne
	private InsuranceCompany insuranceCompany;
	
	@OneToOne
	private InsuranecPolicy insurancePolicy;
	
	@OneToMany(mappedBy="contractVehicule")
	private List<Vehicule> listVehicule;
	
	@ManyToOne
	private InsuranceAgent insuraceAgentContract;
	
	private static final long serialVersionUID = 1L;
	
	
	
	public Insured getInsuredContract() {
		return insuredContract;
	}
	public void setInsuredContract(Insured insuredContract) {
		this.insuredContract = insuredContract;
	}

	

	public Contract() {
		super();
	}   
	public int getContractId() {
		return this.ContractId;
	}

	public void setContractId(int ContractId) {
		this.ContractId = ContractId;
	}   
	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}   
	public Date getStartDate() {
		return this.StartDate;
	}

	public void setStartDate(Date StartDate) {
		this.StartDate = StartDate;
	}   
	public Date getEndDate() {
		return this.EndDate;
	}

	public void setEndDate(Date EndDate) {
		this.EndDate = EndDate;
	}
	public InsuranceCompany getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public InsuranecPolicy getInsurancePolicy() {
		return insurancePolicy;
	}
	public void setInsurancePolicy(InsuranecPolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}
	public InsuranceAgent getInsuraceAgentContract() {
		return insuraceAgentContract;
	}
	public void setInsuraceAgentContract(InsuranceAgent insuraceAgentContract) {
		this.insuraceAgentContract = insuraceAgentContract;
	}
   
}
