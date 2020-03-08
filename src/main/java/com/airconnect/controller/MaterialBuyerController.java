package com.airconnect.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airconnect.buyer.model.Buyer;
import com.airconnect.buyer.service.MaterialBuyerService;
import com.airconnect.common.vo.MasterDataVO;
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
	@RequestMapping(value = { "/buyers" }, method = RequestMethod.GET)
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
		model.addAttribute("edit", false);
		return "addbuyer";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newbuyer" }, method = RequestMethod.POST)
	public String saveBuyer(@Valid Buyer buyer, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "addbuyer";
		}

		materialBuyerService.saveBuyer(buyer);

		model.addAttribute("success", "Buyer " + buyer.getBuyerName() + " registered successfully");
		// return "success";
		return "redirect:/buyers";
	}

	@RequestMapping(value = { "/getAirlineByCountryId" }, method = RequestMethod.GET)
	public @ResponseBody List<MasterDataVO<Integer,String>> getAirlinesByCountryId(@RequestParam(name = "countryId") int countryId) {
		List<MasterDataVO<Integer,String>> airlines = masterDataService.fetchAirlinesByCountryId(countryId);
		return airlines;
	}
	
	@RequestMapping(value = { "/getAllCountries" }, method = RequestMethod.GET)
	public @ResponseBody List<MasterDataVO<Integer,String>> getAllCountries() {
		List<MasterDataVO<Integer,String>> countries = masterDataService.fetchAllContries();
		return countries;
	}
	
	/**
	 * This method will provide the medium to update an existing buyer.
	 */
	@RequestMapping(value = { "/edit-buyer-{id}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String id, ModelMap model) {
		Buyer buyer = materialBuyerService.findById(Integer.valueOf(id));
		model.addAttribute("buyer", buyer);
		model.addAttribute("ctryId", buyer.getAirline().getCountry().getId());
		model.addAttribute("airId", buyer.getAirline().getId());
		model.addAttribute("edit", true);
		return "addbuyer";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-buyer-{id}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Buyer buyer, BindingResult result, ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
			return "addbuyer";
		}

		materialBuyerService.updateBuyer(buyer, masterDataService);

		model.addAttribute("success",
				"Buyer " + buyer.getBuyerName() + " updated successfully");
		return "redirect:/buyers";
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-buyer-{id}" }, method = RequestMethod.GET)
	public String deleteBuyer(@PathVariable String id, ModelMap model) {
		materialBuyerService.deleteById(Integer.valueOf(id));
		model.addAttribute("success",
				"Buyer deleted successfully");
		return "redirect:/buyers";
	}

}
