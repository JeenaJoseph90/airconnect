package com.airconnect.buyer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airconnect.buyer.dao.MaterialBuyerDao;
import com.airconnect.buyer.model.Buyer;

@Service("materialBuyerService")
@Transactional
public class MaterialBuyerServiceImpl implements MaterialBuyerService {
	
	@Autowired
	MaterialBuyerDao materialBuyerDao;

	@Override
	public List<Buyer> findAllBuyers() {
		return materialBuyerDao.findAllBuyers();
	}
}
