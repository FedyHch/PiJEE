package Services;

import java.util.List;

import javax.ejb.Local;

import Entitys.Assure;
import Entitys.Contract;
import Entitys.InsuranceAgent;
import Entitys.InsuranceCompany;
import Entitys.InsuranecPolicy;

@Local
public interface ContractServiceEjbLocal {

	public void addContract(Contract c);

	public void updateContract(Contract c);

	public void DeleteContract(Contract c);

	public Contract findContractById(int idContract);

	public List<Contract> getAllContracts();
	public List<Contract> getContracts7();
	public List<Contract> getContracts8();
	public List<Contract> getContracts9();
	public List<Contract> getContracts10();
	public List<Contract> getContracts11();
	public List<InsuranceCompany> getAllAssurance();

	public void addAgent(InsuranceAgent a);

	public List<Assure> getAllInsured();
	public List<InsuranecPolicy> getAllPolice();

}
