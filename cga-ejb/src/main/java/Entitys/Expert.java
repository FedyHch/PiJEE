package Entitys;

import Entitys.User;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expert
 *
 */
@Entity

public class Expert extends User implements Serializable {

	
	private String Diplome;
	
	@OneToMany(mappedBy="expertClaim")
	private List<Claim> listClaim;
	
	private static final long serialVersionUID = 1L;

	public Expert() {
		super();
	}   
	public String getDiplome() {
		return this.Diplome;
	}

	public void setDiplome(String Diplome) {
		this.Diplome = Diplome;
	}
	public List<Claim> getListClaim() {
		return listClaim;
	}
	public void setListClaim(List<Claim> listClaim) {
		this.listClaim = listClaim;
	}
   
}
