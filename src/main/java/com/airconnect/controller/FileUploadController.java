package com.airconnect.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileUploadController {

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/bulkbuyerupload", method = RequestMethod.GET)
	public String getUploadForm() {
		return "bulkbuyerupload";
	}
}
