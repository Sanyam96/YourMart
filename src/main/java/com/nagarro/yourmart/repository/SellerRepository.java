package com.nagarro.yourmart.repository;

import com.nagarro.yourmart.config.AbstractBaseRepository;
import com.nagarro.yourmart.domains.Seller;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@Repository
public class SellerRepository extends AbstractBaseRepository {

    public Seller getSellerStatus(long id, String password) {
        Criteria criteria = this.getCurrentSession().createCriteria(Seller.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.add(Restrictions.eq("password", password));
//        System.out.println(criteria);
        Seller seller = (Seller) criteria.uniqueResult();
        return seller;
    }
}
