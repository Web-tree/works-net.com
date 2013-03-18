package com.worksnet.utils;

import com.worksnet.model.Model;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

/**
 * @author maxim.levicky
 *         Date: 2/19/13
 *         Time: 11:48 AM
 */
@Repository
public class DB {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    private void initSession() {
        session = getSessionFactory().openSession();
        session.setFlushMode(FlushMode.MANUAL);
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Session getSession() {
        return session;
    }

    public int save(Object object) {
        return ((Model) getSession().save(object)).getId();
    }

    public int saveOrUpdate(Object object) {
        return ((Model) getSession().merge(object)).getId();
    }

    public void delete(Object object) {
        getSession().delete(object);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz, Serializable id) {
        return (T) getSession().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> find(String queryString, String... params) {
        Query query = getSession().createQuery(queryString);
        int i = 1;
        for (String param : params) {
            query.setString(i++, param);
        }
        return (List<T>) query.list();
    }
}
