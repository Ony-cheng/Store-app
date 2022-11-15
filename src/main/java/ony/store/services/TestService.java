package ony.store.services;

import ony.store.entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestService {



    Car car= new Car();


    public void testMethod(){

        SessionFactory factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();

        car.setBrand("Wertypolt");
        car.setModel("Ynferderwerth");
        System.out.println("Testservice started hell eah");

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();

    }
}
