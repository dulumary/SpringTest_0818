package com.marondal.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marondal.spring.test.jstl.domain.Weather;
import com.marondal.spring.test.jstl.service.WeatherService;

@RequestMapping("/jstl/weather")
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/list")
	public String weatherList(Model model) {
		
		List<Weather> weatherhistory = weatherService.getWeatherHistory();
		
		model.addAttribute("weatherhistory", weatherhistory);
		
		return "jstl/weather/list";	
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		return "jstl/weather/input";
	}
	
	
	@GetMapping("/create")
	public String  createWeather(
			// 2023년09월07일 
//			@DateTimeFormat(pattern="yyyy년MM월dd일") @RequestParam("date") Date date
//			, @RequestParam("weather") String weather
//			, @RequestParam("temperatures") double temperatures
//			, @RequestParam("precipitation") double precipitation
//			, @RequestParam("microDust") String microDust
//			, @RequestParam("windSpeed") double windSpeed
			@ModelAttribute Weather weather
			) {
		
//		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		int count = weatherService.addWeatherByObject(weather);
		
		return "redirect:/jstl/weather/list";
		
	}
	
	

}
