package Services;

import java.util.List;

import javax.ejb.Remote;

import Entitys.Event;
import Entitys.InsuranceAgent;
import Entitys.Insured;

@Remote
public interface EventServiceEjbRemote {
	
	public void addEvent(Event e);
	public void updateEvent(Event e);
	public void DeleteEvent(Event e);
	public Event findEventById(int idEvent);
	public List<Event> getAllEvents();
	public List<Insured> getAllParticipants(Event e);
	public void addAgent(InsuranceAgent a);
	
}
