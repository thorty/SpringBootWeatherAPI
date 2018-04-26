package de.thorstenweiskopf.wetherapi.services;

import de.thorstenweiskopf.wetherapi.domain.WeatherInfo;

public interface WeatherWebService {

	public WeatherInfo getData();
	public WeatherInfo getData(String location);
}
