package Services;

import java.util.List;

import javax.ejb.Local;

import Entitys.Claim;
import Entitys.Complaint;

import Entitys.InsuranceAgent;

@Local
public interface ComplaintServiceEjbLocal {
	
	public void addComplaint(Complaint c);
	public void updateComplaint(Complaint c);
	public void DeleteComplaint(Complaint c);
	public Complaint findComplaintById(int Complaint_id);
	public List<Complaint> getAllComplaints();
	public List<Claim> getAllClaims();
	public void addAgent(InsuranceAgent a);
	
}
