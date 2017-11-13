package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Subject
 *
 */
@Entity

public class Subject implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int SubjectId;
	private Date SubjectDate;
	private String SubjectTitle;
	private String SubjectContents;
	@ManyToOne
	private Insured insured;
	
	@OneToMany(mappedBy="subject")
	private List<Post> listPost;
	private static final long serialVersionUID = 1L;

	public Subject() {
		super();
	}   
	public int getSubjectId() {
		return this.SubjectId;
	}

	public void setSubjectId(int SubjectId) {
		this.SubjectId = SubjectId;
	}   
	public Date getSubjectDate() {
		return this.SubjectDate;
	}

	public void setSubjectDate(Date SubjectDate) {
		this.SubjectDate = SubjectDate;
	}   
	public String getSubjectTitle() {
		return this.SubjectTitle;
	}

	public void setSubjectTitle(String SubjectTitle) {
		this.SubjectTitle = SubjectTitle;
	}
	public String getSubjectContents() {
		return SubjectContents;
	}
	public void setSubjectContents(String subjectContents) {
		SubjectContents = subjectContents;
	}
	public Insured getInsured() {
		return insured;
	}
	public void setInsured(Insured insured) {
		this.insured = insured;
	}
	public List<Post> getListPost() {
		return listPost;
	}
	public void setListPost(List<Post> listPost) {
		this.listPost = listPost;
	}
   
}
