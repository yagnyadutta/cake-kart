package com.cakekart.cakeservice.controller;

import com.cakekart.cakeservice.http.header.HeaderGenerator;
import com.cakekart.cakeservice.model.Cake;
import com.cakekart.cakeservice.service.CakeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
public class AdminCakeController {
    @Autowired
    private CakeSvc cakeSvc;

    @Autowired
    private HeaderGenerator headerGenerator;

    @PostMapping(value = "/cakes")
    private ResponseEntity<Cake> addCake(@RequestBody Cake cake, HttpServletRequest request){
        if(cake != null) {
            try {
                cakeSvc.addCake(cake);
                return new ResponseEntity<Cake>(
                        cake,
                        headerGenerator.getHeadersForSuccessPostMethod(request, cake.getId()),
                        HttpStatus.CREATED);
            }catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Cake>(
                        headerGenerator.getHeadersForError(),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Cake>(
                headerGenerator.getHeadersForError(),
                HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/cakes/{id}")
    private ResponseEntity<Void> deleteCake(@PathVariable("id") String id){
        Cake cake = cakeSvc.getCakeById(id);
        if(cake != null) {
            try {
                cakeSvc.deleteCake(id);
                return new ResponseEntity<Void>(
                        headerGenerator.getHeadersForSuccessGetMethod(),
                        HttpStatus.OK);
            }catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Void>(
                        headerGenerator.getHeadersForError(),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>(headerGenerator.getHeadersForError(), HttpStatus.NOT_FOUND);
    }
}
