package esprit.cga;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import Entitys.Event;
import Entitys.InsuranceAgent;
import Entitys.Insured;
import Services.EventServiceEjbLocal;

@ManagedBean
@SessionScoped
public class EventBean {
	@EJB
	private EventServiceEjbLocal ev;
	
	private Event evt = new Event();
	private InsuranceAgent a = new InsuranceAgent();
	private Insured insured = new Insured();
	private boolean joined = false;
	private boolean impossible = false;
	private String searchName="";
	
	
	private String source="";
	
	

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String init(){
		ev.addAgent(a);
		return "AddAgent?faces-redirect=true";
	}
	public String addInsured(){
		this.insured.setListEvent(new ArrayList<Event>());
		ev.addInsured(insured);
		
		return "AddInsured?faces-redirect=true";
	}
	
	
	
	public String goToDestination(){
		
		return "destination?faces-redirect=true";
	}
	
	public String doSearchByName(){
		this.getAllEv();
		
		return "ListEvent?faces-redirect=true";
	}
	
	public String doJoinEvent(){
		System.out.println("hereeeeeeeee!!!!!");
		if(!evt.getLstInsured().contains(insured)){
		this.evt.getLstInsured().add(insured);
		this.insured.getListEvent().add(evt);
		ev.updateEvent(evt);
		joined = true;
		System.out.println("c bonnnnnn");
		}else{
			joined = false;
			impossible = true;
		}
		return "EventDetails?faces-redirect=true";
	}
	
	public String backToAdd(){
		this.evt = new Event();
		this.searchName="";
		return "AddEvent?faces-redirect=true";
	}
	
	public String convertDestination(){
		String destination=evt.getEventPlace().replaceAll(" ", "+");
		String sourceUrl = this.source.replaceAll(" ","+");
		String URL = "https://www.google.com/maps/embed/v1/directions?key=AIzaSyA9Oi77AlVeudYlLdhGxbVuc-koA30OlTE&origin="+sourceUrl+"&destination="+destination;
		return URL;
	}
	
	
	
	public String convertPlace(){
		String result ="";
		String place = evt.getEventPlace();
		result+= place.replaceAll(" ","+");
		
		String URL = "https://www.google.com/maps/embed/v1/place?key=AIzaSyA9Oi77AlVeudYlLdhGxbVuc-koA30OlTE&q="+result;
		return URL;
	}
	
	public String getEventMapPlace(Event e){
		String result ="";
		String place = e.getEventPlace();
		result+= place.replaceAll(" ","+");
		String URL = "https://www.google.com/maps/embed/v1/place?key=AIzaSyA9Oi77AlVeudYlLdhGxbVuc-koA30OlTE&q="+result;
		return URL;
		
	}
	
	public String goToDetails(Event e){
		
		this.evt = e;
		this.impossible=false;
		this.joined=false;
		return "EventDetails?faces-redirect=true";
		
	}
	public String doBackToListEvent(){
		
		this.searchName="";
		this.evt = null;
		return "ListEvent?faces-redirect=true";
		
	}
	
	public String UpdateEvent(){
		
		ev.updateEvent(evt);
		return "ListEvent?faces-redirect=true";
	}
	
	public String addEvent(){
		evt.setLstInsured(new ArrayList<Insured>());
		
		ev.addEvent(evt);
		
		return "ListEvent?faces-redirect=true";
	}
	
	public List<Insured> getListParticipants(){
		return ev.getAllParticipants(evt);
		
	}
	public String goToListParticipants(Event e){
		this.evt = e;
		return "ListParticipants?faces-redirect=true";
		
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
		if(this.searchName.equals("")){
			return ev.getAllEvents();
		}
		return ev.findEventByTitle(searchName);
		
	}
	
public List<Event> filterListFront(){
		
		List<Event> list = new ArrayList<>();
		for (Event event : ev.getAllEvents()) {
			if(event.getEventDate().after(new Date())){
				list.add(event);
			}
		}
		return list;
	
	
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

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	public boolean isJoined() {
		return joined;
	}

	public void setJoined(boolean joined) {
		this.joined = joined;
	}

	public boolean isImpossible() {
		return impossible;
	}

	public void setImpossible(boolean impossible) {
		this.impossible = impossible;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

}
