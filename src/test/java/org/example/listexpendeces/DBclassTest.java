package org.example.listexpendeces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBclassTest {
    Configuration config;

//    @Test
//    void connect() {
//        DBclass db = new DBclass();
//        db.connect();
//        Wallet wallet = new Wallet("Icecream", 21.5);
//        System.out.println(db.connect());
//        config = new Configuration();
//        config.configure();
//        SessionFactory sessionFactory = config.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = session.beginTransaction();
//        session.save(wallet);
//        transaction.commit();
//    }
}