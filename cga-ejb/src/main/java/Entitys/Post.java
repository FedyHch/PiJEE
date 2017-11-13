package Entitys;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity

public class Post implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int PostId;
	private Date PostDate;
	private String PostContents;
	@ManyToOne
	private Subject subject;
	
	private static final long serialVersionUID = 1L;

	public Post() {
		super();
	}   
	public int getPostId() {
		return this.PostId;
	}

	public void setPostId(int PostId) {
		this.PostId = PostId;
	}   
	public Date getPostDate() {
		return this.PostDate;
	}

	public void setPostDate(Date PostDate) {
		this.PostDate = PostDate;
	}   
	public String getPostContents() {
		return this.PostContents;
	}

	public void setPostContents(String PostContents) {
		this.PostContents = PostContents;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
   
}
