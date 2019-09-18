package co.TashaBrianRusty.PlayTheWorld.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.TashaBrianRusty.PlayTheWorld.Repo.ImageRepo;
import co.TashaBrianRusty.PlayTheWorld.Repo.UserRepo;
import co.TashaBrianRusty.PlayTheWorld.entity.User;
import co.TashaBrianRusty.PlayTheWorld.entity.UserImage;

@Controller
public class CloudinaryController {

	@Value("${cloud.name}")
	String cloudName;

	@Value("${upload.preset}")
	String preset;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ImageRepo imgRepo;

	@RequestMapping("cloud")
	public ModelAndView imageUpload() {
		ModelAndView mv = new ModelAndView("cloudinary");
		mv.addObject("name", cloudName);
		mv.addObject("preset", preset);

		return mv;
	}
	// window.location.assign("uploadurl?imageURL=" + result.info.url);

	@RequestMapping("uploadurl")
	public ModelAndView uploadUrl(@RequestParam("imageURL") String url) {
		User u = (User)session.getAttribute("user");
		UserImage img = new UserImage();
		img.setUrl(url);
		img.setUser(u);
		imgRepo.save(img);
		
		
		return new ModelAndView("redirect:/login?eMail=" + u.geteMail());
	}
	@RequestMapping("/delImage")
	public ModelAndView delImage(@RequestParam("imageId") int id) {
		User user = (User)session.getAttribute("user");
		//UserImage img =  new UserImage();
		imgRepo.deleteById(id);
		
		return new ModelAndView("redirect:/login?eMail=" + user.geteMail());
	}

}
