package co.TashaBrianRusty.PlayTheWorld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CloudinaryController {

	@Value("${cloud.name}")
	String cloudName;
	
	@Value("${upload.preset}")
	String preset;
	
	
	
	
	@RequestMapping ("cloud")
	public ModelAndView imageUpload() {
		ModelAndView mv = new ModelAndView ("cloudinary");
		mv.addObject("name", cloudName);
		mv.addObject("preset", preset);

		return mv;
	}
	
}
