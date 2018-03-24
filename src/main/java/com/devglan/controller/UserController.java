package com.devglan.controller;

import com.devglan.model.User;
import com.devglan.model.UserDto;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @RequestMapping(value="/sign-up", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }

}
