package com.airconnect.buyer.service;

import java.util.List;

import com.airconnect.buyer.model.Buyer;
import com.airconnect.masterdata.service.MasterDataService;

public interface MaterialBuyerService {

	List<Buyer> findAllBuyers();

	void saveBuyer(Buyer buyer);
	
	public Buyer findById(int id);
	
	public void deleteById(int id);

	void updateBuyer(Buyer buyer, MasterDataService masterDataService);

	List<Buyer> findBuyersByAirlineId(int id);

}