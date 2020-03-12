package com.airconnect.dashboard.service;

import java.util.List;
import java.util.Map;

public interface DashBoardService {

	List<List<Map<Object, Object>>> getAirlinesByCountry();

	Map<String, Object> getDashboardData();

}