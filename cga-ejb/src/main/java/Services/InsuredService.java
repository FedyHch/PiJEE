package Services;

import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entitys.Insured;

/**
 * Session Bean implementation class InsuredService
 */
@Stateless

public class InsuredService implements InsuredServiceLocal,InsuredServiceRemote {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public InsuredService() {
        // TODO Auto-generated constructor stub
    }
    



	public void saveOrUpdate(Insured insured) {
		em.merge(insured);
	}
	
	public Insured findInsuredById(int cin) {
		return em.find(Insured.class, cin);
	}

	public void removeInsured(Insured insured) {
		em.remove(em.merge(insured));
	}

	public List<Insured> findAllInsured() {
		return em.createQuery("select c from Insured c", Insured.class)
				.getResultList();
	}

	public Insured findInsuredByName(String name) {
		Insured found = null;
		TypedQuery<Insured> query = em.createQuery(
				"select c from Insured c where c.driving_licence_id=:x", Insured.class);
		query.setParameter("x", name);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
					"no insured with name=" + name);
		}
		return found;
	}
}
