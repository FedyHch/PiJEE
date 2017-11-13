package Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entitys.Event;
import Entitys.InsuranceAgent;
import Entitys.Insured;


/**
 * Session Bean implementation class EventServiceEjb
 */
@Stateless
public class EventServiceEjb implements EventServiceEjbRemote,EventServiceEjbLocal {
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public EventServiceEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addEvent(Event e) {
		em.persist(em.merge(e));
		
	}

	@Override
	public void updateEvent(Event e) {
		em.merge(e);
		
	}

	@Override
	public void DeleteEvent(Event e) {
		em.remove(em.merge(e));
		
	}

	@Override
	public Event findEventById(int idEvent) {
		
		return em.merge(em.find(Event.class, idEvent));
	}

	@Override
	public List<Event> getAllEvents() {
		
		return em.createQuery("select e from Event e", Event.class).getResultList();
	}

	@Override
	public List<Insured> getAllParticipants(Event e) {
		
		return em.createQuery("select i from Insured i join i.listEvent e where e.EventId=?1",Insured.class).setParameter(1,e.getEventId()).getResultList();
	}

	@Override
	public void addAgent(InsuranceAgent a) {
		System.out.println(a.getCin());
		System.out.println(a.getFirst_name());
		System.out.println(a.getLast_name());
		

		em.persist(em.merge(a));
		
	}

	@Override
	public void addInsured(Insured i) {
		em.persist(em.merge(i));
		
	}

	@Override
	public List<Event> findEventByTitle(String title) {
		
		return em.createQuery("select e from Event e where e.EventTitle like ?1",Event.class).setParameter(1,"%"+title+"%").getResultList();
	}
	

}
