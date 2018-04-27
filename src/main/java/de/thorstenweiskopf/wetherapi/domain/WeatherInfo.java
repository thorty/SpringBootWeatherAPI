package de.thorstenweiskopf.wetherapi.domain;

import java.util.Arrays;

public class WeatherInfo {
	
	private int id;
	private String name;
	
	
	private int isError = 0;
	private String error = "";
	private int status = 200;
	private String message ="";	
	
	
	
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

	public int getIsError() {
		return isError;
	}

	public void setIsError(int isError) {
		this.isError = isError;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "WeatherInfo [id=" + id + ", name=" + name + ", isError=" + isError + ", error=" + error + ", status="
				+ status + ", message=" + message + ", weather=" + Arrays.toString(weather) + "]";
	}



	
	
	
}
