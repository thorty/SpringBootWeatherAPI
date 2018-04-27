package de.thorstenweiskopf.wetherapi.services;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class WeatherResponseErrorHandler implements ResponseErrorHandler {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());		
	
	@Override
	  public void handleError(ClientHttpResponse response) throws IOException {
		
			logger.error("Error Happend during weather service call " +response.getStatusCode().toString() +" " +response.getStatusText() );		   			  
		    // throw new WeatherWebserviceException(response.getStatusText() + " calling weather webservice", response.getStatusCode());	    
	  }

	  @Override
	  public boolean hasError(ClientHttpResponse response) throws IOException {
	        if ( (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR)
	                || (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR))
	        {
	            return true;
	        }
	        return false;
	  }
	
	}
