package de.thorstenweiskopf.wetherapi.services;

import java.util.concurrent.ThreadLocalRandom;

import javax.xml.ws.WebServiceClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
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
		RestTemplate restTemplate  = createRestTemplate();		
		return getData("&lat=49.3537&lon=8.1361");
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
		WeatherInfo weather  = new WeatherInfo();
		try {
			ResponseEntity<WeatherInfo> responseEntity = restTemplate.exchange(url+"&"+location,HttpMethod.GET ,null, WeatherInfo.class);		
			weather = responseEntity.getBody();
			weather.setStatus(responseEntity.getStatusCode().value());
			weather.setMessage(responseEntity.getBody().getMessage());
			if (responseEntity.getStatusCodeValue() != 200) {				
				weather.setError("Error Connecting Weather Webservice");
				weather.setIsError(1);	
			}		
		} catch (ResourceAccessException ex) {				
				weather.setError("Error Connecting Weather Webservice");
				weather.setMessage(ex.getMessage().toString());
				weather.setStatus(999);
				weather.setIsError(1);				
		} catch (HttpServerErrorException | HttpClientErrorException ex) {		
			weather.setError("Error Connecting Weather Webservice");
			weather.setMessage(ex.getMessage().toString());
			weather.setStatus(ex.getStatusCode().value());
			weather.setIsError(1);	
		} 
		finally {
			return weather;
		}
		
		
	}
	
}
