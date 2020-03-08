package com.airconnect.masterdata.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.airconnect.common.dao.AbstractDao;
import com.airconnect.common.model.Country;

@Repository("countryDao")
public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao {

	public Country findById(int id) {
		return getByKey(id);
	}

	public List<Country> findAllCountries() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("countryName"));
		return (List<Country>) crit.list();
	}

}
