package com.nagarro.yourmart.repository;

import com.nagarro.yourmart.config.AbstractBaseRepository;
import com.nagarro.yourmart.domains.Image;
import com.nagarro.yourmart.domains.Products;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sanyam Goel created on 4/11/18
 */
@Repository
public class ImageRepository extends AbstractBaseRepository {

    public List<Image> getImagesByProductId(long productId) {
        Criteria criteria = this.getCurrentSession().createCriteria(Image.class);
        criteria.add(Restrictions.eq("productId", productId));
        return criteria.list();
    }
}
