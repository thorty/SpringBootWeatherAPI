package de.thorstenweiskopf.wetherapi.services;

import java.util.concurrent.ThreadLocalRandom;

import javax.xml.ws.WebServiceClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.thorstenweiskopf.wetherapi.domain.WeatherInfo;

@Service("WeatherWebserviceClientService")
public class WeatherWebserviceClient implements WeatherWebService{

	private final String url= "http://api.openweathermap.org/data/2.5/weather?appid=903047e44a7b4e8316e91a017d9d0597";
	private @Value("${weatherServiceConntimeout}") int conntimeout;
	private @Value("${weatherServiceReadtimeout}") int readTimeout;
	
	
	public WeatherWebserviceClient() {
		
	}
	
	
	public WeatherInfo getData() {
		//return "The weather is still always fine! " + getRandomInt();	
		RestTemplate restTemplate  = createRestTemplate();
		WeatherInfo weather = restTemplate.getForObject(url+"&lat=49.3537&lon=8.1361", WeatherInfo.class);
		return weather;
	}
	
	private RestTemplate createRestTemplate() {
		
		
		int connTimeout;
		
		RestTemplate restTemplate  = new RestTemplate();
		((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(conntimeout);
		((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(readTimeout);
		restTemplate.setErrorHandler(new WeatherResponseErrorHandler());
		return restTemplate;
	}


	public WeatherInfo getData(String location) {
		RestTemplate restTemplate  = createRestTemplate();
		WeatherInfo weather = restTemplate.getForObject(url+"&"+location, WeatherInfo.class);
		return weather;
	}
	
}
