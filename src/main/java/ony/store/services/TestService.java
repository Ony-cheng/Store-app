package ony.store.services;

import ony.store.model.SomeEntity;
import ony.store.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;


    public void testMeth(){

        SomeEntity entity = new SomeEntity();
        entity.setName("Perthold");

        testRepository.save(entity);
        System.out.println("Maybe saved");

        System.out.println(testRepository.findAll().get(0).getName());
    }

}
