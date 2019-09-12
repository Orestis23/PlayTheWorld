package co.TashaBrianRusty.PlayTheWorld.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.TashaBrianRusty.PlayTheWorld.Repo.AttractionRepo;
import co.TashaBrianRusty.PlayTheWorld.Repo.FavoritesRepo;
import co.TashaBrianRusty.PlayTheWorld.entity.Favorites;
import co.TashaBrianRusty.PlayTheWorld.entity.User;

@Controller
public class FavoritesController {

	@Autowired
	AttractionRepo attRepo;
	
	@Autowired
	FavoritesRepo favRepo;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/addFavAtt")
	public ModelAndView addFavAtt(String attName, String msearch) {
//		attRepo.save(attDetails);
		System.out.println("Add to Favorites" + attName);
		User user = (User) session.getAttribute("user");
		Favorites favorite = new Favorites(user.getUserName(), attName);
		favRepo.save(favorite);
		System.out.println(user);
		System.out.println(msearch);
		// ModelAndView mv = new ModelAndView("forward:/main-search?msearch=" + msearch);
		ModelAndView mv = new ModelAndView("forward:/main-search");

		return mv;
	}
	
	@RequestMapping("/delFavAtt")
	public ModelAndView delFavAtt(@RequestParam("idDelete") int id) {
		attRepo.deleteById(id);
		return new ModelAndView("redirect:/");
	}
}
