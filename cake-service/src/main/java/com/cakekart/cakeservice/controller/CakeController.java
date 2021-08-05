package com.cakekart.cakeservice.controller;

import com.cakekart.cakeservice.http.header.HeaderGenerator;
import com.cakekart.cakeservice.model.Cake;
import com.cakekart.cakeservice.model.Category;
import com.cakekart.cakeservice.model.Review;
import com.cakekart.cakeservice.service.CakeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController("/")
public class CakeController {

    @Autowired
    CakeSvc cakeSvc;

    @Autowired
    HeaderGenerator headerGenerator;


    @GetMapping(value = "/cakes")
    public ResponseEntity<List<Cake>> getAllCakes(){
         List<Cake> cakes =  cakeSvc.getAllCakes();
        if(!cakes.isEmpty()) {
            return new ResponseEntity<List<Cake>>(
                    cakes,
                    headerGenerator.getHeadersForSuccessGetMethod(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<List<Cake>>(
                headerGenerator.getHeadersForError(),
                HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/cakes", params = "category")
    public ResponseEntity<List<Cake>> getAllCakeByCategory(@RequestParam("category") Category category){
        List<Cake> cakes = cakeSvc.getAllCakesByCategory(category);
        if(!cakes.isEmpty()) {
            return new ResponseEntity<List<Cake>>(
                    cakes,
                    headerGenerator.getHeadersForSuccessGetMethod(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<List<Cake>>(
                headerGenerator.getHeadersForError(),
                HttpStatus.NOT_FOUND);
    }


    @GetMapping (value = "/cakes/{id}")
    public ResponseEntity<Cake> getOneCakeById(@PathVariable ("id") String id){
        Cake cake =  cakeSvc.getCakeById(id);
        if(cake != null) {
            return new ResponseEntity<Cake>(
                    cake,
                    headerGenerator.getHeadersForSuccessGetMethod(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<Cake>(
                headerGenerator.getHeadersForError(),
                HttpStatus.NOT_FOUND);
    }

    @GetMapping (value = "/cakes", params = "name")
    public ResponseEntity<List<Cake>> getAllCakesByName(@RequestParam ("name") String name){
        List<Cake> cakes =  cakeSvc.getAllCakeByName(name);
        if(!cakes.isEmpty()) {
            return new ResponseEntity<List<Cake>>(
                    cakes,
                    headerGenerator.getHeadersForSuccessGetMethod(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<List<Cake>>(
                headerGenerator.getHeadersForError(),
                HttpStatus.NOT_FOUND);
    }

}
