package com.axway.hashing.project.api;

import com.axway.hashing.project.beans.DbFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FileManager {

    private static SessionFactory sessionFactory = new Configuration().configure()
            .addAnnotatedClass(DbFile.class).buildSessionFactory();

    public FileManager() {
    }

    public void addInfo(DbFile file) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(file);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
