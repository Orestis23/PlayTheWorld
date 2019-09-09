package co.TashaBrianRusty.PlayTheWorld.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String countryInfo;
	private String sight;
	private String beachPark;
	private String historicalAtt;
	private String restaurant;
	private String countryBgImage;
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return name;
	}

	public void setCountryName(String countryName) {
		this.name = countryName;
	}

	public String getCountryInfo() {
		return countryInfo;
	}

	public void setCountryInfo(String countryInfo) {
		this.countryInfo = countryInfo;
	}

	public String getSight() {
		return sight;
	}

	public void setSight(String sight) {
		this.sight = sight;
	}

	public String getBeachPark() {
		return beachPark;
	}

	public void setBeachPark(String beachPark) {
		this.beachPark = beachPark;
	}

	public String getHistoricalAtt() {
		return historicalAtt;
	}

	public void setHistoricalAtt(String historicalAtt) {
		this.historicalAtt = historicalAtt;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getCountryBgImage() {
		return countryBgImage;
	}

	public void setCountryBgImage(String countryBgImage) {
		this.countryBgImage = countryBgImage;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + name + ", countryInfo=" + countryInfo + ", sight="
				+ sight + ", beachPark=" + beachPark + ", historicalAtt=" + historicalAtt + ", restaurant=" + restaurant
				+ ", countryBgImage=" + countryBgImage + "]";
	}
	
}
