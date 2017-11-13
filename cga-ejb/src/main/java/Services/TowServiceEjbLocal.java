package Services;

import java.util.List;

import javax.ejb.Local;

import Entitys.Insured;
import Entitys.Tow;
@Local
public interface TowServiceEjbLocal {
	
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

}
