package Services;

import java.util.List;

import javax.ejb.Local;

import Entitys.Insured;

@Local
public interface InsuredServiceLocal {
	void saveOrUpdate(Insured insured);
	
	Insured findInsuredById(int cin);
	void removeInsured(Insured insured);
	List<Insured> findAllInsured();
	Insured findInsuredByName(String name);






}
