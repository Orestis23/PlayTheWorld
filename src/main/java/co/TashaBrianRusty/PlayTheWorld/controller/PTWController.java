package co.TashaBrianRusty.PlayTheWorld.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;

@Controller
public class PTWController {

	@Value("${amadeus.key}")
	String amadeusKey;
	
	@Value("${amadeus.secret}")
	String amadeusSecret;
	
	@RequestMapping("/")
	public ModelAndView home() throws ResponseException {
		
		//System.out.println(aService.getAmadeusAccessToken());
	    Amadeus amadeus = Amadeus
	           // .builder("f779sN5J95dn7QCitysGumNZLpClSok8", "KVOSJxlMU76in2cn")
	    		 .builder(amadeusKey, amadeusSecret)
	            .build();

	    Location[] locations = amadeus.referenceData.locations.get(Params
	      .with("keyword", "DETROIT")
	      .and("subType", Locations.ANY));

	    System.out.println(Arrays.toString(locations));

		return new ModelAndView("index");
	}

}
