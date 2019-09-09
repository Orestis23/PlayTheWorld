package co.TashaBrianRusty.PlayTheWorld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.TashaBrianRusty.PlayTheWorld.Repo.CountryRepo;
import co.TashaBrianRusty.PlayTheWorld.entity.Country;

@Controller
public class CountryController {

	@Autowired
	CountryRepo ctRepo;

	@RequestMapping("/country")
	public ModelAndView home() {
		List<Country> countries = ctRepo.findAll();
		return new ModelAndView("country", "list", countries);
	}

	@RequestMapping("/addFavCountry")
	public ModelAndView addFavAtt(Country ctDetails) {
		ctRepo.save(ctDetails);
		return new ModelAndView("redirect:/");
	}
	@RequestMapping("/delFavCountry")
	public ModelAndView delFavCountry(@RequestParam("idDelete") int id) {
		ctRepo.deleteById(id);
		return new ModelAndView("redirect:/");
	}
}
