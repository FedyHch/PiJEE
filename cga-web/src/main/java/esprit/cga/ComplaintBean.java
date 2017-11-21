package esprit.cga;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entitys.Claim;
import Entitys.Complaint;

import Entitys.InsuranceAgent;
import Services.ComplaintServiceEjbLocal;

@ManagedBean
@SessionScoped
public class ComplaintBean {
	@EJB
	private ComplaintServiceEjbLocal co;
	
	
	private Complaint comp = new Complaint();
	private InsuranceAgent a = new InsuranceAgent();
	private Integer SelectedClaimId;
	

	public String init(){
		
		
		co.addAgent(a);
		return "AddAgent?faces-redirect=true";
	}
	public String UpdateCompalaint(){
		
		co.updateComplaint(comp);
		return "ListComplaint?faces-redirect=true";
	}
public String UpdateCompalaint1(){
		
		co.updateComplaint(comp);
		return "ListComplaint_back?faces-redirect=true";
	}
	
	public String addComplaint(){
		Claim selectedClaim = new Claim();
		selectedClaim.setClaimId(SelectedClaimId);
		comp.setClaimComplaint(selectedClaim);
		comp.setResponse("no response");
		co.addComplaint(comp);
		return "ListComplaint?faces-redirect=true";
	}
public Integer getSelectedClaimId() {
		return SelectedClaimId;
	}
	public void setSelectedClaimId(Integer selectedClaimId) {
		SelectedClaimId = selectedClaimId;
	}
public String updateComplaintInit(Complaint c){
		
		this.comp = c;
		
		return "UpdateComplaint?faces-redirect=true";
		
		
	}
public String updateComplaintInit_back(Complaint c){
	
	this.comp = c;
	
	return "UpdateComplaint_back?faces-redirect=true";
	
	
}
	
	
	
	public String deleteComplaint(Complaint c){
		
		co.DeleteComplaint(c);
		System.out.println(c.getComplaint_id());
		return "ListComplaint?faces-redirect=true";
	}
	public String newComplaint(){
		comp = new Complaint();
		return "AddComplaint?faces-redirect=true";
	}
	
	public List<Complaint> getAllCo(){
		
		return co.getAllComplaints();
	}

	public Complaint getCom() {
		return comp;
	}

	public void setCom(Complaint comp) {
		this.comp = comp;
	}
	public InsuranceAgent getA() {
		return a;
	}

	public void setA(InsuranceAgent a) {
		this.a = a;
	}

	public List<Claim> getAllClaims() {

		return co.getAllClaims();
	}
}
