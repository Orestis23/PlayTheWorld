package co.TashaBrianRusty.PlayTheWorld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;
import com.amadeus.resources.PointOfInterest;

@Controller
public class PTWController {

	@Value("${amadeus.key}")
	String amadeusKey;

	@Value("${amadeus.secret}")
	String amadeusSecret;

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

		
		PointOfInterest[] points = amadeus.referenceData.locations.pointsOfInterest
				.get(Params.with("latitude", locations[0].getGeoCode().getLatitude())
				.and("longitude",locations[0].getGeoCode().getLongitude()));

//		System.out.println((locations[0].getResponse().getBody()));
//		System.out.println("Test " +points[0].getResponse().getBody());
//		System.out.println(Arrays.toString(locations));
		mv.addObject("locations", locations);
		mv.addObject("points", points);
		return mv;
	}
	
	
	@RequestMapping("city-detail")
	public ModelAndView cityDetail(@RequestParam("cityName")String city) throws ResponseException {
		ModelAndView mv = new ModelAndView("city-info");
		Amadeus amadeus = Amadeus.builder(amadeusKey, amadeusSecret).build();
//		Location[] location = amadeus.referenceData.locations.get(Params
//				  .with("cityName", city));
		Location location = amadeus.referenceData.location(city).get();
		mv.addObject("location", location);
		return mv;
	}
	
	@RequestMapping("keyword-filter")
	public ModelAndView filterKeyword(@RequestParam("keyword")String tag, 
			@RequestParam("latitude")double latitude, @RequestParam("longitude")double longitude) throws ResponseException {
		ModelAndView mv = new ModelAndView("keyword-filtering");
		Amadeus amadeus = Amadeus.builder(amadeusKey, amadeusSecret).build();
		PointOfInterest[] points = amadeus.referenceData.locations.pointsOfInterest
				.get(Params.with("latitude", latitude)
				.and("longitude", longitude));
		String keyword = tag;
		mv.addObject("keyword", keyword);
		mv.addObject("points", points);
		return mv;
	}
	
	@RequestMapping("points-next")
	public ModelAndView pointsFirst(@RequestAttribute("next")String link) throws ResponseException {
		ModelAndView mv = new ModelAndView("main-search-results");
		
		return mv;
	}
}
