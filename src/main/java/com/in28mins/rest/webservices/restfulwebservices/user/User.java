package com.in28mins.rest.webservices.restfulwebservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User{
    private Integer id;
    @Size(min=2)
    private String name;
    @Past
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
