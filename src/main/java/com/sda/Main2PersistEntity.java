package com.sda;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main2PersistEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new Dog("Ares", 10, "Terier"));
        session.persist(new Dog("Sonia", 8, "Buldog"));
        session.persist(new Dog("Reksio", 11, "Doberman"));
        session.persist(new Dog("Benio", 7, "Jamink"));
        session.persist(new Dog("Aza", 12, "Wilczur"));
        session.persist(new Dog("Pimpek", 5, "Terier"));

        transaction.commit();
        session.close();
    }
}
