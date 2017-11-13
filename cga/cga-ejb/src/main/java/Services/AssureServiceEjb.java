package Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entitys.Assure;
import Entitys.Contract;
import Entitys.InsuranceAgent;
import Entitys.Insured;
import Entitys.Post;
import Entitys.User;


/**
 * Session Bean implementation class ContractServiceEjb
 */
@Stateless
public class AssureServiceEjb implements AssureServiceEjbRemote,AssureServiceEjbLocal {
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AssureServiceEjb() {
        // TODO Auto-generated constructor stub
    }





	@Override
	public void addAssure(Assure c) {
		em.persist(em.merge(c));
		System.out.println("ajouté");
		
	}

	@Override
	public void updateAssure(Assure c) {
		em.merge(c);
		System.out.println("modifié");
	}

	@Override
	public void DeleteAssure(Assure c) {
		em.remove(em.merge(c));
		System.out.println("supprimé");
		
	}

	@Override
	public Assure findAssureById(int idAssure) {
		return em.merge(em.find(Assure.class, idAssure));
		
	}

	@Override
	public List<Contract> getAllContracts() {
		return em.createQuery("select c from Contract c", Contract.class).getResultList();
	}
	
	@Override
	public List<Assure> getAllAssure() {
		return em.createQuery("select c from Assure c", Assure.class).getResultList();
	}
	

}
