package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: InsuranceCompany
 *
 */
@Entity

public class InsuranceCompany implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CompId;
	private String CompName;
	private String Address;
	private String Fax;
	@OneToMany(mappedBy="insuranceCompany")
	private List<Contract> listContract;
	
	private static final long serialVersionUID = 1L;

	public InsuranceCompany() {
		super();
	}   
	public int getCompId() {
		return this.CompId;
	}

	public void setCompId(int CompId) {
		this.CompId = CompId;
	}   
	public String getCompName() {
		return this.CompName;
	}

	public void setCompName(String CompName) {
		this.CompName = CompName;
	}   
	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}   
	public String getFax() {
		return this.Fax;
	}

	public void setFax(String Fax) {
		this.Fax = Fax;
	}
	public List<Contract> getListContract() {
		return listContract;
	}
	public void setListContract(List<Contract> listContract) {
		this.listContract = listContract;
	}
   
}
