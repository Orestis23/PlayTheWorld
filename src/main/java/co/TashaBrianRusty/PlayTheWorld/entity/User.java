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
	private Integer id;
	private String userName;
	private String eMail;
	private String homeBase;
	private String currentPoints;
	private String favCities;
	private String favActivities;
	private String profileImage;
	private String password;
//	@JsonProperty("image_url")
//	private String imageUrl;
	private long geoCodeLat;
	private long geoCodeLon;

	@OneToMany(mappedBy = "user")
	private List<UserImage> imageList;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getGeoCodeLat() {
		return geoCodeLat;
	}

	public void setGeoCodeLat(long geoCodeLat) {
		this.geoCodeLat = geoCodeLat;
	}

	public long getGeoCodeLon() {
		return geoCodeLon;
	}

	public void setGeoCodeLon(long geoCodeLon) {
		this.geoCodeLon = geoCodeLon;
	}

	public List<UserImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<UserImage> imageList) {
		this.imageList = imageList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", eMail=" + eMail + ", homeBase=" + homeBase
				+ ", currentPoints=" + currentPoints + ", favCities=" + favCities + ", favActivities=" + favActivities
				+ ", profileImage=" + profileImage + ", password=" + password + ", imageList=" + imageList + "]";
	}




}
