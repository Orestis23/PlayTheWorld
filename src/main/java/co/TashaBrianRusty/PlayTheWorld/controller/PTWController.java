package co.TashaBrianRusty.PlayTheWorld.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;
import com.amadeus.resources.PointOfInterest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class PTWController {

	@Value("${amadeus.key}")
	String amadeusKey;

	@Value("${amadeus.secret}")
	String amadeusSecret;

	@RequestMapping("/")
	public ModelAndView home() throws ResponseException {
		ModelAndView mv = new ModelAndView("index");

		return mv;
	}

	@RequestMapping("main-search")
	public ModelAndView mainSearch(@RequestParam("msearch") String msearch) throws ResponseException {
		ModelAndView mv = new ModelAndView("main-search-results");
		Amadeus amadeus = Amadeus.builder(amadeusKey, amadeusSecret).build();

		Location[] locations = amadeus.referenceData.locations
				.get(Params.with("keyword", msearch.toUpperCase()).and("subType", Locations.ANY));

		
		PointOfInterest[] points = amadeus.referenceData.locations.pointsOfInterest
				.get(Params.with("latitude", locations[0].getGeoCode().getLatitude())
				.and("longitude",locations[0].getGeoCode().getLongitude()));

		System.out.println((locations[0].getResponse().getBody()));
		System.out.println((points[0].getResponse().getBody()));
		System.out.println(Arrays.toString(locations));
//		mv.addObject("locations", locations[0].getResponse().getBody());
//		mv.addObject("points", points[0].getResponse().getBody());
		mv.addObject("locations", locations);
		mv.addObject("points", points);
		return mv;

	}
}
