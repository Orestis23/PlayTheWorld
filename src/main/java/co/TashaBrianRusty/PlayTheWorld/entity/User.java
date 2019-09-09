package co.TashaBrianRusty.PlayTheWorld.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String homeBase;
	private String currentPoints;
	private String locVisited;
	private int locVisPts;
	private String favCountries;
	private String favActivities;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getHomeBase() {
		return homeBase;
	}

	public void setHomeBase(String homeBase) {
		this.homeBase = homeBase;
	}

	public String getCurrentPoints() {
		return currentPoints;
	}

	public void setCurrentPoints(String currentPoints) {
		this.currentPoints = currentPoints;
	}

	public String getLocVisited() {
		return locVisited;
	}

	public void setLocVisited(String locVisited) {
		this.locVisited = locVisited;
	}

	public int getLocVisPts() {
		return locVisPts;
	}

	public void setLocVisPts(int locVisPts) {
		this.locVisPts = locVisPts;
	}

	public String getFavCountries() {
		return favCountries;
	}

	public void setFavCountries(String favCountries) {
		this.favCountries = favCountries;
	}

	public String getFavActivities() {
		return favActivities;
	}

	public void setFavActivities(String favActivities) {
		this.favActivities = favActivities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", homeBase=" + homeBase + ", currentPoints="
				+ currentPoints + ", locVisited=" + locVisited + ", locVisPts=" + locVisPts + ", favCountries="
				+ favCountries + ", favActivities=" + favActivities + "]";
	}


}
