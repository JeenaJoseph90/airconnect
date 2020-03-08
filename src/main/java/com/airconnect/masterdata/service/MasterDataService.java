package com.airconnect.masterdata.service;

import java.util.List;

import com.airconnect.common.model.Airline;
import com.airconnect.common.model.Country;
import com.airconnect.common.vo.AirlineVO;

public interface MasterDataService {

	List<Country> fetchAllContries();
	public List<Airline> fetchAllAirlines();
	public List<AirlineVO> fetchAirlinesByCountryId(int countryId);
	
}