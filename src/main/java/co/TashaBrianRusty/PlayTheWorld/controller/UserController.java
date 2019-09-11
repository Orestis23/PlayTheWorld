package co.TashaBrianRusty.PlayTheWorld.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.TashaBrianRusty.PlayTheWorld.Repo.UserRepo;
import co.TashaBrianRusty.PlayTheWorld.entity.User;
import co.TashaBrianRusty.PlayTheWorld.entity.UserImage;

@Controller
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	HttpSession session;

	@RequestMapping("/")
	public ModelAndView home() {
//		List<User> users = userRepo.findAll();
		return new ModelAndView("login");
	}

	@RequestMapping("/login")
	public ModelAndView submitLogin(String eMail) {
		User user = userRepo.findByeMail(eMail);
		session.setAttribute("user", user);
		
		List<UserImage> images = user.getImageList();
		
		System.out.println(user);
		ModelAndView mv = new ModelAndView("index", "userInfo", user);
		mv.addObject("imageList", images);
		
		
		
		
		return mv;
	}
	


}
