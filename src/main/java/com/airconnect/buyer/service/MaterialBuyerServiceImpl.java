package com.airconnect.buyer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airconnect.buyer.dao.MaterialBuyerDao;
import com.airconnect.buyer.model.Buyer;
import com.airconnect.common.model.Airline;
import com.airconnect.masterdata.service.MasterDataService;

@Service("materialBuyerService")
@Transactional
public class MaterialBuyerServiceImpl implements MaterialBuyerService {
	
	@Autowired
	MaterialBuyerDao materialBuyerDao;

	@Override
	public List<Buyer> findAllBuyers() {
		return materialBuyerDao.findAllBuyers();
	}

	@Override
	public void saveBuyer(Buyer buyer) {
		materialBuyerDao.saveBuyer(buyer);
	}

	@Override
	public Buyer findById(int id) {
		return materialBuyerDao.findById(id);
	}

	@Override
	public List<Buyer> findBuyersByAirlineId(int id) {
		return materialBuyerDao.findBuyersByAirlineId(id);
	}
	
	@Override
	public void updateBuyer(Buyer buyer, MasterDataService masterDataService) {
        Buyer entity = materialBuyerDao.findById(buyer.getId());
        System.err.println(entity.getAirline().getCountry().getCountryName());
        if(entity!=null){
            entity.setBuyerName(buyer.getBuyerName());
            Airline airline = masterDataService.findAirlineById(buyer.getAirline().getId());
            entity.setAirline(airline);
            entity.setDesignation(buyer.getDesignation());
            entity.setMobile(buyer.getMobile());
            entity.setPhone(buyer.getPhone());
            entity.setFax(buyer.getFax());
            entity.setEmail(buyer.getEmail());
        }
    }
	
	@Override
	public void deleteById(int id) {
		materialBuyerDao.deleteById(id);
	}
}
