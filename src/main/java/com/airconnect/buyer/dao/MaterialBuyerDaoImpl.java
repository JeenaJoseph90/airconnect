package com.airconnect.buyer.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.airconnect.buyer.model.Buyer;
import com.airconnect.common.dao.AbstractDao;

@Repository("materialBuyerDao")
public class MaterialBuyerDaoImpl extends AbstractDao<Integer, Buyer> implements MaterialBuyerDao {
	
	@Override
    public List<Buyer> findAllBuyers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("buyerName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        @SuppressWarnings("unchecked")
		List<Buyer> buyers = (List<Buyer>) criteria.list();
        for(Buyer buyer : buyers){
            Hibernate.initialize(buyer.getAirline());
        }
         
        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return buyers;
    }

	@Override
	public void saveBuyer(Buyer buyer) {
		persist(buyer);
	}
	
	@Override
	public Buyer findById(int id) {
        Buyer buyer = getByKey(id);
        return buyer;
    }
	
	@Override
	public void deleteById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Buyer buyer = (Buyer)crit.uniqueResult();
        delete(buyer);
    }
	
	@Override
	public List<Buyer> findBuyersByAirlineId(int id) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("airline.id", id));
        List<Buyer> buyers =  crit.list();
        return buyers;
    }
	
}
