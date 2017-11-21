package Services;

import java.util.List;

import javax.ejb.Local;

import Entitys.InsuranceAgent;
import Entitys.Insured;
import Entitys.User;

@Local
public interface UserServiceLocal {
	void createUser(User user);
	List<User> findAllUsers();
	User authenticate(String login, String password);
	boolean loginExists(String login);
	 void saveInsured(Insured insured);
	 void saveAgent(InsuranceAgent insuranceAgent);

}
