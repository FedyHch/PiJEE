package Services;

import java.util.List;
import javax.ejb.Remote;
import Entitys.Assure;
import Entitys.Contract;

@Remote
public interface AssureServiceEjbRemote {

	public void addAssure(Assure c);

	public void updateAssure(Assure c);

	public void DeleteAssure(Assure c);

	public Assure findAssureById(int idAssure);

	public List<Contract> getAllContracts();

	public List<Assure> getAllAssure();

}
