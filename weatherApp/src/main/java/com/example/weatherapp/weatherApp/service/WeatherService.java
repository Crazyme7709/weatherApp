package com.example.weatherapp.weatherApp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.weatherapp.weatherApp.dto.WeatherAverageDTO;
import com.example.weatherapp.weatherApp.dto.WeatherMapDTO;
import com.example.weatherapp.weatherApp.dto.WeatherMapTimeDTO;

import springfox.documentation.spring.web.json.Json;

@Service
public class WeatherService {

	private final String URI = "http://api.openweathermap.org/data/2.5/forecast";
	private final String API_ID = "0b5731887a2e0745f631322b1ec14bec"; 

	private final RestTemplate restTemplate;

	public WeatherService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	//@Cached(expire = 10, timeUnit = TimeUnit.MINUTES)
	public ResponseEntity<?> weatherForecastAverage(String city) {
		List<WeatherAverageDTO> result = new ArrayList<WeatherAverageDTO>();
		try {
			WeatherMapDTO weatherMap = this.restTemplate.getForObject(this.url(city), WeatherMapDTO.class);

			for (LocalDate reference = LocalDate.now();
					reference.isBefore(LocalDate.now().plusDays(4));
					reference = reference.plusDays(1)) {
				final LocalDate ref = reference;
				List<WeatherMapTimeDTO> collect = weatherMap.getList().stream()
						.filter(x -> x.getDt().toLocalDate().equals(ref)).collect(Collectors.toList());
				if (!CollectionUtils.isEmpty(collect)) {
					result.add(this.average(collect));
				}

			}
		} catch (HttpClientErrorException e) {
			return new ResponseEntity<>(new Json(e.getResponseBodyAsString()), e.getStatusCode());
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	private WeatherAverageDTO average(List<WeatherMapTimeDTO> list) {
		WeatherAverageDTO result = new WeatherAverageDTO();

		for (WeatherMapTimeDTO item : list) {
			result.setDate(item.getDt().toLocalDate());
			result.plusMap(item);
		}

		result.totalize();

		return result;
	}

	private String url(String city) {
		return String.format(URI.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, API_ID);
	}

}
