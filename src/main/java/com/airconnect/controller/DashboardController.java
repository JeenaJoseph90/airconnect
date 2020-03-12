package com.airconnect.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airconnect.common.utility.UserUtility;
import com.airconnect.dashboard.service.DashBoardService;

@Controller
@RequestMapping("/")
public class DashboardController {

	@Autowired
	DashBoardService dashBoardService;
	
	Map<String, String> data = new HashMap<String, String>();

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/", "/dashboard" }, method = RequestMethod.GET)
	public String showDashboard(ModelMap model, HttpSession session) {
		session.setAttribute("loggedinuser", UserUtility.getPrincipal());
		model.addAttribute("dataPointsList", getAirlinesByCountry());
		model.addAttribute("dashBoardData", getDashBoardData());
		return "dashboard";
	}

	private Map<String, Object> getDashBoardData() {
		return  dashBoardService.getDashboardData();
	}

	private  List<List<Map<Object, Object>>> getAirlinesByCountry() {
		return dashBoardService.getAirlinesByCountry();
	}

}
