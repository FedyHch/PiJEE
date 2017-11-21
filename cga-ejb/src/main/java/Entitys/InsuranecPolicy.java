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
	private int id;
	private String InsuranceClass;
	@OneToOne(mappedBy="insurancePolicy")
	private Contract contract;
	
	private static final long serialVersionUID = 1L;

	public InsuranecPolicy() {
		super();
	}   
   
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsuranceClass() {
		return this.InsuranceClass;
	}

	public void setInsuranceClass(String InsuranceClass) {
		this.InsuranceClass = InsuranceClass;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
   
}
