package co.TashaBrianRusty.PlayTheWorld.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.util.net.WriteBuffer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

@Controller
public class TripController {

	@RequestMapping("distance")
	public ModelAndView distance() throws IOException {
		ModelAndView mv = new ModelAndView("distance");
		OkHttpClient client = new OkHttpClient();

//		Request request = new Request.Builder()
//				.url("https://distanceto.p.rapidapi.com/get?car=false&foot=false&route=%5B%7B%22t%22%3A%22Detroit%22%7D%2C%20%7B%22t%22%3A%22Cincinnati%22%7D%5D")
//				.addHeader("x-rapidapi-host", "distanceto.p.rapidapi.com")
//				.addHeader("x-rapidapi-key", "9f8613d04amsh31fae906e6a9681p115f67jsne8bddf322bbe").build();
		Request request = new Request.Builder().url(
				"https://distanceto.p.rapidapi.com/get?car=false&foot=false&route=%5B%7B%22t%22%3A%22Detroit%22%7D%2C%20%7B%22t%22%3A%22Cincinnati%22%7D%5D")
				.get().addHeader("x-rapidapi-host", "distanceto.p.rapidapi.com")
				.addHeader("x-rapidapi-key", "9f8613d04amsh31fae906e6a9681p115f67jsne8bddf322bbe").build();
		Response response = client.newCall(request).execute();
		ResponseBody body = response.body();
		String output = body.string();
		System.out.println(output);
		output = output.substring(output.indexOf("\"vincenty\":") + 11, output.indexOf(",\"radians\""));
//					Pattern pattern = Pattern.compile("\"vincenty\":[0-9]{0,3}.[0-9]*,");
//					Matcher matcher = pattern.matcher(output);                                 
		System.out.println(output);

		mv.addObject("response", output);
		return mv;
	}
}
