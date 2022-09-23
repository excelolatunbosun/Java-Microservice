package com.in28mins.rest.webservices.restfulwebservices.Helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(path =  "/hello")
    public String helloWorld(@RequestParam(value = "myName", defaultValue = "World") String myName){
        return String.format("Hello %S!", myName);
    }

    @GetMapping(path =  "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path =  "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world, %s", name));
//        return new HelloWorldBean("Hello World, " + name);
    }
}
