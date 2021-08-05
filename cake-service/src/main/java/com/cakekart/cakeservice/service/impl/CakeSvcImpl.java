package com.cakekart.cakeservice.service.impl;

import com.cakekart.cakeservice.model.Cake;
import com.cakekart.cakeservice.model.Category;
import com.cakekart.cakeservice.repository.CakeRepository;
import com.cakekart.cakeservice.service.CakeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CakeSvcImpl implements CakeSvc {

    @Autowired
    CakeRepository cakeRepository;


    @Override
    public List<Cake> getAllCakes() {
        return cakeRepository.findAll();
    }

    @Override
    public List<Cake> getAllCakesByCategory(Category category) {
       return cakeRepository.findByCategory(category);
    }

    @Override
    public Cake getCakeById(String id) {
        return cakeRepository.findById(id).get();
    }

    @Override
    public List<Cake> getAllCakeByName(String name) {
        return cakeRepository.findCakeByName(name);
    }

    @Override
    public Cake addCake(Cake cake) {
        return cakeRepository.save(cake);
    }

    @Override
    public void deleteCake(String cakeId) {
        Optional<Cake> cake = cakeRepository.findById(cakeId);
        cakeRepository.delete(cake.get());
}


}
