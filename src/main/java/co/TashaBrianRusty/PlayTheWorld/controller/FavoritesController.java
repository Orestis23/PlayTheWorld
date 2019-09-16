package co.TashaBrianRusty.PlayTheWorld.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.TashaBrianRusty.PlayTheWorld.Repo.AttractionRepo;
import co.TashaBrianRusty.PlayTheWorld.Repo.FavoritesRepo;
import co.TashaBrianRusty.PlayTheWorld.Repo.LocVisitedRepo;
import co.TashaBrianRusty.PlayTheWorld.entity.Favorites;
import co.TashaBrianRusty.PlayTheWorld.entity.LocVisited;
import co.TashaBrianRusty.PlayTheWorld.entity.User;

@Controller
public class FavoritesController {

	@Autowired
	AttractionRepo attRepo;
	
	@Autowired
	FavoritesRepo favRepo;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	LocVisitedRepo locVisRepo;
	
	
	
	@RequestMapping("/addFavAtt")
	public ModelAndView addFavAtt(String attName, String msearch, boolean isChecked) {
		System.out.println(isChecked);
		User user = (User) session.getAttribute("user");
		Favorites favorite = new Favorites(user.getUserName(), attName);
		if (isChecked == true) {
			favRepo.save(favorite);
		}
		else {
			favRepo.delete(favorite);
		}
		ModelAndView mv = new ModelAndView("forward:/main-search");

		return mv;
	}
	
	@RequestMapping("/delFavAtt")
	public ModelAndView delFavAtt(@RequestParam("idDelete") int id) {
		attRepo.deleteById(id);
		User user = (User) session.getAttribute("user");
		
		return new ModelAndView("redirect:/login?eMail=" + user.geteMail());
	}
	
	@RequestMapping("/addLocVisited")
	public ModelAndView locVisited(String attName, String msearch) {
		User user = (User) session.getAttribute("user");
		LocVisited visited = new LocVisited(user.getUserName(), attName);
		ModelAndView mv = new ModelAndView("forward:/main-search");
		return mv;
	}
	
	@RequestMapping("/delLocVisited")
	public ModelAndView delLocVis(@RequestParam("idDelete") int id) {
		locVisRepo.deleteById(id);
		User user = (User) session.getAttribute("user");
		
		return new ModelAndView("redirect:/login?eMail=" + user.geteMail());
	}
}
