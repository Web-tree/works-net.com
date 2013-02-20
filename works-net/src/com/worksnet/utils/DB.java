package com.worksnet.utils;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

/**
 * @author maxim.levicky
 *         Date: 2/19/13
 *         Time: 11:48 AM
 */
public class DB {
    private static final SessionFactory factory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration()
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory getSessionFactory() {
        return factory;
    }

    private static Session getSession() {
        return factory.getCurrentSession();
    }

    public static void save(Object object) {
        getSession().save(object);
    }

    public static void saveOrUpdate(Object object) {
        getSession().saveOrUpdate(object);
    }

    public static void delete(Object object) {
        getSession().delete(object);
    }

    public static <T> T get(Class<T> clazz, Serializable id) {
        return (T) getSession().get(clazz, id);
    }

    public static <T> T find(String query) {
        return (T) getSession().find(query);
    }
}
