package de.thorstenweiskopf.wetherapi.domain;

public class WeatherInfo {
	
	private int id;
	private String name;
	
	/*
	private int isError = 0;
	private int httpCode = 200;
	private String ErrorMessage ="";	
	*/
	
	
	private Weather[] weather;

	public WeatherInfo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}

	
	
	
}
