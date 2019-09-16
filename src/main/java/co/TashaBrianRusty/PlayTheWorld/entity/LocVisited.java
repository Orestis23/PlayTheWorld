package co.TashaBrianRusty.PlayTheWorld.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loc_visited")
public class LocVisited {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private String activityName;
	
	public LocVisited() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public LocVisited(String userName, String activityName) {
		
		this.userName = userName;
		this.activityName = activityName;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "LocVisited [id=" + id + ", userName=" + userName + ", activityName=" + activityName + "]";
	}
	
	
	
}
