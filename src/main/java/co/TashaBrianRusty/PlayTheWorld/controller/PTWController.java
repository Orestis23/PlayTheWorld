package co.TashaBrianRusty.PlayTheWorld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;
import com.amadeus.resources.Location.Address;
import com.amadeus.resources.PointOfInterest;

@Controller
public class PTWController {

	@Value("${amadeus.key}")
	String amadeusKey;

	@Value("${amadeus.secret}")
	String amadeusSecret;

	@Value("${google.key}")
	String googleKey;

	@Value("${google.secret}")
	String googleSecret;

//	@RequestMapping("/")
//	public ModelAndView home() throws ResponseException {
//		ModelAndView mv = new ModelAndView("index");
//
//		return mv;
//	}

	@RequestMapping("main-search")
	public ModelAndView mainSearch(@RequestParam("msearch") String msearch) throws ResponseException {
		ModelAndView mv = new ModelAndView("main-search-results");
		Amadeus amadeus = Amadeus.builder(amadeusKey, amadeusSecret).build();

		Location[] locations = amadeus.referenceData.locations
				.get(Params.with("keyword", msearch.toUpperCase()).and("subType", Locations.CITY));
		double latitude = 0;
		double longitude = 0;

		switch (msearch) {
		case ("London"):
			latitude = locations[0].getGeoCode().getLatitude();
			longitude = locations[0].getGeoCode().getLongitude();
			break;
		case ("New York"):
			latitude = locations[0].getGeoCode().getLatitude();
			longitude = locations[0].getGeoCode().getLongitude();
			break;
		case ("Barcelona"):
			latitude = 41.3837315;
			longitude = 2.169104;
			break;
		case ("Berlin"):
			latitude = 52.516162;
			longitude = 13.4056995;
			break;
		case ("Dallas"):
			latitude = 32.7736515;
			longitude = -96.787075;
			break;
		case ("Paris"):
			latitude = 48.855;
			longitude = 2.355;
			break;
		case ("San Francisco"):
			latitude = 37.7714935;
			longitude = -122.426896;
			break;
		}

		System.out.println(latitude);
		System.out.println(longitude);
		PointOfInterest[] points = amadeus.referenceData.locations.pointsOfInterest
				.get(Params.with("latitude", latitude).and("longitude", longitude));

		String staticMap = "https://maps.googleapis.com/maps/api/staticmap?center=" + latitude + "," + longitude
				+ "&zoom=12&size=555x300&scale=2&key=" + googleKey;

		System.out.println(staticMap);
		mv.addObject("googleKey", googleKey);
		mv.addObject("locations", locations);
		mv.addObject("points", points);
		mv.addObject("msearch", msearch);
		mv.addObject("map", staticMap);
		return mv;
	}

	@RequestMapping("city-detail")
	public ModelAndView cityDetail(@RequestParam("cityName") String city) throws ResponseException {
		ModelAndView mv = new ModelAndView("city-info");
		Amadeus amadeus = Amadeus.builder(amadeusKey, amadeusSecret).build();
//		Location[] location = amadeus.referenceData.locations.get(Params
//				  .with("cityName", city));
		Location location = amadeus.referenceData.location(city).get();
		Address address = location.getAddress();
		mv.addObject("location", address);
		return mv;
	}

	@RequestMapping("keyword-filter")
	public ModelAndView filterKeyword(@RequestParam("keyword") String tag, @RequestParam("latitude") double latitude,
			@RequestParam("longitude") double longitude) throws ResponseException {
		ModelAndView mv = new ModelAndView("keyword-filtering");
		Amadeus amadeus = Amadeus.builder(amadeusKey, amadeusSecret).build();
		PointOfInterest[] points = amadeus.referenceData.locations.pointsOfInterest
				.get(Params.with("latitude", latitude).and("longitude", longitude));
		String keyword = tag;
		mv.addObject("keyword", keyword);
		mv.addObject("points", points);
		return mv;
	}

	@RequestMapping("points-next")
	public ModelAndView pointsFirst(@RequestAttribute("next") String link) throws ResponseException {
		ModelAndView mv = new ModelAndView("main-search-results");

		return mv;
	}
}
