package com.airconnect.masterdata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airconnect.common.model.Airline;
import com.airconnect.common.model.Country;
import com.airconnect.common.vo.AirlineVO;
import com.airconnect.masterdata.dao.AirlineDao;
import com.airconnect.masterdata.dao.CountryDao;

@Service("masterDataService")
@Transactional
public class MasterDataServiceImpl implements MasterDataService {

	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private AirlineDao airlineDao;
	
	public List<Country> fetchAllContries() {
		return countryDao.findAllCountries();
	}
	
	public List<Airline> fetchAllAirlines() {
		return airlineDao.findAllAirlines();
	}
	
	public List<AirlineVO> fetchAirlinesByCountryId(int countryId) {
		return getAirlines(airlineDao.findAirlinesByCountryId(countryId));
	}
	
	private List<AirlineVO> getAirlines(List<Airline> list) {
		List<AirlineVO> vList = new ArrayList<AirlineVO>();
		for(Airline airline :list) {
			AirlineVO vo = new AirlineVO();
			vo.setAirlineId(airline.getId());
			vo.setAirlineName(airline.getAirlineName());
			vList.add(vo);
		}
		return vList;
	}

}
