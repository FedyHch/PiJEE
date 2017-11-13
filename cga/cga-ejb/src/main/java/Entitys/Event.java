package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int EventId;
	private Date EventDate;
	private String EventPlace;
	private String EventTitle;
	private String EventDescription;
	private String EventAffiche;
	
	@ManyToOne
	private InsuranceAgent agentEvent;
	@ManyToMany(mappedBy="listEvent")
	private List<Insured> lstInsured;
	
	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}   
	public int getEventId() {
		return this.EventId;
	}

	public void setEventId(int EventId) {
		this.EventId = EventId;
	}   
	public Date getEventDate() {
		return this.EventDate;
	}

	public void setEventDate(Date EventDate) {
		this.EventDate = EventDate;
	}   
	public String getEventPlace() {
		return this.EventPlace;
	}

	public void setEventPlace(String EventPlace) {
		this.EventPlace = EventPlace;
	}   
	public String getEventTitle() {
		return this.EventTitle;
	}

	public void setEventTitle(String EventTitle) {
		this.EventTitle = EventTitle;
	}   
	public String getEventDescription() {
		return this.EventDescription;
	}

	public void setEventDescription(String EventDescription) {
		this.EventDescription = EventDescription;
	}   
	public String getEventAffiche() {
		return this.EventAffiche;
	}

	public void setEventAffiche(String EventAffiche) {
		this.EventAffiche = EventAffiche;
	}
	public InsuranceAgent getAgentEvent() {
		return agentEvent;
	}
	public void setAgentEvent(InsuranceAgent agentEvent) {
		this.agentEvent = agentEvent;
	}
	public List<Insured> getLstInsured() {
		return lstInsured;
	}
	public void setLstInsured(List<Insured> lstInsured) {
		this.lstInsured = lstInsured;
	}
   
}
