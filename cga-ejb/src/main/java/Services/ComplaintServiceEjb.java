package Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entitys.Claim;
import Entitys.Complaint;

import Entitys.InsuranceAgent;



/**
 * Session Bean implementation class ComplaintServiceEjb
 */
@Stateless
public class ComplaintServiceEjb implements ComplaintServiceEjbRemote,ComplaintServiceEjbLocal {
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ComplaintServiceEjb() {
        // TODO Auto-generated constructor stub
    }

	
	

	@Override
	public void addComplaint(Complaint c) {
		em.merge(c);
		
	}

	@Override
	public void updateComplaint(Complaint c) {
		em.merge(c);
		
	}

	@Override
	public void DeleteComplaint(Complaint c) {
		em.remove(em.merge(c));
		
	}

	@Override
	public Complaint findComplaintById(int Complaint_id) {
		return em.merge(em.find(Complaint.class, Complaint_id));
	}

	@Override
	public List<Complaint> getAllComplaints() {
		return em.createQuery("select c from Complaint c", Complaint.class).getResultList();
	}
	public List<Claim> getAllClaims(){
		return em.createQuery("select c from Claim c", Claim.class).getResultList();
	}
	@Override
	public void addAgent(InsuranceAgent a) {
		System.out.println(a.getCin());
		System.out.println(a.getFirst_name());
		System.out.println(a.getLast_name());
		

		em.persist(em.merge(a));
		
	}
	

}
