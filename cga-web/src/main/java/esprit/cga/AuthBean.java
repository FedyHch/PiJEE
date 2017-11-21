package esprit.cga;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entitys.Admin;
import Entitys.InsuranceAgent;
import Entitys.Insured;
import Entitys.User;
import Services.UserServiceLocal;
@ManagedBean(name="authBean")
@SessionScoped
public class AuthBean implements Serializable {
	private static final long serialVersionUID = -6916676537171647179L;
	@EJB
	private UserServiceLocal authenticationServiceLocal;

	// model
	
	private User user;
	private boolean loggedIn;
	private boolean loggedOut;

	//

	public AuthBean() {
	}

	// model initialization
	@PostConstruct
	public void initModel() {
		user = new User();
		
		loggedOut=true;
		loggedIn = false;
	}

	public String doLogin() {
		String navigateTo = null;
		// login application logic
		User found = authenticationServiceLocal.authenticate(user.getLogin(),
				user.getPassword());
		if (found != null) {
			user = found;
			loggedOut=false;
			loggedIn = true;
			
			if (user instanceof InsuranceAgent) {
				navigateTo = "/pages/user/home?faces-redirect=true";
			}
			if (user instanceof Admin) {
				navigateTo = "/pages/user/back?faces-redirect=true";
			}
			 if (user instanceof Insured) {
				navigateTo = "/pages/user/home?faces-redirect=true";
			}
			 

		} else {
			FacesContext.getCurrentInstance().addMessage(
					"login_form:login_submit",
					new FacesMessage("Bad credentials!"));
		}
		return navigateTo;
	}

	public String doLogout() {
		String navigateTo = null;
		initModel();
		navigateTo = "/template/template.jsf?faces-redirect=true";
		return navigateTo;
	}

	public boolean hasRole(String role) {
		boolean authorized = false;
		if (role.equals("Admin")) {
			authorized = (user instanceof Admin);
		}
		if (role.equals("Insured")) {
			authorized = (user instanceof Insured);
		}
		if (role.equals("InsuranceAgent")) {
			authorized = (user instanceof InsuranceAgent);
		}
		

		return authorized;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isLoggedOut() {
		return loggedOut;
	}

	public void setLoggedOut(boolean loggedOut) {
		this.loggedOut = loggedOut;
	}

	

}
