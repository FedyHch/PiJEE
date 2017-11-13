package esprit.cga;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entitys.InsuranceAgent;
import Entitys.Insured;
import Entitys.Tow;
import Services.TowServiceEjbLocal;

@ManagedBean
@SessionScoped
public class InsuranceTowBean {
	@EJB
	private TowServiceEjbLocal towServiceLocal;
	
	private Tow tow = new Tow();
	private InsuranceAgent insuranceAgent = new InsuranceAgent();

	public List<Tow> getAllNotReservedTow(){
		
		return towServiceLocal.notReservedTow();
	}

	
	public List<Tow> getAllInsuranceTow(){
	Insured insured = new Insured();
	insured.setCin("12345678");
		return towServiceLocal.findTowByInsured(insured);
	}
	
	public List<Tow> getTowInsuredAccepted(){
		Insured insured = new Insured();
		insured.setCin("12234455");
		return towServiceLocal.findTowByInsuredAccepted(insured);
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
	
	
	public String request(Tow t){
		Insured insured = new Insured();
		insured.setCin("12234455");
		t.setInsured(insured);
		this.tow = t;
		towServiceLocal.updateTowInsured(tow);
		return "ListTow?faces-redirect=true";
	}

}


