package Entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: InsuranecPolicy
 *
 */
@Entity

public class InsuranecPolicy implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int PolicyNumber;
	private int InsuranceClass;
	@OneToOne(mappedBy="insurancePolicy")
	private Contract contract;
	
	private static final long serialVersionUID = 1L;

	public InsuranecPolicy() {
		super();
	}   
	public int getPolicyNumber() {
		return this.PolicyNumber;
	}

	public void setPolicyNumber(int PolicyNumber) {
		this.PolicyNumber = PolicyNumber;
	}   
	public int getInsuranceClass() {
		return this.InsuranceClass;
	}

	public void setInsuranceClass(int InsuranceClass) {
		this.InsuranceClass = InsuranceClass;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
   
}
