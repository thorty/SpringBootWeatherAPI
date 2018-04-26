package de.thorstenweiskopf.wetherapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.thorstenweiskopf.wetherapi.domain.WeatherInfo;
import de.thorstenweiskopf.wetherapi.services.WeatherWebserviceClient;


@RestController
public class WeatherController {

		
	WeatherWebserviceClient wsClient;
	
    @Autowired    
    public WeatherController(WeatherWebserviceClient wsCLient) {
        this.wsClient = wsCLient;
    } //DependencyInjection

	
	
	 @RequestMapping(value ="/weather/Neustadt", method = RequestMethod.GET)
	    public WeatherInfo home(){
		 	WeatherInfo info = wsClient.getData();
		 	if (info == null) {
		 		return new WeatherInfo();
		 	}
		 	return info;
	    }

	 @RequestMapping(value ="/weather/", method = RequestMethod.POST )
		 public WeatherInfo callWeatherStation(@RequestBody String location) {
		   System.out.println("POST Param = "+location);
		   return wsClient.getData(location);
	 }
	 
	 
	 
	 
	 //ToDo: Exception Handling
	 //ToDo: Deployment
	 //ToDo: Logging
	 
	 
	 
}
