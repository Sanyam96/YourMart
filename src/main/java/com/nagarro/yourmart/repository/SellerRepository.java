package com.nagarro.yourmart.repository;

import com.nagarro.yourmart.config.AbstractBaseRepository;
import com.nagarro.yourmart.domains.Categories;
import com.nagarro.yourmart.domains.Seller;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@Repository
public class SellerRepository extends AbstractBaseRepository {

    public List<Seller> getSellersPaginatedResult(Long offset, Long limit) {
        Criteria criteria = this.getCurrentSession().createCriteria(Seller.class);

        int offsetNumber = offset.intValue();
        int limitNumber = limit.intValue();

        criteria.setFirstResult(offsetNumber);
        criteria.setMaxResults(limitNumber);

        System.out.println("okok");
        return criteria.list();
    }

    public Seller getSellerStatus(long id, String password) {
        Criteria criteria = this.getCurrentSession().createCriteria(Seller.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.add(Restrictions.eq("password", password));
//        System.out.println(criteria);
        Seller seller = (Seller) criteria.uniqueResult();
        return seller;
    }


    public List<Seller> getSellersParamsResult(Long offset, Long limit, String sortBy, Long sellerId, Long sellerStatusId, String companyName, String ownerName, Long telephoneNumber) {
        Criteria criteria = this.getCurrentSession().createCriteria(Seller.class);
        int offsetNumber = offset.intValue();
        int limitNumber = limit.intValue();
        criteria.setFirstResult(offsetNumber);

        if(sortBy != null) {
            criteria.addOrder(Order.asc(sortBy));
        }

        if(sellerId != null) {
            criteria.add(Restrictions.eq("id", sellerId));
        }

        if(sellerStatusId != null) {
            criteria.add(Restrictions.eq("sellerStatusId", sellerStatusId));
        }

        if(companyName != null) {
            criteria.add(Restrictions.like("companyName", ("%" + companyName + "%")));
        }

        if(ownerName != null) {
            criteria.add(Restrictions.like("ownerName", ("%" + ownerName + "%")));
        }

        if(telephoneNumber != null) {
            criteria.add(Restrictions.eq("telephoneNumber", telephoneNumber));
        }

        criteria.setMaxResults(limitNumber);

        return criteria.list();
    }
}
