package com.airconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airconnect.buyer.model.Buyer;
import com.airconnect.buyer.service.MaterialBuyerService;

@Controller
public class MaterialBuyerController {

	@Autowired
    MaterialBuyerService materialBuyerService;
	
	 /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/buyers" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
 
        List<Buyer> buyers = materialBuyerService.findAllBuyers();
        model.addAttribute("buyers", buyers);
        return "buyerlist";
    }
    
}
