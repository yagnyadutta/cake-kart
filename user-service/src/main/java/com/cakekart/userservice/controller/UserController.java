package com.cakekart.userservice.controller;

import com.cakekart.userservice.entity.User;
import com.cakekart.userservice.http.header.HeaderGenerator;
import com.cakekart.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    HeaderGenerator headerGenerator;


    @PostMapping
    private ResponseEntity<User> addUser(@RequestBody User user, HttpServletRequest request){
        if(user != null) {
            try {
                userService.save(user);
                return new ResponseEntity<User>(
                        user,
                        headerGenerator.getHeadersForSuccessPostMethod(request, user.getId()),
                        HttpStatus.CREATED);
            }catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<User>(
                        headerGenerator.getHeadersForError(),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<User>(
                headerGenerator.getHeadersForError(),
                HttpStatus.BAD_REQUEST);
    }


    @GetMapping
    public ResponseEntity<User> getUser(
            @RequestHeader(value = "id") String userId) {


        User user =  userService.getById(userId);
        if(user != null) {
            return new ResponseEntity<User>(
                    user,
                    headerGenerator.getHeadersForSuccessGetMethod(), HttpStatus.OK);
        }
        return new ResponseEntity<User>(
                headerGenerator.getHeadersForError(),
                HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "{id}")
    private ResponseEntity<Void> deleteCake(@PathVariable("id") String id){
        User user = userService.getById(id);
        if(user != null) {
            try {
                userService.deleteUser(id);
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
