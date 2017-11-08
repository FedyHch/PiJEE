package Services;

import java.util.List;

import javax.ejb.Local;

import Entitys.Event;
import Entitys.InsuranceAgent;
import Entitys.Insured;
@Local
public interface EventServiceEjbLocal {
	
	public void addEvent(Event e);
	public void updateEvent(Event e);
	public void DeleteEvent(Event e);
	public Event findEventById(int idEvent);
	public List<Event> getAllEvents();
	public List<Insured> getAllParticipants(Event e);
	public void addAgent(InsuranceAgent a);

}
