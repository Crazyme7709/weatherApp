package com.example.weatherapp.weatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherapp.weatherApp.service.WeatherService;

import io.swagger.annotations.ApiParam;

@RestController
//@Api(value ="weatherControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("api/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	//Return a JSON object that gives the weather averages.
	@GetMapping(value = "/nearby-forecast", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> weatherForecastAverage(@ApiParam("City's name") @RequestParam(required = true) String city) {
		return weatherService.weatherForecastAverage(city);
	}

}
