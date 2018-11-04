package com.nagarro.yourmart.repository;

import com.nagarro.yourmart.config.AbstractBaseRepository;
import com.nagarro.yourmart.domains.Categories;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sanyam Goel created on 31/10/18
 */
@Repository
public class CategoryRepository extends AbstractBaseRepository {

    public List<Categories> getCategoriesPaginatedResult(Long offset, Long limit) {
        Criteria criteria = this.getCurrentSession().createCriteria(Categories.class);

        int offsetNumber = offset.intValue();
        int limitNumber = limit.intValue();

        criteria.setFirstResult(offsetNumber);
        criteria.setMaxResults(limitNumber);

        return criteria.list();
    }
}
