package com.cakekart.cakeservice.repository;

import com.cakekart.cakeservice.model.Cake;
import com.cakekart.cakeservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface CakeRepository extends MongoRepository<Cake,String> {
    List<Cake> findByCategory(Category category);

    List<Cake> findCakeByName(String name);


}
