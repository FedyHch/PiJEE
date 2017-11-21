package Services;

import java.util.List;
import javax.ejb.Local;
import Entitys.Assure;
import Entitys.Contract;

@Local
public interface AssureServiceEjbLocal {

	public void addAssure(Assure c);

	public void updateAssure(Assure c);

	public void DeleteAssure(Assure c);

	public Assure findAssureById(int idAssure);

	public List<Contract> getAllContracts();

	public List<Assure> getAllAssure();

}
