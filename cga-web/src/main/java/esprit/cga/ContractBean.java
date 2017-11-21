package esprit.cga;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entitys.Assure;
import Entitys.Contract;
import Entitys.InsuranceCompany;
import Entitys.InsuranecPolicy;
import Services.AssureServiceEjbLocal;
import Services.ContractServiceEjbLocal;

@ManagedBean(name = "contractBean")
@SessionScoped
public class ContractBean {
	@EJB
	private ContractServiceEjbLocal contractServiceLocal;
	@EJB
	private AssureServiceEjbLocal assureServiceLocal;

	private Contract contract = new Contract();
	private List<Assure> assures;
	private Integer SelectedAssureId;
	private Integer SelectedAssuranceId;
	private Integer SelectedPoliceId;
	private String SelectedType;
	private Date d = new Date();
	
	private int old;
	Assure oldAsssure = new Assure();

	public String addContract() {

		Assure selectedAsssure = new Assure();
		InsuranecPolicy police = new InsuranecPolicy();
		InsuranceCompany selectedAsssurance = new InsuranceCompany();
		selectedAsssurance.setCompId(SelectedAssuranceId);
		selectedAsssure.setId(SelectedAssureId);

		police.setId(8);

		contract.setStartDate(d);
		contract.setInsurancePolicy(police);
		contract.setType(SelectedType);
		contract.setAssures(selectedAsssure);
		contract.setInsuranceCompany(selectedAsssurance);

		contractServiceLocal.addContract(contract);
		return "ListContract?faces-redirect=true";
	}

	public String UpdateDetails() {

		
		InsuranecPolicy police = new InsuranecPolicy();
		System.out.println(this.old);
		if (SelectedPoliceId - this.old > 1) {
			this.oldAsssure.setPointFidel(oldAsssure.getPointFidel() + 200);
		} 
		assureServiceLocal.updateAssure(oldAsssure);
		police.setId(SelectedPoliceId);
		contract.setType(SelectedType);
		contract.setInsurancePolicy(police);
		contract.setAssures(oldAsssure);

		contractServiceLocal.updateContract(contract);
		return "ListContract?faces-redirect=true";
	}

	public String UpdateContract() {

		Assure selectedAsssure = new Assure();
		InsuranceCompany selectedAsssurance = new InsuranceCompany();
		InsuranecPolicy police = new InsuranecPolicy();
		selectedAsssurance.setCompId(SelectedAssuranceId);
		selectedAsssure.setId(SelectedAssureId);
		police.setId(SelectedPoliceId);
		contract.setInsurancePolicy(police);
		contract.setAssures(selectedAsssure);
		contract.setInsuranceCompany(selectedAsssurance);

		contractServiceLocal.updateContract(contract);
		return "ListContract?faces-redirect=true";
	}

	public String DetailsContract(Contract c) {

		this.oldAsssure=c.getAssures();
		this.old = c.getInsurancePolicy().getId();
		System.out.println(this.old);
		this.contract = c;

		return "Details?faces-redirect=true";
	}

	public String updateContractInit(Contract c) {

		this.contract = c;
		return "UpdateContract?faces-redirect=true";

	}

	public String deleteContract(Contract contract) {

		contractServiceLocal.DeleteContract(contract);
		return "ListContract?faces-redirect=true";
	}

	public List<Contract> getAllContract() {

		return contractServiceLocal.getAllContracts();
	}

	public List<InsuranceCompany> getAllAssurance() {

		return contractServiceLocal.getAllAssurance();
	}

	public List<InsuranecPolicy> getAllPolice() {

		return contractServiceLocal.getAllPolice();
	}

	public List<Assure> getAllInsured() {

		return contractServiceLocal.getAllInsured();
	}

	public String doCancel() {
		return "ListContract?faces-redirect=true";
	}

	public List<Assure> getAssures() {
		return assures;
	}

	public void setAssures(List<Assure> assures) {
		this.assures = assures;
	}

	public Integer getSelectedAssureId() {
		return SelectedAssureId;
	}

	public void setSelectedAssureId(Integer selectedAssureId) {
		SelectedAssureId = selectedAssureId;
	}

	public AssureServiceEjbLocal getAssureServiceLocal() {
		return assureServiceLocal;
	}

	public void setAssureServiceLocal(AssureServiceEjbLocal assureServiceLocal) {
		this.assureServiceLocal = assureServiceLocal;
	}

	public Integer getSelectedAssuranceId() {
		return SelectedAssuranceId;
	}

	public void setSelectedAssuranceId(Integer selectedAssuranceId) {
		SelectedAssuranceId = selectedAssuranceId;
	}

	public ContractServiceEjbLocal getContractServiceLocal() {
		return contractServiceLocal;
	}

	public void setContractServiceLocal(ContractServiceEjbLocal contractServiceLocal) {
		this.contractServiceLocal = contractServiceLocal;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getSelectedType() {
		return SelectedType;
	}

	public void setSelectedType(String selectedType) {
		SelectedType = selectedType;
	}

	public Integer getSelectedPoliceId() {
		return SelectedPoliceId;
	}

	public void setSelectedPoliceId(Integer selectedPoliceId) {
		SelectedPoliceId = selectedPoliceId;
	}



	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public Assure getOldAsssure() {
		return oldAsssure;
	}

	public void setOldAsssure(Assure oldAsssure) {
		this.oldAsssure = oldAsssure;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

}
