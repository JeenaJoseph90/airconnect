package com.airconnect.masterdata.dao;

import java.util.List;

import com.airconnect.common.model.Country;

public interface CountryDao {
	public Country findById(int id);
	public List<Country> findAllCountries();
}