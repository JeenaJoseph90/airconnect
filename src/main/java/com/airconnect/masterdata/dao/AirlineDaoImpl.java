package com.airconnect.masterdata.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.airconnect.common.dao.AbstractDao;
import com.airconnect.common.model.Airline;

@Repository("airlineDao")
public class AirlineDaoImpl extends AbstractDao<Integer, Airline> implements AirlineDao {

	public Airline findById(int id) {
		return getByKey(id);
	}

	public List<Airline> findAllAirlines() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("airlineName"));
		return (List<Airline>) crit.list();
	}

	@Override
	public List<Airline> findAirlinesByCountryId(int countryId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("country.id", countryId));
		crit.addOrder(Order.asc("airlineName"));
		return (List<Airline>) crit.list();
	}

	@Override
	public Airline findAirlineByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("airlineName", name));
		return (Airline) crit.uniqueResult();
	}

}
