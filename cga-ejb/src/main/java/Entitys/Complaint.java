package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claim
 *
 */
@Entity

public class Complaint implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Complaint_id;
	private Date Complaint_date;
	private String description;
	@ManyToOne
	private Insured insuredComplaint;
	
	
	
	private static final long serialVersionUID = 1L;

	public Complaint() {
		super();
	}   
	

	

	
	public int getComplaint_id() {
		return Complaint_id;
	}





	public void setComplaint_id(int complaint_id) {
		Complaint_id = complaint_id;
	}





	public Date getComplaint_date() {
		return Complaint_date;
	}





	public void setComplaint_date(Date complaint_date) {
		Complaint_date = complaint_date;
	}





	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}





	public Insured getInsuredComplaint() {
		return insuredComplaint;
	}





	public void setInsuredComplaint(Insured insuredComplaint) {
		this.insuredComplaint = insuredComplaint;
	}
   
}
