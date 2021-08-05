package com.cakekart.cakeservice.service;

import com.cakekart.cakeservice.model.Cake;
import com.cakekart.cakeservice.model.Category;

import java.util.List;

public interface CakeSvc {
    public List<Cake> getAllCakes();
    public List<Cake> getAllCakesByCategory(Category category);
    public Cake getCakeById(String id);
    public List<Cake> getAllCakeByName(String name);
    public Cake addCake(Cake cake);
    public void deleteCake(String cakeId);
}

