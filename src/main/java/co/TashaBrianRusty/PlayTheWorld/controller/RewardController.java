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

import com.tangocard.raas.controllers.StatusController;
import com.tangocard.raas.http.client.APICallBack;
import com.tangocard.raas.http.client.HttpContext;
import com.tangocard.raas.models.SystemStatusResponseModel;

@Controller
public class RewardController {

	@Value("${tango.key}")
	String tangoKey;

	// Test controller for calling rewards data
	@RequestMapping("rewards")
	public ModelAndView rewards() {
		com.tangocard.raas.RaasClient client = new com.tangocard.raas.RaasClient();
		StatusController statusController = client.getStatus();

		statusController.getSystemStatusAsync(new APICallBack<SystemStatusResponseModel>() {
			public void onSuccess(HttpContext context, SystemStatusResponseModel response) {
				System.out.println(response.toString());
			}

			public void onFailure(HttpContext context, Throwable error) {
				System.out.println(error.toString());
			}
		});

		String output = new String(statusController.toString());
		System.out.println(output);
		return null;
	}

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
}
