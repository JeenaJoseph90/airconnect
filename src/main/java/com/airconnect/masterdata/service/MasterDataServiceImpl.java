package com.airconnect.masterdata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airconnect.common.model.Airline;
import com.airconnect.common.model.Country;
import com.airconnect.common.vo.MasterDataVO;
import com.airconnect.masterdata.dao.AirlineDao;
import com.airconnect.masterdata.dao.CountryDao;

@Service("masterDataService")
@Transactional
public class MasterDataServiceImpl implements MasterDataService {

	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private AirlineDao airlineDao;
	
	public List<MasterDataVO<Integer, String>> fetchAllContries() {
		return getMasterCountries(countryDao.findAllCountries());
	}
	
	public List<Airline> fetchAllAirlines() {
		return airlineDao.findAllAirlines();
	}
	
	public List<MasterDataVO<Integer, String>> fetchAirlinesByCountryId(int countryId) {
		return getMasterAirlines(airlineDao.findAirlinesByCountryId(countryId));
	}
	
	private List<MasterDataVO<Integer, String>> getMasterAirlines(List<Airline> list) {
		List<MasterDataVO<Integer, String>> vList = new ArrayList<MasterDataVO<Integer, String>>();
		for(Airline airline :list) {
			MasterDataVO<Integer, String> vo = new MasterDataVO<Integer, String>();
			vo.setKey(airline.getId());
			vo.setValue(airline.getAirlineName());
			vList.add(vo);
		}
		return vList;
	}
	
	private List<MasterDataVO<Integer, String>> getMasterCountries(List<Country> list) {
		List<MasterDataVO<Integer, String>> vList = new ArrayList<MasterDataVO<Integer, String>>();
		for(Country country :list) {
			MasterDataVO<Integer, String> vo = new MasterDataVO<Integer, String>();
			vo.setKey(country.getId());
			vo.setValue(country.getCountryName());
			vList.add(vo);
		}
		return vList;
	}
	
	public Airline findAirlineById(int id) {
		return airlineDao.findById(id);
	}

}
