package co.TashaBrianRusty.PlayTheWorld.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.TashaBrianRusty.PlayTheWorld.Repo.FavoritesRepo;
import co.TashaBrianRusty.PlayTheWorld.Repo.LocVisitedRepo;
import co.TashaBrianRusty.PlayTheWorld.Repo.UserRepo;
import co.TashaBrianRusty.PlayTheWorld.entity.Favorites;
import co.TashaBrianRusty.PlayTheWorld.entity.Homebase;
import co.TashaBrianRusty.PlayTheWorld.entity.LocVisited;
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

	@Autowired
	LocVisitedRepo locVisRepo;

	@Value("${cloud.name}")
	String cloudName;

	@Value("${upload.preset}")
	String preset;
	
	@Value("${google.key}")
	String googleKey;

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
		List<LocVisited> locs = locVisRepo.findByUserName(user.getUserName());
		mv.addObject("locList", locs);
		mv.addObject("userInfo", user);
		mv.addObject("imageList", images);
		mv.addObject("name", cloudName);
		mv.addObject("preset", preset);
		mv.addObject("list", favoriteAtt);

		return mv;
	}

	@RequestMapping("register")
	public ModelAndView personPage() {
		ModelAndView mv = new ModelAndView("login", "modelName", "Hello World!");
		User p = new User();
		mv.addObject("personA", p);
		System.out.println();
		return mv;

	}

	@PostMapping("submit-person")
	public ModelAndView submitForm(User person) {
//		System.out.println(person.getPassword());
//		 String hashpw1 = BCrypt.hashpw(person.getPassword(), BCrypt.gensalt());
//		System.out.println(hashpw);
//		 person.setPassword(hashpw1);
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String address = person.getHomeBase();
		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + googleKey;
		HttpEntity<String> request = new HttpEntity<>("Parameters", headers);
		ResponseEntity<Homebase> response = rt.exchange(url, HttpMethod.GET, request, Homebase.class);
		person.setGeoCodeLat(response.getBody().getResults().get(0).getGeometry().getLocation().getLat());
		person.setGeoCodeLon(response.getBody().getResults().get(0).getGeometry().getLocation().getLng());
		
		userRepo.save(person);
		System.out.println(person.toString());
		return new ModelAndView("person-confirm", "personinfo", person);
	}
}
