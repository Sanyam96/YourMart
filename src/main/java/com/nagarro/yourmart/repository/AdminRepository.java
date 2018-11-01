package com.nagarro.yourmart.repository;

import com.nagarro.yourmart.config.AbstractBaseRepository;
import com.nagarro.yourmart.domains.Admin;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * @author Sanyam Goel created on 1/11/18
 */
@Repository
public class AdminRepository extends AbstractBaseRepository {

    public Admin authenticateAdmin(String username, String password) {
        Criteria criteria = this.getCurrentSession().createCriteria(Admin.class);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("password", password));
        Admin admin = (Admin) criteria.uniqueResult();
        return admin;
    }

}
