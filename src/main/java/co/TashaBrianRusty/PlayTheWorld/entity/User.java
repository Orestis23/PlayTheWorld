package co.TashaBrianRusty.PlayTheWorld.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String eMail;
	private String homeBase;
	private String currentPoints;
	private String locVisited;
	private String favCities;
	private String favActivities;
//	@JsonProperty("image_url")
//	private String imageUrl;
	
	@OneToMany(mappedBy="user")
	private List<UserImage> imageList;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<UserImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<UserImage> imageList) {
		this.imageList = imageList;
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
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

	public String getFavCities() {
		return favCities;
	}

	public void setFavCities(String favCities) {
		this.favCities = favCities;
	}

	public String getFavActivities() {
		return favActivities;
	}

	public void setFavActivities(String favActivities) {
		this.favActivities = favActivities;
	}

//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", eMail=" + eMail + ", homeBase=" + homeBase
				+ ", currentPoints=" + currentPoints + ", locVisited=" + locVisited + ", favCities=" + favCities
				+ ", favActivities=" + favActivities;
	}

	
}