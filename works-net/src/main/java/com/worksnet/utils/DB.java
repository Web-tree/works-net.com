package com.worksnet.utils;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worksnet.model.Model;

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
        Serializable saved = getSession().save(object);
        return (int)saved;
    }

    public void update(Object object) {
        getSession().update(object);
        getSession().flush();
    }

    public int saveOrUpdate(Object object) {
        Object merged = getSession().merge(object);
        getSession().flush();
        return ((Model) merged).getId();
    }

    public void delete(Object object) {
        getSession().delete(object);
        getSession().flush();
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz, Serializable id) {
        return (T) getSession().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> find(String queryString) {
        Query query = getSession().createQuery(queryString);
        return (List<T>) query.list();
    }

    public Criteria createCriteria(Class clazz) {
        return getSession().createCriteria(clazz);
    }
}
