package co.TashaBrianRusty.PlayTheWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tangocard.raas.controllers.StatusController;
import com.tangocard.raas.http.client.APICallBack;
import com.tangocard.raas.http.client.HttpContext;
import com.tangocard.raas.models.SystemStatusResponseModel;

@Controller
public class RewardController {

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
}
