package Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entitys.Assure;
import Entitys.Contract;
import Entitys.InsuranceAgent;
import Entitys.InsuranceCompany;
import Entitys.InsuranecPolicy;
import Entitys.Insured;
import Entitys.Post;
import Entitys.User;

/**
 * Session Bean implementation class ContractServiceEjb
 */
@Stateless
public class ContractServiceEjb implements ContractServiceEjbRemote, ContractServiceEjbLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ContractServiceEjb() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addAgent(InsuranceAgent a) {
		System.out.println(a.getCin());
		System.out.println(a.getFirst_name());
		System.out.println(a.getLast_name());

		em.persist(em.merge(a));

	}

	@Override
	public void addContract(Contract c) {
		em.persist(em.merge(c));
		System.out.println("ajouté");

	}

	@Override
	public void updateContract(Contract c) {
		em.merge(c);
		System.out.println("modifié");
	}

	@Override
	public void DeleteContract(Contract c) {
		em.remove(em.merge(c));
		System.out.println("supprimé");

	}

	@Override
	public Contract findContractById(int idContract) {
		return em.merge(em.find(Contract.class, idContract));

	}

	@Override
	public List<Contract> getAllContracts() {
		return em.createQuery("select c from Contract c", Contract.class).getResultList();
	}

	@Override
	public List<Assure> getAllInsured() {
		return em.createQuery("select c from Assure c", Assure.class).getResultList();
	}

	public List<InsuranceCompany> getAllAssurance() {
		return em.createQuery("select c from InsuranceCompany c", InsuranceCompany.class).getResultList();
	}

	public List<InsuranecPolicy> getAllPolice(){
		return em.createQuery("select c from InsuranecPolicy c", InsuranecPolicy.class).getResultList();
	}

	@Override
	public List<Contract> getContracts7() {
		return em.createQuery("select c from Contract c join c.insurancePolicy e where e.id<8", Contract.class).getResultList();
	}

	@Override
	public List<Contract> getContracts8() {
		return em.createQuery("select c from Contract c join c.insurancePolicy e where e.id=8", Contract.class).getResultList();
	}

	@Override
	public List<Contract> getContracts9() {
		return em.createQuery("select c from Contract c join c.insurancePolicy e where e.id=9", Contract.class).getResultList();
	}

	@Override
	public List<Contract> getContracts10() {
		return em.createQuery("select c from Contract c join c.insurancePolicy e where e.id=10", Contract.class).getResultList();
	}

	@Override
	public List<Contract> getContracts11() {
		return em.createQuery("select c from Contract c join c.insurancePolicy e where e.id=11", Contract.class).getResultList();
	}
	
}
