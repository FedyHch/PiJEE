package esprit.cga;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entitys.Assure;
import Entitys.Contract;
import Services.AssureServiceEjbLocal;


@ManagedBean
@SessionScoped
public class AssureBean {
	@EJB
	private AssureServiceEjbLocal assureServiceLocal;

	private Assure assure = new Assure();
	
	public String addAssure() {

		assureServiceLocal.addAssure(assure);
		return "ListContract?faces-redirect=true";
	}

	public String deleteAssure(Assure assure) {

		assureServiceLocal.DeleteAssure(assure);
		return "ListContract?faces-redirect=true";
	}

	public List<Contract> getAllContract() {

		return assureServiceLocal.getAllContracts();
	}

	public List<Assure> getAllAssure() {

		return assureServiceLocal.getAllAssure();
	}

	public String doCancel() {
		return "ListContract?faces-redirect=true";
	}

	public AssureServiceEjbLocal getAssureServiceLocal() {
		return assureServiceLocal;
	}

	public void setAssureServiceLocal(AssureServiceEjbLocal assureServiceLocal) {
		this.assureServiceLocal = assureServiceLocal;
	}

	public Assure getAssure() {
		return assure;
	}

	public void setAssure(Assure assure) {
		this.assure = assure;
	}
	
	

}
