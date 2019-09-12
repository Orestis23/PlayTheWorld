package co.TashaBrianRusty.PlayTheWorld.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.TashaBrianRusty.PlayTheWorld.Repo.AttractionRepo;
import co.TashaBrianRusty.PlayTheWorld.Repo.FavoritesRepo;
import co.TashaBrianRusty.PlayTheWorld.entity.Attraction;
import co.TashaBrianRusty.PlayTheWorld.entity.Favorites;
import co.TashaBrianRusty.PlayTheWorld.entity.User;

@Controller
public class AttractionController {

	@Autowired
	AttractionRepo attRepo;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	FavoritesRepo favRepo;
	
	@RequestMapping("/activity-type")
	public ModelAndView home() {
		List<Attraction> attractions = attRepo.findAll();
		return new ModelAndView("activity-type", "list", attractions);
	}
	
	@RequestMapping("/delFavAtt")
	public ModelAndView delFavAtt(@RequestParam("idDelete") int id) {
		attRepo.deleteById(id);
		return new ModelAndView("redirect:/");
	}
}
