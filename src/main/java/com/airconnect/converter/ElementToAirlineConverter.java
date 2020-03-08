package com.airconnect.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.airconnect.common.model.Airline;
import com.airconnect.masterdata.service.MasterDataService;

@Component
public class ElementToAirlineConverter implements Converter<Object, Airline>{

	@Autowired
	MasterDataService masterDataService;
	
	@Override
	public Airline convert(Object source) {
		Integer id = Integer.parseInt((String)source);
        Airline airline= masterDataService.findAirlineById(id);
        return airline;
	}

}
