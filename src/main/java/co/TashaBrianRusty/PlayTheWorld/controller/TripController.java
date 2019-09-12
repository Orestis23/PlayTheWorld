package co.TashaBrianRusty.PlayTheWorld.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.TashaBrianRusty.PlayTheWorld.entity.Distance;

@Controller
public class TripController {

	@RequestMapping("distance")
	public ModelAndView distance() throws IOException {
		ModelAndView mv = new ModelAndView("distance");
		double lat1 = 42.3356398;
		double lon1 = -83.0502464;
		double lat2 = 42.3667297;
		double lon2 = -71.0150276;
		
		Distance distance = new Distance(lat1, lon1, lat2, lon2);
		double output = distance.getOutput();

		System.out.println(output);

		mv.addObject("response", output);
		return mv;
	}
}
