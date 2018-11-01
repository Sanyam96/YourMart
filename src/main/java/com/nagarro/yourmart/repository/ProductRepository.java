package com.nagarro.yourmart.repository;

import com.nagarro.yourmart.config.AbstractBaseRepository;
import com.nagarro.yourmart.domains.Products;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@Repository
public class ProductRepository extends AbstractBaseRepository {

    public List<Products> getProductsListBySellerId(long sellerId) {
        Criteria criteria = this.getCurrentSession().createCriteria(Products.class);
        criteria.add(Restrictions.eq("sellerId", sellerId));
        System.out.println("okok");
        return criteria.list();
    }
}
