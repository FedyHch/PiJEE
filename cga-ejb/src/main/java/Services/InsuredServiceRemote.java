package Services;

import java.util.List;

import javax.ejb.Remote;

import Entitys.Insured;

@ Remote
public interface InsuredServiceRemote {
	
	Insured findInsuredById(int cin);
	void removeInsured(Insured insured);
	List<Insured> findAllInsured();
	Insured findInsuredByName(String name);

}
