package esprit.cga;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entitys.Event;
import Entitys.InsuranceAgent;
import Services.EventServiceEjbLocal;

@ManagedBean
@SessionScoped
public class EventBean {
	@EJB
	private EventServiceEjbLocal ev;
	
	private Event evt = new Event();
	private InsuranceAgent a = new InsuranceAgent();
	
	

	public String init(){
		
		
		ev.addAgent(a);
		return "AddAgent?faces-redirect=true";
	}
	public String UpdateEvent(){
		
		ev.updateEvent(evt);
		return "ListEvent?faces-redirect=true";
	}
	
	public String addEvent(){
		
		ev.addEvent(evt);
		return "ListEvent?faces-redirect=true";
	}
	
	public String updateEventInit(Event e){
		
		this.evt = e;
		
		return "UpdateEvent?faces-redirect=true";
		
		
	}
	
	public String deleteEvent(Event e){
		
		ev.DeleteEvent(e);
		System.out.println(e.getEventId());
		return "ListEvent?faces-redirect=true";
	}
	
	public List<Event> getAllEv(){
		
		return ev.getAllEvents();
	}

	public Event getEvt() {
		return evt;
	}

	public void setEvt(Event evt) {
		this.evt = evt;
	}
	public InsuranceAgent getA() {
		return a;
	}

	public void setA(InsuranceAgent a) {
		this.a = a;
	}

}
