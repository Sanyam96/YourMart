package com.nagarro.yourmart.config;

import com.nagarro.yourmart.exceptions.YourMartHibernateException;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@Repository
public class AbstractBaseRepository {

    @PersistenceContext
    EntityManager entityManager;

    private ThreadLocal<Session> currentSession = new ThreadLocal();

    public AbstractBaseRepository() {
    }

    public Session getCurrentSession() {
        Session session = (Session) this.currentSession.get();
        return null != session ? session : (Session) this.entityManager.unwrap(Session.class);
    }

    public <T> List<T> getList(Class<T> clz) {
        try {
            return this.getCurrentSession().createCriteria(clz).list();
        } catch (HibernateException ex) {
            throw new YourMartHibernateException(String.format("Hibernate Exception occurred with cause %s", ex.getMessage()), ex);
        }
    }

    public <T> T getById(Serializable id, Class<T> clz) {
        T output = this.getCurrentSession().get(clz, id);
        if (output == null) {
            throw new YourMartResourceNotFoundException(String.format("resource for %s with id %s does not exists", clz.getName(), id.toString()));
        } else {
            return output;
        }

    }

}
