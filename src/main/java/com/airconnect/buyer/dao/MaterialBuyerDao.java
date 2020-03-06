package com.airconnect.buyer.dao;

import java.util.List;

import com.airconnect.buyer.model.Buyer;

public interface MaterialBuyerDao {

	List<Buyer> findAllBuyers();

}