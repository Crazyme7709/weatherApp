package com.example.weatherapp.weatherApp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherDataApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {
	}
	
	
	/*@Test
	public void shouldReturnMoscow() {
		try {
			mvc.perform(get("/v1/weather/data").param("CITY", "Moscow").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.items.length()", is(3))).andExpect(jsonPath("$.items[0].name", is("Moscow")))
					.andExpect(jsonPath("$.items[1].name", is("Moscow")))
					.andExpect(jsonPath("$.items[2].name", is("Moscow")));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}*/
	
	/*@Test(expected = Exception.class)
	public void shouldReturnBadRequest() {
		try {
			mvc.perform(get("/v1/weather/data").param("CITY", "xyz").contentType(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(status().isBadRequest());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void weatherForecastAverageTest() throws Exception {

		String city = "Pune";

		mvc.perform(get("api/weather/nearby-forecast")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.param("city", city))
				.andDo(print())
				.andExpect(status().isOk());


		mvc.perform(get("api/weather/nearby-forecast")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.param("city", city))
				.andDo(print())
				.andExpect(status().isNotFound());

		mvc.perform(get("api/weather/nearby-forecast")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}
*/
}
