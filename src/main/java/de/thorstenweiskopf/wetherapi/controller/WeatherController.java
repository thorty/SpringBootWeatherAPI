package de.thorstenweiskopf.wetherapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.thorstenweiskopf.wetherapi.domain.WeatherInfo;
import de.thorstenweiskopf.wetherapi.services.WeatherWebserviceClient;


@RestController
public class WeatherController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());		
	WeatherWebserviceClient wsClient;
	
    @Autowired    
    public WeatherController(WeatherWebserviceClient wsCLient) {
        this.wsClient = wsCLient;
    } //DependencyInjection

	
	
	 @RequestMapping(value ="/weather/Neustadt", method = RequestMethod.GET)
	    public WeatherInfo home(){
		 	WeatherInfo info = wsClient.getData();
		 	return info;
	    }

	 @RequestMapping(value ="/weather/", method = RequestMethod.POST )
		 public WeatherInfo callWeatherStation(@RequestBody String location) {
		 logger.info("Request for /weather/ with POST. Param = "+location);
		 WeatherInfo info = wsClient.getData(location);
		 logger.info("Response = "+info.toString());
		 return info;
	 }
	 
	 
	 
	 
	 //ToDo: Deployment or Tomcat Configuration
	 //ToDo: AccessLog
	 //ToDo: AdminTools (Monitoring,..)
	 
	 
	 
}
