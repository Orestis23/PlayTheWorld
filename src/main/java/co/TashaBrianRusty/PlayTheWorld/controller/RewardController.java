package co.TashaBrianRusty.PlayTheWorld.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.TashaBrianRusty.PlayTheWorld.entity.User;

@Controller
public class RewardController {

	@Value("${tango.auth}")
	String tangoKey;
	
	@Value("${tango.credit}")
	String tangoCredit;
	
	@Autowired
	HttpSession session;

	@RequestMapping("catalogs")
	public ModelAndView catalogs() {
		ModelAndView mv = new ModelAndView("catalogs");
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + tangoKey);
		headers.add("Accept", "application/json");
		String url = "https://integration-api.tangocard.com/raas/v2/catalogs?verbose=true";
		HttpEntity<String> request = new HttpEntity<>("Parameters", headers);
		ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET, request, String.class);
		System.out.println(request.toString());
		String output = new String(response.toString());
//		System.out.println(output);
		mv.addObject("output", response.getBody());
		return mv;
	}

	@RequestMapping("redeem")
	public ModelAndView redeem() {
		ModelAndView mv = new ModelAndView("redeem");
		return mv;
	}
	
	@RequestMapping(value = "redeem-points", produces = "application/json", method = RequestMethod.POST)
	public ModelAndView redeemPoints(@RequestParam("points") int points, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("eMail") String eMail) throws JsonProcessingException {
		ModelAndView mv = new ModelAndView("redeem-confirm");
//		int redeemValue = (points / 100);
		String redeemValue = Integer.toString(points / 100);
		User user = (User) session.getAttribute("user");
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", "application/json");
		headers.add("Authorization", "Basic " + tangoKey);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("accountIdentifier", "TrekStar");
		map.add("amount", redeemValue);
		map.add("creditCardToken", tangoCredit);
		map.add("customerIdentifier", "TrekStar");
		
        ObjectMapper mapper = new ObjectMapper();
        String jsonMap = mapper.writeValueAsString(map).replace("[", "").replace("]", "");
        
		String url = "https://integration-api.tangocard.com/raas/v2/creditCardDeposits";
//		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(headers, jsonMap);
		HttpEntity<String> request = new HttpEntity<String>(jsonMap, headers);
		System.out.println(request.toString());
		ResponseEntity<String> response = rt.exchange(url, HttpMethod.POST, request, String.class);
		System.out.println(response.getBody());
		return mv;
	}
}
