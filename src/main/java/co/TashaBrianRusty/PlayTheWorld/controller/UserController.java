package co.TashaBrianRusty.PlayTheWorld.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.TashaBrianRusty.PlayTheWorld.Repo.FavoritesRepo;
import co.TashaBrianRusty.PlayTheWorld.Repo.UserRepo;
import co.TashaBrianRusty.PlayTheWorld.entity.Favorites;
import co.TashaBrianRusty.PlayTheWorld.entity.User;
import co.TashaBrianRusty.PlayTheWorld.entity.UserImage;

@Controller
public class UserController {

	@Autowired
	FavoritesRepo favRepo;
	
	@Autowired
	UserRepo userRepo;

	@Autowired
	HttpSession session;
	
	@Value("${cloud.name}")
	String cloudName;

	@Value("${upload.preset}")
	String preset;

	@RequestMapping("/")
	public ModelAndView home() {
//		List<User> users = userRepo.findAll();
		return new ModelAndView("login");
	}

	@RequestMapping("/login")
	public ModelAndView submitLogin(String eMail) {
		ModelAndView mv = new ModelAndView("index");
		User user = userRepo.findByeMail(eMail);
		session.setAttribute("user", user);
		List<Favorites> favoriteAtt = favRepo.findByUserName(user.getUserName());
		List<UserImage> images = user.getImageList();
		
		mv.addObject("userInfo", user);
		mv.addObject("imageList", images);
		mv.addObject("name", cloudName);
		mv.addObject("preset", preset);
		mv.addObject("list", favoriteAtt);
		return mv;
	}

}
