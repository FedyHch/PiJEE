package esprit.cga;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entitys.InsuranceAgent;
import Entitys.Tow;
import Services.TowServiceEjbLocal;

@ManagedBean
@SessionScoped
public class TowBean {
	@EJB
	private TowServiceEjbLocal towServiceLocal;
	
	private Tow tow = new Tow();
	private InsuranceAgent insuranceAgent = new InsuranceAgent();

	
	public String addTow(){
		InsuranceAgent insuranceAgent = new InsuranceAgent();
		insuranceAgent.setCin("1234485");
		tow.setInsuranceAgent(insuranceAgent);
		towServiceLocal.addTow(tow);
		return "ListTow?faces-redirect=true";
	}
	
	public String UpdateTow(){
		
		towServiceLocal.updateTow(tow);
		return "ListTow?faces-redirect=true";
	}

	public String updateTowInit(Tow t){
		this.tow = t;
		return "UpdateTow?faces-redirect=true";	
	}
	
	public String acceptTow(Tow t){
		this.tow=t;
		towServiceLocal.updateTowState(tow);
		return "ListTowRequest?faces-redirect=true";
	}
	public String refuseTow(Tow t){
		this.tow=t;
		towServiceLocal.updateTowStatusRefuse(t);
		return "ListTowRequest?faces-redirect=true";
	}
	
	public String deleteTow(Tow tow){
		towServiceLocal.DeleteTow(tow);
		return "ListTow?faces-redirect=true";
	}
	
	public String newTow(){
		tow = new Tow();
		return "AddTow?faces-redirect=true";
	}
	
	public String doCancel() {
		return "ListTow?faces-redirect=true";
	}
	
	public List<Tow> getAllTow(){
		
		return towServiceLocal.getAllTow();
	}
	
	public List<Tow> getTowRequest(){
		
		return towServiceLocal.getTowRequest();
	}

	public TowServiceEjbLocal getTowServiceLocal() {
		return towServiceLocal;
	}

	public void setTowServiceLocal(TowServiceEjbLocal towServiceLocal) {
		this.towServiceLocal = towServiceLocal;
	}

	public Tow getTow() {
		return tow;
	}

	public void setTow(Tow tow) {
		this.tow = tow;
	}

	public InsuranceAgent getInsuranceAgent() {
		return insuranceAgent;
	}

	public void setInsuranceAgent(InsuranceAgent insuranceAgent) {
		this.insuranceAgent = insuranceAgent;
	}

}


