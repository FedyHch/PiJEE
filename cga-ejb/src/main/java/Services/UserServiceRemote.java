package Services;

import java.util.List;

import javax.ejb.Remote;

import Entitys.InsuranceAgent;
import Entitys.Insured;
import Entitys.User;

@Remote
public interface UserServiceRemote {
	void createUser(User user);
	List<User> findAllUsers();
	User authenticate(String login, String password);
	void saveInsured(Insured insured);
	 void saveAgent(InsuranceAgent insuranceAgent);
}
