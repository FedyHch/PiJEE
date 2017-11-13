package Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entitys.Insured;
import Entitys.Tow;




/**
 * Session Bean implementation class EventServiceEjb
 */
@Stateless
public class TowServiceEjb implements TowServiceEjbRemote,TowServiceEjbLocal {
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TowServiceEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addTow(Tow t) {
		em.merge(t);
		
	}

	@Override
	public void updateTow(Tow t) {
		em.merge(t);
		
	}

	@Override
	public void DeleteTow(Tow t) {
		em.remove(em.merge(t));
		
	}

	@Override
	public Tow findTowById(int idTow) {
		return em.merge(em.find(Tow.class, idTow));

	}

	@Override
	public List<Tow> getAllTow() {
		return em.createQuery("select t from Tow t", Tow.class).getResultList();

	}

	@Override
	public List<Tow> notReservedTow() {
		return em.createQuery("select t from Tow t where status=1 and (insured is NULL or insured = '' )",Tow.class).getResultList();

	}

	@Override
	public List<Tow> findTowByInsured(Insured i) {
		return em.createQuery("select t from Tow t where status=1 and insured_Cin=?1 ",Tow.class).setParameter(1,i.getCin()).getResultList();

	}

	@Override
	public void updateTowState(Tow t) {
		//em.createQuery("update Tow set state=1 where tow_id=?1").setParameter(1, t.getTow_id()).executeUpdate();	
	Tow tow = em.find(Tow.class, t.getTow_id());
	tow.setStatus(false);
		em.persist(tow);	
	}
	@Override
	public void updateTowStatusRefuse(Tow t) {
		//em.createQuery("update Tow set state=1 where tow_id=?1").setParameter(1, t.getTow_id()).executeUpdate();	
	Tow tow = em.find(Tow.class, t.getTow_id());
	tow.setStatus(true);
	tow.setInsured(null);
		em.persist(tow);	
	}
	
	@Override
	public boolean updateTowInsured(Tow t) {
	Tow tow = em.find(Tow.class, t.getTow_id());

	if (tow.getStatus()){
		Insured insured = em.find(Insured.class, t.getInsured().getCin());
		tow.setInsured(insured);
		em.persist(tow);
		return true;
	}
	return false;
	}

	@Override
	public List<Tow> findTowByInsuredAccepted(Insured i) {
		return em.createQuery("select t from Tow t where status=0 and insured_Cin=?1 ",Tow.class).setParameter(1,i.getCin()).getResultList();

	}
	

}
