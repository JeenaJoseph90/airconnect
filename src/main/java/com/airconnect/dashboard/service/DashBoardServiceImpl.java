package com.airconnect.dashboard.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airconnect.buyer.service.MaterialBuyerService;
import com.airconnect.common.model.Airline;
import com.airconnect.common.model.Country;
import com.airconnect.masterdata.service.MasterDataService;
import com.airconnect.user.service.UserService;

@Service
public class DashBoardServiceImpl implements DashBoardService {

	
	@Autowired
	MasterDataService masterDataService;
	
	@Autowired
	MaterialBuyerService materialBuyerService;

	@Autowired
	UserService userService;
	
	
	@Override
	public List<List<Map<Object, Object>>> getAirlinesByCountry() {
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		Map<Object,Object> map = null;
		List<Map<Object,Object>> countryDataSet = new ArrayList<Map<Object,Object>>();
		List<Country> countries = masterDataService.fetchAllContries();
		for(Country country : countries) {
			map = new HashMap<Object,Object>(); 
			map.put("name", country.getCountryName()); 
			map.put("y", masterDataService.fetchAirlinesByCountryId(country.getId()).size());
			countryDataSet.add(map);
		}
		list.add(countryDataSet);
		return list;
	}
	
	@Override
	public Map<String, Object> getDashboardData() {
		Map<String,Object> data = new HashMap<String, Object>();
		Map<Object,Object> map = null;
		List<Map<Object,Object>> buyerDataSet = new ArrayList<Map<Object,Object>>();
		List<Airline> airlines = masterDataService.fetchAllAirlines();
		int totalBuyers = 0;
		for(Airline airline : airlines) {
			map = new HashMap<Object,Object>(); 
			int buyerCount =  materialBuyerService.findBuyersByAirlineId(airline.getId()).size();
			map.put("label", airline.getAirlineName()); 
			map.put("y", buyerCount);
			totalBuyers = totalBuyers + buyerCount;
			buyerDataSet.add(map);
		}
		data.put("buyersData", buyerDataSet);
		data.put("totalBuyers", totalBuyers);
		data.put("totalUsers", userService.findAllUsers().size());
		return data;
	}
	
	
}
