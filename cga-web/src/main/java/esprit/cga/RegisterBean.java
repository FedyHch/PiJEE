package esprit.cga;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import Entitys.Insured;
import Services.InsuredServiceLocal;
import Services.UserServiceLocal;

@ManagedBean
@ViewScoped
public class RegisterBean implements Serializable{
	
	private static final long serialVersionUID = -9107031652753540690L;

		@EJB
		private UserServiceLocal userServiceLocal;

		@EJB
		private InsuredServiceLocal insuredService;

		@ManagedProperty("#{authBean}")
		private AuthBean authBean;

		private Insured insured;
		private List<Insured> insureds;
		private boolean formDisplayed;
		private List<Insured> filteredInsured;

		public RegisterBean() {
		}

		@PostConstruct
		public void init() {
			insured = new Insured();
			insureds = insuredService.findAllInsured();
			formDisplayed = false;
		}
		
		
		

		public String doSignUp() {
			String navigateTo = null;
			insuredService.saveOrUpdate(insured);
			authBean.setUser(insured);
			navigateTo = authBean.doLogin();
			return navigateTo;
		}
		
		
		public void doDelete() {
			insuredService.removeInsured(insured);
			insureds = insuredService.findAllInsured();
			formDisplayed = false;
		}

		public void doCancel() {
			formDisplayed = false;
		}
		
		public void onRowSelect() {
			formDisplayed = true;
		}
		
		public void onFilter(){
			insured = new Insured();
			formDisplayed = false;
		}

		

		public Insured getInsured() {
			return insured;
		}

		public void setInsured(Insured insured) {
			this.insured = insured;
		}

		public void validateLoginUnicity(FacesContext context,
				UIComponent component, Object value) throws ValidatorException {
			String loginToValidate = (String) value;
			if (loginToValidate == null || loginToValidate.trim().isEmpty()) {
				return;
			}
			boolean loginInUse = userServiceLocal.loginExists(loginToValidate);
			if (loginInUse) {
				throw new ValidatorException(new FacesMessage(
						"login already in use!"));
			}
		}

		public AuthBean getAuthBean() {
			return authBean;
		}

		public void setAuthBean(AuthBean authBean) {
			this.authBean = authBean;
		}

		public List<Insured> getInsureds() {
			return insureds;
		}

		public void setInsureds(List<Insured> insureds) {
			this.insureds = insureds;
		}

		public boolean isFormDisplayed() {
			return formDisplayed;
		}

		public void setFormDisplayed(boolean formDisplayed) {
			this.formDisplayed = formDisplayed;
		}

		public List<Insured> getFilteredInsured() {
			return filteredInsured;
		}

		public void setFilteredInsured(List<Insured> filteredInsured) {
			this.filteredInsured = filteredInsured;
		}

}
