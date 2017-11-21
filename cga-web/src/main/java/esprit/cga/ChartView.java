package esprit.cga;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import org.primefaces.model.chart.PieChartModel;

import Services.ContractServiceEjbLocal;

@ViewScoped
@ManagedBean
public class ChartView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ContractServiceEjbLocal contractServiceLocal;
	private PieChartModel pieModel1;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	private void createPieModels() {
		createPieModel1();

	}

	
	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		pieModel1.set("class Under 7", contractServiceLocal.getContracts7().size());
		pieModel1.set("class 8", contractServiceLocal.getContracts8().size());
		pieModel1.set("class 9", contractServiceLocal.getContracts9().size());
		pieModel1.set("class 10", contractServiceLocal.getContracts10().size());
		pieModel1.set("class 11", contractServiceLocal.getContracts11().size());
		
		
		
		
		pieModel1.setShowDataLabels(true);
		pieModel1.setTitle("Contrat par Classe");
		pieModel1.setLegendPosition("w");
	}

}