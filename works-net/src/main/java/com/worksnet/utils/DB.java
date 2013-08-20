package com.worksnet.utils;

import com.worksnet.model.Model;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    public void init() {
        session = sessionFactory.openSession();
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Session getSession() {
        return session;
    }


    public Transaction beginTransaction() {
        return getSession().beginTransaction();
    }

    public int save(Object object) {
        Serializable saved = getSession().save(object);
        getSession().clear();
        return (int) saved;
    }

    public void update(Object object) {
        getSession().update(object);
        getSession().clear();
    }

    public int saveOrUpdate(Object object) {
        Object merged = getSession().merge(object);
        getSession().clear();
        return ((Model) merged).getId();
    }

    public void delete(Object object) {
        getSession().delete(object);
        getSession().clear();
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

    public Query createQuery(String query) {
        return getSession().createQuery(query);
    }
}
