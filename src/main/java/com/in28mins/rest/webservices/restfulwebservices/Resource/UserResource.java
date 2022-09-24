package com.in28mins.rest.webservices.restfulwebservices.Resource;


import com.in28mins.rest.webservices.restfulwebservices.service.UserDaoService;
import com.in28mins.rest.webservices.restfulwebservices.user.User;
import com.in28mins.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    //    public UserResource(UserDaoService service){
//        this.service = service;
//    }
    @GetMapping(value = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public User getOneUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id" + id);
        }
        return user;
    }

    @PostMapping("/post")
    public ResponseEntity<User> postOne(@RequestBody User user) {
        User savedUser = service.saveOne(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteOne(@PathVariable int id){
         service.deleteOne(id);

    }
}


