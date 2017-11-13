package esprit.cga;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MapBean {
	
	private String place="";
	private String Source="";
	private String Destination="";
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}

}
