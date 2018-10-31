package com.nagarro.yourmart.config;

import com.nagarro.yourmart.exceptions.YourMartHibernateException;
import com.nagarro.yourmart.exceptions.YourMartResourceNotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
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

    public Serializable create(Object entity) {
        try {
            return this.getCurrentSession().save(entity);
        } catch (ConstraintViolationException var3) {
            throw new YourMartResourceNotFoundException(String.format("unable to create resource. constraint voilation exception for %s.", entity.toString()), var3);
        } catch (HibernateException var4) {
            throw new YourMartHibernateException(String.format("Hibernate Exception occurred with cause %s", var4.getMessage()), var4);
        }
    }

    public void update(Object entity) {
        try {
            this.getCurrentSession().update(entity);
        } catch (HibernateException var3) {
            throw new YourMartHibernateException(String.format("Hibernate Exception occurred with cause %s", var3.getMessage()), var3);
        }
    }

    public void delete(Object entity) {
        try {
            this.getCurrentSession().delete(entity);
        } catch (HibernateException var3) {
            throw new YourMartHibernateException(String.format("Hibernate Exception occurred with cause %s", var3.getMessage()), var3);
        }
    }

}
