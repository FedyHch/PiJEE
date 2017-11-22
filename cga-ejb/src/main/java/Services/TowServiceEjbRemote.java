package Services;

import java.util.List;

import javax.ejb.Remote;

import Entitys.Insured;
import Entitys.Tow;

@Remote
public interface TowServiceEjbRemote {
	
	public void addTow(Tow t);
	public void updateTow(Tow t);
	public void DeleteTow(Tow t);
	public Tow findTowById(int idTow);
	public List<Tow> getAllTow();
	public List<Tow> notReservedTow();
	public List<Tow> findTowByInsured(Insured i);
	public void updateTowState(Tow t);
	public boolean updateTowInsured(Tow t);
	public void updateTowStatusRefuse(Tow t);
	public List<Tow> findTowByInsuredAccepted(Insured i);
	public List<Tow> getTowRequest();
}
