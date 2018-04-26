package de.thorstenweiskopf.wetherapi.services;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class WeatherResponseErrorHandler implements ResponseErrorHandler {
	  
	@Override
	  public void handleError(ClientHttpResponse response) throws IOException {	    
		  System.out.println("Error Happend");
		   {
		        throw new WeatherWebserviceException(response.getStatusText() + " calling weather webservice", response.getStatusCode(), true);
		    }

	    
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
