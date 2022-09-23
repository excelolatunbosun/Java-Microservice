package com.in28mins.rest.webservices.restfulwebservices.service;


import com.in28mins.rest.webservices.restfulwebservices.user.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private User user;
    private static List<User> users = new ArrayList<>();

    private static int counterId = 0;

    static {
        users.add(new User(++counterId, "excel", LocalDate.now().minusYears(30)));
        users.add(new User(++counterId, "lisa", LocalDate.now().minusYears(20)));
        users.add(new User(++counterId, "kelly", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);

    }

    public User saveOne(User user){
        user.setId(++counterId);
         users.add(user);
         return user;
    }
}
