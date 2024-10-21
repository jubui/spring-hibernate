package com.example;

import com.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
  public static void main(String[] args) {
    System.out.println("Started application");

    Session session = new Configuration().configure().buildSessionFactory().openSession();
    Transaction transaction = null;

    User user = new User();
    user.username = "superman";

    try {
      transaction = session.beginTransaction();
      session.save(user); // Persist the entity
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }

    System.out.println("Saved user with id: " + user.id);

    System.out.println("Finished running application");
  }
  private static SessionFactory buildSessionFactory() {
    try {
      return new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) {
      throw new ExceptionInInitializerError(ex);
    }
  }
}
