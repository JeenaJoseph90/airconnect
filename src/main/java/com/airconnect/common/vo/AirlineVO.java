package com.airconnect.common.vo;

import java.io.Serializable;

import com.airconnect.common.model.Country;

public class AirlineVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1823933216601347805L;

	private Integer airlineId;
	
	private String airlineName;
	
	private Country country;
	
	

	public Integer getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "AirlineVO [airlineId=" + airlineId + ", airlineName=" + airlineName + ", country=" + country + "]";
	}
	
	
	
}
