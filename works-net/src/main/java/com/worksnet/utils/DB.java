package com.worksnet.utils;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

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

//    private static SessionFactory buildSessionFactory() {
////        try {
////            // Create the SessionFactory from hibernate.cfg.xml
////            System.out.print(Conf.get("webinfPath"));
////            return new AnnotationConfiguration()
////                    .configure(Conf.get("webinfPath") + "/hibernate.cfg.xml")
////                    .buildSessionFactory();
////        } catch (Throwable ex) {
////            System.err.println("Initial SessionFactory creation failed." + ex);
////            throw new ExceptionInInitializerError(ex);
////        }
//    }

    @PostConstruct
    private void initSession() {
        session = getSessionFactory().openSession();
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Session getSession() {
        return session;
    }

    public int save(Object object) {
        return (int) getSession().save(object);
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
    public <T> List<T> find(String query) {
        return (List<T>) getSession().createQuery(query).list();
    }
}
