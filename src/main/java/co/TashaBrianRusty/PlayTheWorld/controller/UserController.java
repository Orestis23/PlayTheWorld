package co.TashaBrianRusty.PlayTheWorld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.TashaBrianRusty.PlayTheWorld.Repo.UserRepo;
import co.TashaBrianRusty.PlayTheWorld.entity.User;

@Controller
public class UserController {

	@Autowired
	UserRepo userRepo;

	@RequestMapping("/")
	public ModelAndView home() {
//		List<User> users = userRepo.findAll();
		return new ModelAndView("login");
	}

	@RequestMapping("/login")
	public ModelAndView submitLogin(String eMail) {
		User user = userRepo.findByeMail(eMail);
		System.out.println(user);
		return new ModelAndView("index", "userInfo", user);
	}
	


}
