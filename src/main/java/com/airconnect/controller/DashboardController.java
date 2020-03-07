package com.airconnect.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airconnect.common.utility.UserUtility;

@Controller
@RequestMapping("/")
public class DashboardController {

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/", "/dashboard" }, method = RequestMethod.GET)
	public String showDashboard(ModelMap model, HttpSession session) {
		session.setAttribute("loggedinuser", UserUtility.getPrincipal());
		return "dashboard";
	}

}
