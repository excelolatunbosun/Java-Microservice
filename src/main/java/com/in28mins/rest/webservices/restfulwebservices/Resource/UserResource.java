package com.in28mins.rest.webservices.restfulwebservices.Resource;


import com.in28mins.rest.webservices.restfulwebservices.service.UserDaoService;
import com.in28mins.rest.webservices.restfulwebservices.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }
    @GetMapping(value = "/users")
    public List<User> retrieveAllUsers(){
            return service.findAll();
    }
    @GetMapping("/user/{id}")
    public User getOneUser(@PathVariable int id){
        return service.findOne(id);
    }
    @PostMapping("/post")
    public ResponseEntity<User> postOne(@RequestBody User user){
        User savedUser = service.saveOne(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
