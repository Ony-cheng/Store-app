package ony.store.testservice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ony.store.model.Car;


public class TestService {



    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("org.hibernate.ony");

    EntityManager entityManager =entityManagerFactory.createEntityManager();

    public void hiberTest(){



        Car car = new Car();

        car.setId(1);
        car.setBrand("Daewoo");
        car.setModel("Lanos");

        entityManager.persist(car);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();

    }

}
