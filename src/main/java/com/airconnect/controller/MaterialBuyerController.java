package com.airconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airconnect.buyer.model.Buyer;
import com.airconnect.buyer.service.MaterialBuyerService;
import com.airconnect.common.model.Airline;
import com.airconnect.common.vo.AirlineVO;
import com.airconnect.masterdata.service.MasterDataService;

@Controller
public class MaterialBuyerController {

	@Autowired
    MaterialBuyerService materialBuyerService;
	
	@Autowired
    MasterDataService masterDataService;
	
	 /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/buyers" }, method = RequestMethod.GET)
    public String listBuyers(ModelMap model) {
 
        List<Buyer> buyers = materialBuyerService.findAllBuyers();
        model.addAttribute("buyers", buyers);
        return "buyerlist";
    }
    
    
    /**
	 * This method will provide the medium to add a new buyer.
	 */
	@RequestMapping(value = { "/newbuyer" }, method = RequestMethod.GET)
	public String newBuyer(ModelMap model) {
		Buyer buyer = new Buyer();
		model.addAttribute("buyer", buyer);
		model.addAttribute("countries", masterDataService.fetchAllContries());
		model.addAttribute("edit", false);
		return "addbuyer";
	}
	
	 @RequestMapping(value = {"/getAirlineByCountryId" }, method = RequestMethod.GET)
	    public @ResponseBody List<AirlineVO> getAirlinesByCountryId(@RequestParam(name = "countryId") int countryId) {
	        List<AirlineVO> airlines = masterDataService.fetchAirlinesByCountryId(countryId);
	        return airlines;
	    }

    
}
