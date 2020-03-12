package com.airconnect.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.airconnect.buyer.model.Buyer;
import com.airconnect.buyer.model.BuyerList;
import com.airconnect.buyer.service.MaterialBuyerService;
import com.airconnect.common.model.Airline;
import com.airconnect.common.vo.MasterDataVO;
import com.airconnect.masterdata.service.MasterDataService;

@Controller
public class MaterialBuyerController {

	@Autowired
	MaterialBuyerService materialBuyerService;

	@Autowired
	MasterDataService masterDataService;
	
	private static List<Buyer> buyers = new ArrayList<Buyer>();

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
		List<MasterDataVO<Integer,String>> countries = masterDataService.getMasterCountries();
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
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("file") List<MultipartFile> files, ModelMap model) {
		List<Buyer> byrlist = null;
		// List < FileInfo > uploadedFiles = new ArrayList < FileInfo > ();
		if (!files.isEmpty()) {
			try {
					try {
						int i = 2;
						// Creates a workbook object from the uploaded excelfile
						XSSFWorkbook workbook = new XSSFWorkbook(files.get(0).getInputStream());
						// Creates a worksheet object representing the first sheet
						XSSFSheet worksheet = workbook.getSheetAt(0);
						// Reads the data in excel file until last row is encountered
						byrlist = new ArrayList<Buyer>();
						while (i <= worksheet.getLastRowNum()) {
							// Creates an object for the Candidate Model
							Buyer buyer = new Buyer();
							// Creates an object representing a single row in excel
							XSSFRow row = worksheet.getRow(i++);
							Airline airline = new Airline();
							airline.setAirlineName(row.getCell(0).getStringCellValue());
							buyer.setAirline(airline);
							buyer.setBuyerName(row.getCell(1).getStringCellValue());
							if(row.getCell(2) != null)
								buyer.setDesignation(row.getCell(2).getStringCellValue());
							if(row.getCell(3) != null)
								buyer.setPhone(row.getCell(3).getStringCellValue());
							if(row.getCell(4) != null)
								buyer.setMobile(row.getCell(4).getStringCellValue());
							if(row.getCell(5) != null)
								buyer.setEmail(row.getCell(5).getStringCellValue());
							if(row.getCell(6) != null)
								buyer.setFax(row.getCell(6).getStringCellValue());

							byrlist.add(buyer);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		BuyerList buyerslist = new BuyerList();
		buyerslist.setBuyerList(byrlist);
		model.addAttribute("bulkBuyers", buyerslist);
		return "bulkbuyerupload";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = "/saveBulkBuyers", method = RequestMethod.POST)
	public String validateAndSaveBulkBuyers(@ModelAttribute("bulkBuyers") BuyerList bulkBuyers, BindingResult result, ModelMap model) {

		List<Buyer> invalidEntries = new ArrayList<Buyer>();
		
		if (result.hasErrors()) {
			model.addAttribute("bulkBuyers", bulkBuyers);
			return "bulkbuyerupload";
		}
		
		for(Buyer buyer : bulkBuyers.getBuyerList()) {
			Airline  airline = masterDataService.findAirlineByName(buyer.getAirline().getAirlineName());
			if(airline == null) {
				invalidEntries.add(buyer);
			} else {
				buyer.getAirline().setId(airline.getId());
				buyer.getAirline().setAirlineName(null);
				materialBuyerService.saveBuyer(buyer);
			}
		}
		
		if(invalidEntries.size() > 0) {
			bulkBuyers.setBuyerList(invalidEntries);
			model.addAttribute("bulkBuyers",bulkBuyers);
			model.addAttribute("warning","The specified Airline/(Airlines) not found in the system. Please verify name and submit again...!!!");
			return "bulkbuyerupload";
		} else {
			model.addAttribute("success", "All Buyers registered successfully");
			return "redirect:/buyers";
		}
		
	}

}
