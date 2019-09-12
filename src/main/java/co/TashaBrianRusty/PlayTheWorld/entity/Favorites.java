package co.TashaBrianRusty.PlayTheWorld.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Favorites")
public class Favorites {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String activityName;

	public Favorites() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorites(String userName, String activityName) {
		super();
		
		this.userName = userName;
		this.activityName = activityName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Override
	public String toString() {
		return "Favorites [id=" + id + ", userName=" + userName + ", activityName=" + activityName + "]";
	}

}
