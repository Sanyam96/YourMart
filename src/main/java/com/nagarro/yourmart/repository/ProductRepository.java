package com.nagarro.yourmart.repository;

import com.nagarro.yourmart.config.AbstractBaseRepository;
import com.nagarro.yourmart.domains.Products;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sanyam Goel created on 30/10/18
 */
@Repository
public class ProductRepository extends AbstractBaseRepository {

    public List<Products> getProductsListBySellerId(Long sellerId, String productCode, String productName, Long productId, String sortParameter, Long categoryId, Long productStatusId, Long offset, Long limit) {
        Criteria criteria = this.getCurrentSession().createCriteria(Products.class);

        int offsetNumber = offset.intValue();
        int limitNumber = limit.intValue();

        criteria.setFirstResult(offsetNumber);

        if (sellerId != null) {
            criteria.add(Restrictions.eq("sellerId", sellerId));
        }

        if (productId != null) {
            criteria.add(Restrictions.eq("id", productId));
        }

        if (productCode != null) {
            criteria.add(Restrictions.like("productCode", ("%" + productCode + "%")));
        }

        if (productName != null) {
            criteria.add(Restrictions.like("productName", ("%" + productName + "%")));
        }

        if (sortParameter != null) {
            criteria.addOrder(Order.asc(sortParameter));
        }

        if (categoryId != null) {
            criteria.add(Restrictions.eq("categoryId", categoryId));
        }

        if (productStatusId != null) {
            criteria.add(Restrictions.eq("productStatusId", productStatusId));
        }

        criteria.setMaxResults(limitNumber);
        return criteria.list();
    }

    public Products getProductBySellerIdProductId(long sellerId, long productId) {
        Criteria criteria = this.getCurrentSession().createCriteria(Products.class);
        criteria.add(Restrictions.eq("sellerId", sellerId));
        criteria.add(Restrictions.eq("id", productId));
        Products product = (Products) criteria.uniqueResult();
        return product;
    }

    public List<Products> getCountOfProductByCategory(long categoryId) {
        Criteria criteria = this.getCurrentSession().createCriteria(Products.class);
        criteria.add(Restrictions.eq("categoryId", categoryId));
        return criteria.list();
    }
}
