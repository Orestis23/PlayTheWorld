package co.TashaBrianRusty.PlayTheWorld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TripController {

	@Value("${google.key}")
	String googleKey;

	// Test controller for getting distance calculation data
	@RequestMapping("distance")
	public ModelAndView hometown() {
		ModelAndView mv = new ModelAndView("distance");
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String address = "New York";

		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + googleKey;

		HttpEntity<String> request = new HttpEntity<>("Parameters", headers);
		ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET, request, String.class);
		mv.addObject("response", response.getBody());
		return mv;
	}
}
