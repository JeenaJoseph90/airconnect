package com.airconnect.buyer.dao;

import java.util.List;

import com.airconnect.buyer.model.Buyer;

public interface MaterialBuyerDao {

	List<Buyer> findAllBuyers();

	void saveBuyer(Buyer buyer);
	
	public Buyer findById(int id);
	
	public void deleteById(int id);

}