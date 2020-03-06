package com.airconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.airconnect.buyer.model.Buyer;
import com.airconnect.buyer.service.MaterialBuyerService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
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
        model.addAttribute("loggedinuser", getPrincipal());
        return "buyerlist";
    }
    
    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
    
}
